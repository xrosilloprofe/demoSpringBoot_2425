package es.ieslavereda.demospringboot_2425.controller;

import es.ieslavereda.demospringboot_2425.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
