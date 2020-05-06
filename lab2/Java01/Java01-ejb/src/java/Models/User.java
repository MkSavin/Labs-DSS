package Models;

import DataBase.DataBase;
import Interceptors.MessageSharerInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class User {

    private int id;
    private String name;
    private String position;

    @PostConstruct
    private void init() {
        id = 0;
        name = "";
        position = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int _id) {
        id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String _position) {
        position = _position;
    }

    @Override
    public String toString() {
        return "User { id: " + id + ", name: " + name + ", position: " + position + "}";
    }

    static Logger logger = LoggerFactory.getLogger(User.class);

    public static User Create(User user) {
        logger.info("Добавление нового пользователя: " + user);

        try {
            String query = "INSERT INTO `users` SET `name` = '" + user.getName() + "', `position` = '" + user.getPosition() + "'";

            PreparedStatement stmt =
                    DataBase.C().prepareStatement(query,
                            PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();

            if (resultSet.next())
                user.setId(resultSet.getInt(1));

            logger.info("Пользователь был успешно добавлен в БД с id = " + user.getId());

            return user;
        } catch (SQLException e) {
            logger.error("При выполнении запроса на добавление пользователя " + user + " произошла ошибка: " + e.getMessage());

            return null;
        }
    }
    
    @Interceptors(MessageSharerInterceptor.class)
    public static User GetUser(int id) {
        logger.info("Получение пользователя с id = " + id);

        try {
            String query = "SELECT * FROM `users` WHERE `id` = '" + id + "'";

            PreparedStatement stmt =
                    DataBase.C().prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            User user = new User();

            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPosition(resultSet.getString(3));
            }

            logger.info("Получен пользователь: " + user);

            return user;
        } catch (SQLException e) {
            logger.error("При выполнении запроса на получение пользователя " + id + " произошла ошибка: " + e.getMessage());

            return null;
        }
    }

    public static List<User> GetUsersList() {
        logger.info("Получение списка пользователей");

        try {
            ArrayList<User> users = new ArrayList<>();

            String query = "SELECT * FROM `users`";

            PreparedStatement stmt =
                    DataBase.C().prepareStatement(query);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPosition(resultSet.getString(3));

                users.add(user);
            }
            
            logger.info("Получен список пользователей, содержащий " + users.size() + " пользователей");

            return users;
        } catch (SQLException e) {
            logger.error("При выполнении запроса на получение пользователей произошла ошибка: " + e.getMessage());
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public static void Update(User user) {
        logger.info("Обновление пользователя: " + user);

        try {
            String query = "UPDATE `users` SET `name` = '" + user.getName() + "', `position` = '"+user.getPosition() + "' WHERE `id` = '" + user.getId() + "'";

            PreparedStatement stmt =
                    DataBase.C().prepareStatement(query,
                            PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();

            logger.info("Обновление пользователя было выполнено успешно");
        } catch (SQLException e) {
            logger.error("При выполнении запроса на изменение пользователя произошла ошибка: " + e.getMessage());
        }
    }

    public static void Delete(int id) {
        logger.info("Удаление пользователя с id = " + id);

        try {
            String query = "DELETE FROM `users` WHERE `id` = '" + id + "'";

            PreparedStatement stmt =
                    DataBase.C().prepareStatement(query);

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("При выполнении запроса на удаление пользователя произошла ошибка: " + e.getMessage());
        }
    }

}
