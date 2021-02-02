package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        Session session = context.getBean(SessionFactory.class).openSession();
//        session.beginTransaction();
//        User user = session.get(User.class, 5L);
//        System.out.println(user);
//        session.getTransaction().commit();
//        session.close();


        UserService userService = context.getBean(UserService.class);
        userService.FindUserByCarModelAndSeries("ferrari12", 1);

//        UserService userService = context.getBean(UserService.class);
//        Car car = new Car("ferrari12");
//        User user = new User("User12", "Lastname1", "user1@mail.ru",car);
//        userService.add(user);


//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }

        context.close();
    }
}
