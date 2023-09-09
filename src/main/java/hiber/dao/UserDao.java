package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void delete(User user);
   void edit(User user);
   User getById(Long id);
   List<User> listUsers();
}
