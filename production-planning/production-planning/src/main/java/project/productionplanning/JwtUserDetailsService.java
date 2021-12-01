/*
package project.productionplanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.productionplanning.model.User;
import project.productionplanning.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username)
        );
        if (username.equals(user.getUserUsername())) {
            return new org.springframework.security.core.userdetails.User(user.getUserUsername(), user.getUserPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
*/
