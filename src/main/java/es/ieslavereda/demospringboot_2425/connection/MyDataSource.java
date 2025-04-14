package es.ieslavereda.demospringboot_2425.connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean(name="mysqldatasource")
    public static DataSource getDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/bbddEmpresa2425");
        dataSource.setUser("empresa2425");
        dataSource.setPassword("1111");
        return dataSource;
    }
}
