package com.example.task8.Service;




import com.example.task8.model.User;

import java.util.List;


public interface UserService {

    void addUser(User user);

    void updateUser(Long id, User user);

    void removeUser(User user);

    User getUserById(Long id);

    List<User> getListUser();
}
