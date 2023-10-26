package br.com.arianarusso.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgreSQLConnection {

    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

        String url = resourceBundle.getString("DB_URL");
        String user = resourceBundle.getString("DB_USER");
        String password = resourceBundle.getString("DB_PASSWORD");

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
//            String url = System.getenv("DB_URL");
//            String user = System.getenv("DB_USER");
//            String password = System.getenv("DB_PASSWORD");

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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
