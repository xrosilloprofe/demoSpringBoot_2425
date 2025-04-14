package es.ieslavereda.demospringboot_2425.repositoy;

import es.ieslavereda.demospringboot_2425.repositoy.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticuloRepository {

    @Autowired
    @Qualifier("mysqldatasource")
    private DataSource dataSource;

    public List<Articulo> getAll() throws SQLException{
        List<Articulo> articulos = new ArrayList<>();
        String query = "SELECT * FROM Articulo";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                //Articulo articulo = new Articulo(resultSet.getInt(1),...)
                articulos.add(Articulo.builder().id(resultSet.getInt(1))
                                .descArticulo(resultSet.getString(2))
                                .existencias(resultSet.getInt(3))
                                .pvp(resultSet.getDouble(4))
                                .categoriaId(resultSet.getInt(5)).build()
                        );
            }
        }
        return articulos;
    }

}
