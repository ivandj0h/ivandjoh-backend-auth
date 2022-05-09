package com.ivandjoh.backendauth.repositories;

import com.ivandjoh.backendauth.domain.User;
import com.ivandjoh.backendauth.exceptions.IdAuthException;

public interface UserRepository {

    Integer create(String firsName, String lastName, String email, String password) throws IdAuthException;

    User findByEmailAndPassword(String email, String password) throws IdAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);


}
