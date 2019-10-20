package bo.mapper;

import java.util.List;
import java.util.ArrayList;
import bo.model.User;

public class UserMapper {
    public static List<db.entity.User> mapToUserEntityListFromUserList(List<User> source){
        if(source == null || source.isEmpty()) return null;
        List<db.entity.User> resultList = new ArrayList<>();
        source.forEach((p) -> {
            resultList.add(mapToUserEntityFromUser(p));
        });
        return resultList;
    }

    public static db.entity.User mapToUserEntityFromUser(User source){
        if(source == null) return null;
        db.entity.User result = new db.entity.User();
        result.setId(source.getId());
        result.setUsername(source.getUsername());
        result.setPassword(source.getPassword());
        result.setFirstname(source.getFirstname());
        result.setLastname(source.getLastname());
        result.setAge(source.getAge());
        result.setUserCreated(source.getUserCreated());
        return result;
    }

    public static User mapToUserFromUserEntity(db.entity.User source) {
        User user = new User();
        user.setId(source.getId());
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setFirstname(source.getFirstname());
        user.setLastname(source.getLastname());
        user.setAge(source.getAge());
        user.setUserCreated(source.getUserCreated());
        return user;
    }
}
