package com.usermanager.UserManager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    @NotBlank(message = "Nome é obrigatório.")
    private String name;

    @NotBlank(message = "Nome de usuário é obrigatório.")
    private String userName;

    @NotBlank(message = "Email é obrigatório.")
    private String email;

    @Size(min=6, message = "Senha deve conter no minino 6 caracteres.")
    @NotBlank(message = "Senha é obrigatória.")
    private String password;

}
