package hiber.dao;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }



   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void FindUserByCarModelAndSeries(String model, int series) {
      Session session =sessionFactory.getCurrentSession();

      String hqlCar =
              "from User pr1 " +
                      "where pr1.car.model =  :model" +
                      "  and pr1.car.series = :series";

      Query query = session.createQuery(hqlCar);
      query.setParameter("model", model);
      query.setParameter("series", series);
//      session.beginTransaction();
      User user = (User) query.getSingleResult();
//      session.getTransaction().commit();
//      session.close();
      System.out.println(user);

   }

}
