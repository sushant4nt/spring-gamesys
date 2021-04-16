package org.example.springbootapp.security;

import org.example.springbootapp.models.Privilege;
import org.example.springbootapp.models.Role;
import org.example.springbootapp.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private Map<String, User> users;

    public MyUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        // My dummer user database
        // TODO: build a UserRepo and potentially a UserService
        users = new ConcurrentHashMap<>();
        Role userRole = new Role("USER", Arrays.asList(Privilege.READ));
        Role adminRole = new Role("ADMIN", Arrays.asList(Privilege.READ, Privilege.WRITE));
        users.put("stuart", new User("stuart", passwordEncoder.encode("trauts"), adminRole));
        users.put("dave", new User("dave", passwordEncoder.encode("evad"), userRole));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.get(username);
        if (user != null) {
            return new MyUserDetails(user);
        } else {
            throw new UsernameNotFoundException(String.format("Who's %s?", username));
        }
    }
}
