package es.ieslavereda.demospringboot_2425.service;

import es.ieslavereda.demospringboot_2425.repositoy.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

}
