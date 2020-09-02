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
        if (modules.isEmpty()) {
            createDefaultModule();
        }
    }

    private void createDefaultModule() {
        Program java = new Program();
        java.setId(1L);
        Program php = new Program();
        php.setId(2L);
        Module module = new Module();
        module.setId(1L);
        module.setName("[BC-JAVA-BP] Module 1: Bootcamp Preparation 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(2L);
        module.setName("[BC-JAVA-APJ] Module 2: Advanced Programming with Java 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(3L);
        module.setName("[BC-JAVA-JWBD] Module 3: Java Web Back-end Development 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(4L);
        module.setName("[BC-JAVA-WBDS] Module 4: Web Back-end Development with Spring MVC 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(5L);
        module.setName("[BC-JAVA-WFDA] Module 5: Web Front-end Development Angular 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(6L);
        module.setName("[BC-JAVA-PRJ] Module 6: Project and Jobs 2.0");
        module.setProgram(java);
        moduleService.save(module);
        module.setId(7L);
        module.setName("[BC-PHP-BP] Module 1: Bootcamp Preparation 2.0");
        module.setProgram(php);
        moduleService.save(module);
        module.setId(8L);
        module.setName("[BC-PHP-BP] Module 1: Bootcamp Preparation 2.0");
        module.setProgram(php);
        moduleService.save(module);
        module.setId(9L);
        module.setName("[BC-PHP-APP] Module 2: Advanced Programming with PHP 2.0");
        module.setProgram(php);
        moduleService.save(module);
        module.setId(10L);
        module.setName("[BC-PHP-WBDL] Module 3: Web Back-end Development with Laravel 2.0");
        module.setProgram(php);
        moduleService.save(module);
        module.setId(11L);
        module.setName("[BC-PHP-WFDA] Module 4: Web Front-end Development Angular 2.0");
        module.setProgram(php);
        moduleService.save(module);
        module.setId(12L);
        module.setName("[BC-PHP-WBDS] Module 5: Project and Jobs 2.0");
        module.setProgram(php);
        moduleService.save(module);
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
