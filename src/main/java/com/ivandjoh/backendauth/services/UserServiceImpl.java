package com.ivandjoh.backendauth.services;

import com.ivandjoh.backendauth.domain.User;
import com.ivandjoh.backendauth.exceptions.IdAuthException;
import com.ivandjoh.backendauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws IdAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws IdAuthException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new IdAuthException("Invalid Email Format!!");

        Integer count = userRepository.getCountByEmail(email);
        if(count > 0)
            throw new IdAuthException("Email already Exist!");

        Integer userId = userRepository.create(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }
}
