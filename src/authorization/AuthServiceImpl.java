package authorization;

import java.util.HashMap;
import java.util.Map;
import java.sql.*;



public class AuthServiceImpl implements AuthService {

    public Map<String, String> users = new HashMap<>();

    //Загружаем из базы user.db данные HashMap users

    public AuthServiceImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:users.db")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM client");

            while (result.next()) {

                String login = result.getString("LOGIN");
                String password = result.getString("PASSWORD");


                users.put(login, password); //Заполняем Map
            }

        }

    }


    @Override
    public boolean authUser(String username, String password) {
        String pwd = users.get(username);
        return pwd != null && pwd.equals(password);
    }
}
