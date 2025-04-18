package es.ieslavereda.demospringboot_2425.repositoy;

import es.ieslavereda.demospringboot_2425.repositoy.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
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
        Articulo articulo = null;
        String query = "SELECT * FROM Articulo where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            articulo = new Articulo(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getDouble(4), resultSet.getInt(5));
        }

        return articulo;
    }

    public Articulo deleteArticulo(int id) throws SQLException {
        Articulo articulo = null;
        String query = "DELETE FROM Articulo where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            articulo = getbyID(id);
            if(articulo!=null){
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            }
        }
        return articulo;
    }

    public Articulo addArticulo(Articulo articulo) throws SQLException {
        String query = "INSERT INTO Articulo(descArticulo, existencias, pvp, categoriaId) VALUES (?,?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, articulo.getDescArticulo());
            preparedStatement.setInt(2,articulo.getExistencias());
            preparedStatement.setDouble(3,articulo.getPvp());
            preparedStatement.setInt(4,articulo.getCategoriaId());
            preparedStatement.executeUpdate();

        }
        return articulo;
    }

    public Articulo updateArticulo(Articulo articulo) throws SQLException {
        String query = "UPDATE Articulo set descArticulo = ?, existencias = ?, pvp = ?, categoriaId = ? WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, articulo.getDescArticulo());
            preparedStatement.setInt(2,articulo.getExistencias());
            preparedStatement.setDouble(3,articulo.getPvp());
            preparedStatement.setInt(4,articulo.getCategoriaId());
            preparedStatement.setInt(5,articulo.getId());
            preparedStatement.executeUpdate();

        }
        return articulo;
    }

}
