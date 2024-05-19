package com.aslam.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "aslam", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount, "gulam", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount, "afrin", LocalDate.now().minusYears(21)));

    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == (id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == (id);
        users.removeIf(predicate);
    }
}
