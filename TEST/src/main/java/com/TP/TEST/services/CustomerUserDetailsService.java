package com.TP.TEST.services;

import com.TP.TEST.entity.User;
import com.TP.TEST.exceptions.UsernameAlreadyExistsException;
import com.TP.TEST.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
public class CustomerUserDetailsService implements UserDetailsService {

    private  final UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var u = userRepo.findByUsername(username);
        u.orElseThrow(()-> new UsernameNotFoundException("username not found"));


        return null;
    }

    public  void createUser(User user){

        var u = userRepo.findByUsername(user.getUsername());
        //u.orElseThrow(UsernameAlreadyExistsException::new); or use

        if (u.isPresent()){
            throw  new UsernameAlreadyExistsException();
        }

        userRepo.save(user);
    }
}
