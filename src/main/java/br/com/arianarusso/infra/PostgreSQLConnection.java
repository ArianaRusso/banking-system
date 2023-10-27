package br.com.arianarusso.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgreSQLConnection {

    private Connection connection;

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    private final static String url = resourceBundle.getString("DB_URL");
    private final static String user = resourceBundle.getString("DB_USER");
    private final static String password = resourceBundle.getString("DB_PASSWORD");


    public Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Conexão com o PostgreSQL bem-sucedida!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o PostgreSQL.");
            e.printStackTrace();
        }
        return connection;
    }
}
