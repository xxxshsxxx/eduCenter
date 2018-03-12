package ru.savshop.educenter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.savshop.educenter.model.User;
import ru.savshop.educenter.repository.UserRepository;

public class CurrentUserDetailService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("User is not exist");
        }
        return new CurrentUser(user);
    }
}
