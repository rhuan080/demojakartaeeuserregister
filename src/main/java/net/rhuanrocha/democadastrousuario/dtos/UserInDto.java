package net.rhuanrocha.democadastrousuario.dtos;

import net.rhuanrocha.democadastrousuario.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class UserInDto {
    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.name.notblack}")
    private String name;

    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.cpf.notblack}")
    private String cpf;

    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.email.notback}")
    @Email(message = "{net.rhuanrocha.democadastrousuario.User.email.invalid}")
    private String email;

    @NotNull(message = "{net.rhuanrocha.democadastrousuario.User.addresses.notnull}")
    private List<AddressInDto> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressInDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressInDto> address) {
        this.address = address;
    }

    public User toEntity(){
        User user = new User();
        user.setName(this.name);
        user.setCpf(this.cpf);
        user.setEmail(this.email);
        user.setAddresses(
                this.address
                        .stream()
                        .map(AddressInDto::toEntity)
                        .collect(Collectors.toSet())
        );
        return user;
    }
}
