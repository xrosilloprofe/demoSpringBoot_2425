package es.ieslavereda.demospringboot_2425.service;

import es.ieslavereda.demospringboot_2425.repositoy.ArticuloRepository;
import es.ieslavereda.demospringboot_2425.repositoy.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> getAll() throws SQLException {
        return articuloRepository.getAll();
    }

}
