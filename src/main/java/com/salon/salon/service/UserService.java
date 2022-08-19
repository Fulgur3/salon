package com.salon.salon.service;

import com.salon.salon.domain.models.User;
import com.salon.salon.domain.dto.UserDto;
import com.salon.salon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Invalid user id"+ id));
    }

    public User getUserByEmail(String email){
        User user= userRepository.findByEmail(email);
        if(user==null) {
            throw new UsernameNotFoundException(email);
        }
        return user;
    }

    public void createUser(UserDto userDTO){
        User user=User.builder()
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .status("user").build();
        userRepository.save(user);
    }

    public void deleteUser(long id){
        User user=getUserById(id);
        userRepository.delete(user);
    }

    public void updateUser(long id, UserDto userDTO){
        User user=getUserById(id);

        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
    }

}
