package hiber.service;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void FindUserByCarModelAndSeries(String model, int series) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Session session = context.getBean(SessionFactory.class).openSession();

        String hqlCar =
                "from User pr1 " +
                "where pr1.car.model =  :model" +
                "  and pr1.car.series = :series";

        Query query = session.createQuery(hqlCar);
        query.setParameter("model", model);
        query.setParameter("series", series);
        session.beginTransaction();
        User user = (User) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        context.close();
        System.out.println(user);

    }


    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
