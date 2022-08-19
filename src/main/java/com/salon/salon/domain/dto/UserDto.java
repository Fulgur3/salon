package com.salon.salon.domain.dto;

import com.salon.salon.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String login;
    private String password;
    private String userName;
    private String email;
    private String phoneNumber;


    public static UserDto convert(User user){
        return new UserDto(user.getId(), user.getLogin(), user.getPassword(), user.getUserName(), user.getEmail(), user.getPhoneNumber());
    }
}
