package com.example.examen.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import com.example.examen.entity.Juegos;
import com.example.examen.repository.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class ApiController {
    final DistribuidorasRepository distribuidorasRepository;
    final EditorasRepository editorasRepository;
    final FacturaRepository facturaRepository;
    final GenerosRepository generosRepository;
    final JuegosRepository juegosRepository;
    final JuegosxusuarioRepository juegosxusuarioRepository;
    final PaisesRepository paisesRepository;
    final PlataformasRepository plataformasRepository;
    final UsuariosRepository usuariosRepository;

    public ApiController(DistribuidorasRepository distribuidorasRepository, EditorasRepository editorasRepository,
                         FacturaRepository facturaRepository, GenerosRepository generosRepository,
                         JuegosRepository juegosRepository, JuegosxusuarioRepository juegosxusuarioRepository,
                         PaisesRepository paisesRepository, PlataformasRepository plataformasRepository,
                         UsuariosRepository usuariosRepository){
        this.distribuidorasRepository = distribuidorasRepository;
        this.editorasRepository = editorasRepository;
        this.facturaRepository = facturaRepository;
        this.generosRepository = generosRepository;
        this.juegosRepository = juegosRepository;
        this.juegosxusuarioRepository = juegosxusuarioRepository;
        this.paisesRepository = paisesRepository;
        this.plataformasRepository = plataformasRepository;
        this.usuariosRepository = usuariosRepository;
    }


    //LISTAR
    @GetMapping(value = {"/listaJuegos", ""})
    public List<Juegos> listaJuegos() {
        return juegosRepository.findAll();
    }

    //OBTENER
    @GetMapping(value = "/{id}")
    public ResponseEntity<HashMap<String, Object>> buscarJuego(@PathVariable("id") String idStr) {

        try {
            int id = Integer.parseInt(idStr);
            Optional<Juegos> byId = juegosRepository.findById((long) id);

            HashMap<String, Object> respuesta = new HashMap<>();

            if (byId.isPresent()) {
                respuesta.put("result", "succes");
                respuesta.put("juego", byId.get());
            } else {
                respuesta.put("result", "no existe");
            }
            return ResponseEntity.ok(respuesta);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // ACTUALIZAR
    @PutMapping(value = {"", "/"}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> actualizar(Juegos juegoRecibido) {

        HashMap<String, Object> rpta = new HashMap<>();

        if (juegoRecibido.getIdjuego() != null && juegoRecibido.getIdjuego() > 0) {

            Optional<Juegos> byId = juegosRepository.findById(juegoRecibido.getIdjuego().longValue());
            if (byId.isPresent()) {
                Juegos juegoFromDb = byId.get();

                if (juegoRecibido.getNombre() != null)
                    juegoFromDb.setNombre(juegoRecibido.getNombre());

                if (juegoRecibido.getDescripcion() != null)
                    juegoFromDb.setDescripcion(juegoRecibido.getDescripcion());

                if (juegoRecibido.getPrecio() != null)
                    juegoFromDb.setPrecio(juegoRecibido.getPrecio());

                if (juegoRecibido.getImage() != null)
                    juegoFromDb.setImage(juegoRecibido.getImage());

                if (juegoRecibido.getGeneros() != null)
                    juegoFromDb.setGeneros(juegoRecibido.getGeneros());

                if (juegoRecibido.getPlataformas() != null)
                    juegoFromDb.setPlataformas(juegoRecibido.getPlataformas());

                if (juegoRecibido.getEditoras() != null)
                    juegoFromDb.setEditoras(juegoRecibido.getEditoras());

                if (juegoRecibido.getDistribuidoras() != null)
                    juegoFromDb.setDistribuidoras(juegoRecibido.getDistribuidoras());

                juegosRepository.save(juegoFromDb);
                rpta.put("result", "ok");
                return ResponseEntity.ok(rpta);
            } else {
                rpta.put("result", "succes");
                rpta.put("msg", "El ID del juego enviado no existe");
                return ResponseEntity.badRequest().body(rpta);
            }
        } else {
            rpta.put("result", "error");
            rpta.put("msg", "debe enviar un juego con ID");
            return ResponseEntity.badRequest().body(rpta);
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionException(HttpServletRequest request) {
        HashMap<String, Object> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap.put("result", "error");
            responseMap.put("msg", "parametros incorrectos");
            responseMap.put("date", LocalDateTime.now());
        }
        return ResponseEntity.badRequest().body(responseMap);
    }

}
