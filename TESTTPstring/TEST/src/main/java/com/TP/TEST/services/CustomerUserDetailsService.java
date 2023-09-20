package com.TP.TEST.services;

import com.TP.TEST.entity.User;
import com.TP.TEST.exceptions.UsernameAlreadyExistsException;
import com.TP.TEST.model.security.UserSecurity;
import com.TP.TEST.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
public class CustomerUserDetailsService implements UserDetailsService {

    private  final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var u = userRepo.findByUsername(username);
        User user =  u.orElseThrow(()-> new UsernameNotFoundException("username not found"));


        return  new UserSecurity(user);
    }



    @Transactional
    public  void createUser(User user){

        var u = userRepo.findByUsername(user.getUsername());
        //u.orElseThrow(UsernameAlreadyExistsException::new); or use

        if (u.isPresent()){
            throw  new UsernameAlreadyExistsException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
    }
}
