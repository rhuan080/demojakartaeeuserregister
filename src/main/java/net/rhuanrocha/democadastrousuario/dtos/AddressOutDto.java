package net.rhuanrocha.democadastrousuario.dtos;

import net.rhuanrocha.democadastrousuario.entities.Address;

public class AddressOutDto {
    private Long id;
    private String address;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static AddressOutDto of(Address address){
        AddressOutDto addressOutDto = new AddressOutDto();
        addressOutDto.setId(address.getId());
        addressOutDto.setAddress(address.getAddress());
        addressOutDto.setState(address.getState());
        return addressOutDto;
    }
}
