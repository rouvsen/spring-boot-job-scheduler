package com.rouvsen.service;

import com.rouvsen.dao.UserDao;
import com.rouvsen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private final UserDao dao;

    private static final Logger LOGGER =
            Logger.getLogger(UserService.class);

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    // schedule a job to add object in DB (Every 5 sec)
    @Scheduled(fixedRate = 5000)// 5000 millisecond = 5 sec
    public void add2DBJob(){
        User user = new User("Amigos"
                        + new Random().nextInt(377500));
        dao.save(user);
        System.out.println("add service call in "
        + new Date());
    }

    @Scheduled(cron = "0/15 * * * * *")// 15second, *sec *min *day * *
    public void fetchDBJob(){
        List<User> users = dao.findAll();
        System.out.println("fetch service call in " + new Date());
        System.out.printf("currently users size: %s%n", users.size());
        LOGGER.info(String.format("users: %s", users));
    }

}
