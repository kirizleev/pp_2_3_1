package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private EntityManager entityManager;

   @PersistenceContext
   public void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public void delete(User user) {
      entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
   }

   @Override
   public void edit(User user) {
      entityManager.merge(user);
   }

   @Override
   public User getById(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   @RequestMapping(method = RequestMethod.GET)
   public List<User> listUsers() {
      TypedQuery<User> query=entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }
}
