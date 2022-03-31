package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

   @PersistenceContext
  private /*SessionFactory*/ EntityManager sessionFactory;

//    @PersistenceContext
//    private EntityManager entityManager;


//    @Override
//    public List<User> showUsers() {
//        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
//    }
    public  void delete(Long id) {
        User us = sessionFactory.find(User.class, id);
        sessionFactory.remove(us);
    }
    public void update(Long id, String firstName/*, String lastName, String mail*/) {
        User us = sessionFactory.find(User.class, id);
        us.setFirstName(firstName);
        sessionFactory.merge(us);
    }
    public void update(Long id, String firstName, String lastName) {
        User us = sessionFactory.find(User.class, id);
        us.setFirstName(firstName);
        us.setLastName(lastName);
        sessionFactory.merge(us);
    }
    public void update(Long id, String firstName, String lastName, String email) {
        User us = sessionFactory.find(User.class, id);
        us.setFirstName(firstName);
        us.setLastName(lastName);
        us.setEmail(email);
        sessionFactory.merge(us);
    }
   // @Override
    public void add(User user) {
        sessionFactory.persist(user);
      // sessionFactory/*.getEntityManager()/*getCurrentSession()*/.save(user);
    }
    //@Transactional//(readOnly = true)
    //@Override
   // @SuppressWarnings("unchecked")
    public List<User> listUsers() {
     //  TypedQuery<User> query= (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery/*createNamedQuery*/("from User");
       //return query.getResultList();
       // return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
   return sessionFactory.createQuery("select s from User s", User.class).getResultList();
    }

//    public User getUserFromCar(Car car) {
//        return (User)sessionFactory.getCurrentSession().createQuery("from User as us where us.car.model=:mod and us.car.series=:ser")
//                .setParameter("mod", car.getModel()).setParameter("ser", car.getSeries()).getSingleResult();
//    }
}
