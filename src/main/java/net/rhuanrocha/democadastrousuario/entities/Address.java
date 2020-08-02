package net.rhuanrocha.democadastrousuario.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.Address.address.notblack}")
    private String address;

    @Column
    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.Address.state.notblack}")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
