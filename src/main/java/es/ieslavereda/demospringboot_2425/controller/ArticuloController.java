package es.ieslavereda.demospringboot_2425.controller;

import es.ieslavereda.demospringboot_2425.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

}
