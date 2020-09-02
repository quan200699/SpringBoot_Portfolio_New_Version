package com.codegym.portfolio.configuration.custom;

import com.codegym.portfolio.model.auth.Role;
import com.codegym.portfolio.model.auth.User;
import com.codegym.portfolio.model.enum_file.RoleName;
import com.codegym.portfolio.service.online_course.OnlineCourseService;
import com.codegym.portfolio.service.role.RoleService;
import com.codegym.portfolio.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class InitData {
    @Autowired
    private OnlineCourseService onlineCourseService;

    @Autowired
    private IUserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        List<User> users = (List<User>) userService.findAll();
        List<Role> roleList = (List<Role>) roleService.findAll();
        if (roleList.isEmpty()) {
            createDefaultRole();
        }
        if (users.isEmpty()) {
            createDefaultUser();
        }
    }

    private void createDefaultUser() {
        User admin = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, RoleName.ADMIN.toString()));
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(roles);
        userService.save(admin);
    }

    private void createDefaultRole() {
        Role roleAdmin = new Role();
        roleAdmin.setId(1L);
        roleAdmin.setName(RoleName.ADMIN.toString());
        roleService.save(roleAdmin);
        Role roleCoach = new Role();
        roleCoach.setId(2L);
        roleCoach.setName(RoleName.COACH.toString());
        roleService.save(roleCoach);
    }

}
