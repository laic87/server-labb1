package bo.handler;

import db.persistance.UserDAL;
import bo.mapper.UserMapper;
import bo.model.User;

public class UserHandler {

    public static boolean login(String username, String password) {
        return UserDAL.loginUser(username, password);
    }

    public static boolean createUser(User user) {
        return UserDAL.createUser(UserMapper.mapToUserEntityFromUser(user));
    }

    public static User getUser(int id) { return UserMapper.mapToUserFromUserEntity(UserDAL.getUser(id)); }

    public static User getUser(String username) { return UserMapper.mapToUserFromUserEntity(UserDAL.getUser(username)); }
}
