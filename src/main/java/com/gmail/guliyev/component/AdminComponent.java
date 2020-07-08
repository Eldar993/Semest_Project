package com.gmail.guliyev.component;



import com.gmail.guliyev.entity.User;
import com.gmail.guliyev.enums.UserRoles;
import com.gmail.guliyev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
    public class AdminComponent implements CommandLineRunner {
        @Autowired
        UserService userService;

        @Override
        public void run(String...args){
            if(userService.existsByUserRole(UserRoles.ADMIN)){
                System.out.println("Admin already exists!");;

            }else {
                User admin = new User();
                admin.setName(userService.generateRandomString(1));
                admin.setPassword(userService.generateRandomString(1));
                admin.setUserRole(UserRoles.ADMIN);
                userService.saveAdmin(admin);
                System.out.println(admin.getName());
                System.out.println(admin.getPassword());
            }


        }
    }


