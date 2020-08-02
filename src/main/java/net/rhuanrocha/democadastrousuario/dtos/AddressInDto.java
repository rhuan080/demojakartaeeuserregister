package net.rhuanrocha.democadastrousuario.dtos;

import net.rhuanrocha.democadastrousuario.entities.Address;

import javax.validation.constraints.NotBlank;

public class AddressInDto {
    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.Address.address.notblack}")
    private String address;

    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.Address.state.notblack}")
    private String state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address toEntity(){
        Address address = new Address();
        address.setAddress(this.address);
        address.setState(this.state);
        return address;
    }
}
