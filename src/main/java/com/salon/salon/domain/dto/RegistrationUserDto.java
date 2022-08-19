package com.salon.salon.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationUserDto {
    @NotBlank(message = "{validation.user.name.not_blank}")
    @Size(min = 2, max = 50, message = "{validation.user.name.size}")
    private String name;
    private String password;
}