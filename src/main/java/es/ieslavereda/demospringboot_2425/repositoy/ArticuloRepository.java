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

    public List<Articulo> getAll() throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        String query = "SELECT * FROM Articulo";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                //Articulo articulo = new Articulo(resultSet.getInt(1),...)
                articulos.add(new Articulo(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getDouble(4), resultSet.getInt(5))
                );
            }
        }
        return articulos;
    }

    public Articulo getbyID(int id) throws SQLException {
        return null;
    }

    public Articulo deleteArticulo(int id) throws SQLException {
        return null;
    }

    public Articulo addArticulo(Articulo articulo) throws SQLException {
        return null;
    }

    public Articulo updateArticulo(Articulo articulo) throws SQLException {
        return null;
    }

}
