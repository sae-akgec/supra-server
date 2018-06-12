package in.saeakgec.supra.service.Impl;

import in.saeakgec.supra.model.Authority;
import in.saeakgec.supra.model.User;
import in.saeakgec.supra.repository.AuthorityRepository;
import in.saeakgec.supra.repository.UserRepository;
import in.saeakgec.supra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Optional<Authority> authority = authorityRepository.findById((long) 1);
        if(authority.isPresent()){
            List<Authority> authorities = new ArrayList<>();
            authorities.add(authority.get());
            user.setAuthorities(authorities);
        }
        User user1 = userRepository.save(user);
        return user1;
    }
}
