package br.com.thiagocavalieri.forum.security;

import br.com.thiagocavalieri.forum.model.User;
import br.com.thiagocavalieri.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Wrong user details.");
    }
}
