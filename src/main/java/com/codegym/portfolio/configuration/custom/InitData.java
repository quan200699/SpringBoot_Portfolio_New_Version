package com.codegym.portfolio.configuration.custom;

import com.codegym.portfolio.model.auth.Role;
import com.codegym.portfolio.model.auth.User;
import com.codegym.portfolio.model.entity.Module;
import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.model.entity.Program;
import com.codegym.portfolio.model.enum_file.RoleName;
import com.codegym.portfolio.service.module.ModuleService;
import com.codegym.portfolio.service.online_course.OnlineCourseService;
import com.codegym.portfolio.service.program.ProgramService;
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
    private ProgramService programService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        List<User> users = (List<User>) userService.findAll();
        List<Role> roleList = (List<Role>) roleService.findAll();
        List<OnlineCourse> onlineCourses = (List<OnlineCourse>) onlineCourseService.findAll();
        List<Program> programs = (List<Program>) programService.findAll();
        List<Module> modules = (List<Module>) moduleService.findAll();
        if (roleList.isEmpty()) {
            createDefaultRole();
        }
        if (users.isEmpty()) {
            createDefaultUser();
        }
        if (onlineCourses.isEmpty()) {
            createDefaultOnlineCourse();
        }
        if (programs.isEmpty()) {
            createDefaultProgram();
        }
    }

    private void createDefaultProgram() {
        Program program = new Program();
        program.setId(1L);
        program.setName("Bootcamp Java 2020");
        programService.save(program);
        program.setId(2L);
        program.setName("Bootcamp PHP 2020");
        programService.save(program);
    }

    private void createDefaultOnlineCourse() {
        OnlineCourse onlineCourse = new OnlineCourse();
        onlineCourse.setId(1L);
        onlineCourse.setName("Học cách học");
        onlineCourseService.save(onlineCourse);
        onlineCourse.setId(2L);
        onlineCourse.setName("Hoàn thành mọi việc với Kanban");
        onlineCourseService.save(onlineCourse);
        onlineCourse.setId(3L);
        onlineCourse.setName("Scrum Essence");
        onlineCourseService.save(onlineCourse);
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
