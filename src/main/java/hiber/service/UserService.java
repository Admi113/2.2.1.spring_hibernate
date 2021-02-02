package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    void FindUserByCarModelAndSeries(String model,int series);

    List<User> listUsers();


}
