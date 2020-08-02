package net.rhuanrocha.democadastrousuario.dtos;

import net.rhuanrocha.democadastrousuario.entities.Address;
import net.rhuanrocha.democadastrousuario.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserOutDto {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private List<AddressOutDto> address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<AddressOutDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressOutDto> address) {
        this.address = address;
    }

    public static UserOutDto of(User user){
        UserOutDto userOutDto = new UserOutDto();
        userOutDto.setId(user.getId());
        userOutDto.setName(user.getName());
        userOutDto.setCpf(user.getCpf());
        userOutDto.setEmail(user.getEmail());

        if(user.getAddresses() != null) {
            userOutDto.setAddress(
                    user.getAddresses()
                            .stream()
                            .map(AddressOutDto::of)
                            .collect(Collectors.toList())
            );
        }

        return userOutDto;
    }
}
