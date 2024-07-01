package com.example.exam2ws.controller;

import com.example.exam2ws.entity.Juegos;
import com.example.exam2ws.entity.Usuarios;
import com.example.exam2ws.repository.JuegosRepository;
import com.example.exam2ws.repository.UsuariosRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class WSController {

    final
    UsuariosRepository usuariosRepository;
    JuegosRepository juegosRepository;

    public WSController(UsuariosRepository usuariosRepository, JuegosRepository juegosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.juegosRepository = juegosRepository;
    }

    @GetMapping("/api/orders/juegos")
    public ResponseEntity<HashMap<String, Object>> listaDeJuegos(){
        List<Juegos> listaDeJuegos = juegosRepository.findAll();

        HashMap<String, Object> responseJson = new HashMap<>();
        responseJson.put("result", "success");
        responseJson.put("data", listaDeJuegos);
        return ResponseEntity.ok(responseJson);
    }

    @GetMapping("/api/orders/juegos/{id}")
    public ResponseEntity<HashMap<String, Object>> obtenerJuegoPorNombre(@PathVariable("id") String idStr){

        HashMap<String, Object> responseJson = new HashMap<>();

        Integer id = Integer.parseInt(idStr);

        try{
           Optional<Juegos> optionalJuegos = juegosRepository.findById(id);
           if(optionalJuegos.isPresent()){
               responseJson.put("juego", optionalJuegos.get());
               return ResponseEntity.ok(responseJson);
           }
           else{
               responseJson.put("result", "error");
               responseJson.put("msg", "parámetros incorrectos");
               return ResponseEntity.badRequest().body(responseJson);
           }
        }
        catch(NumberFormatException e){
            responseJson.put("result", "error");
            responseJson.put("msg", "parámetros incorrectos");
            return ResponseEntity.badRequest().body(responseJson);
        }

    }

    @PostMapping("/api/orders/juegos/save")
    public ResponseEntity<HashMap<String, Object>> guardarJuego(@RequestBody Juegos juego) {

        HashMap<String, Object> responseMap = new HashMap<>();

        juegosRepository.save(juego);
        responseMap.put("result", "success");
        responseMap.put("data", juego.getIdjuego());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);

    }

    @PutMapping("/api/orders/juegos/save")
    public ResponseEntity<HashMap<String, Object>> actualizarJuego(@RequestBody Juegos juego) {

        HashMap<String, Object> responseMap = new HashMap<>();

        Optional<Juegos> optionalJuegos = juegosRepository.findById(juego.getIdjuego());
        if(optionalJuegos.isPresent()){
            juegosRepository.save(juego);
            responseMap.put("result", "success");
            responseMap.put("data", juego.getIdjuego());
            return ResponseEntity.ok(responseMap);
        }
        else{
            responseMap.put("result", "error");
            responseMap.put("msg", "parámetros incorrectos");
            return ResponseEntity.badRequest().body(responseMap);
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionExcepcion(HttpServletRequest request) {
        HashMap<String, String> responseMap = new HashMap<>();
        if(request.getMethod().equals("POST") || request.getMethod().equals("PUT")){
            responseMap.put("result", "error");
            responseMap.put("msg", "parámetros incorrectos");
        }
        return ResponseEntity.badRequest().body(responseMap);

    }

    @DeleteMapping("/api/orders/juegos/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> eliminarJuego(@PathVariable("id") String idStr){
        HashMap<String, Object> responseMap = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            if(juegosRepository.existsById(id)){
                juegosRepository.deleteById(id);
                responseMap.put("result", "success");
                responseMap.put("msg", "juego borrado");
                return ResponseEntity.ok(responseMap);
            }
            else {
                responseMap.put("result", "error");
                responseMap.put("msg", "parámetros incorrectos");
                return ResponseEntity.badRequest().body(responseMap);
            }
        }
        catch(NumberFormatException ex){
            responseMap.put("result", "error");
            responseMap.put("msg", "parámetros incorrectos");
            return ResponseEntity.badRequest().body(responseMap);
        }
    }

}
