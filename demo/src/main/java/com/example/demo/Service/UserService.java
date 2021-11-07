package com.example.demo.Service;

import com.example.demo.Entities.Role;
import com.example.demo.Entities.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleId(1L);
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleId(2L);
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserId(1L);
        adminUser.setUserName("admin123");
//        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserPassword("admin@pass");
//        adminUser.setUserFirstName("admin");
//        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
        user.setUserId(2L);
        user.setUserName("calin123");
        user.setUserPassword("calin@123");
//        user.setUserFirstName("calin");
//        user.setUserLastName("marcel");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

//    public User registerNewUser(User user) {
//        Role role = roleRepository.findById("User").get();
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(role);
//        user.setRole(userRoles);
 //       user.setUserPassword(getEncodedPassword(user.getUserPassword()));

//        return userRepository.save(user);
//    }

//    public String getEncodedPassword(String password) {
//        return passwordEncoder.encode(password);
//    }
}

