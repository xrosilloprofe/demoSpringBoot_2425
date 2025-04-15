package es.ieslavereda.demospringboot_2425.controller;

import es.ieslavereda.demospringboot_2425.repositoy.model.Articulo;
import es.ieslavereda.demospringboot_2425.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    //Endpoint de tipo GET
    @GetMapping("/articulos/")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(articuloService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/articulos/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int id){
        try {
            Articulo articulo = articuloService.getbyID(id);
            if (articulo==null)
                return new ResponseEntity<>("Artículo no encontrado", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(articulo, HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<?> deleteArticulo(@PathVariable("id") int id){
        try {
            Articulo articulo = articuloService.deleteArticulo(id);
            if (articulo==null)
                return new ResponseEntity<>("Artículo no encontrado", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(articulo, HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/articulos/")
    public ResponseEntity<?> addArticulo(@RequestBody Articulo articulo){
        try{
            Articulo articulo1 = articuloService.addArticulo(articulo);
            if (articulo1==null)
                return new ResponseEntity<>("El artículo ya existente", HttpStatus.FOUND);
            return new ResponseEntity<>(articulo1, HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/articulos/")
    public ResponseEntity<?> updateArticulo(@RequestBody Articulo articulo){
        try{
            Articulo articulo1 = articuloService.updateArticulo(articulo);
            if (articulo1==null)
                return new ResponseEntity<>("El artículo no existe", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(articulo1, HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
