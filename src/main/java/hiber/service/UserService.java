package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(Long id);
    List<User> listUsers();

}
