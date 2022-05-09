package com.ivandjoh.backendauth.services;

import com.ivandjoh.backendauth.domain.User;
import com.ivandjoh.backendauth.exceptions.IdAuthException;

import javax.security.auth.message.AuthException;

public interface UserService {

    User validateUser(String email, String password) throws IdAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws IdAuthException;
}
