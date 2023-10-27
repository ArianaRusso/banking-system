import br.com.arianarusso.infra.PostgreSQLConnection;

import java.util.Collections;

public class MainApp {
    public static void main(String[] args) {

        PostgreSQLConnection connection = new PostgreSQLConnection();
        connection.getConnection();
        System.out.println(connection);

    }
}
