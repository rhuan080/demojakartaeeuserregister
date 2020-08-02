package net.rhuanrocha.democadastrousuario.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@NamedQueries({
        @NamedQuery(
            name = User.QUERY_FIND_ALL,
            query = "FROM User u join fetch u.addresses "
        ),
        @NamedQuery(
                name = User.QUERY_BY_ID,
                query = "FROM User u join fetch u.addresses t where u.id = :id"
        )
})
@Entity
@Table(name = "_user")
public class User {

    public static final String QUERY_FIND_ALL = "User.findAll";
    public static final String QUERY_BY_ID = "User.findById";

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.name.notblack}")
    private String name;

    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.cpf.notblack}")
    @Column
    private String cpf;

    @NotBlank(message = "{net.rhuanrocha.democadastrousuario.User.email.notback}")
    @Email(message = "{net.rhuanrocha.democadastrousuario.User.email.invalid}")
    @Column
    private String email;

    @NotNull(message = "{net.rhuanrocha.democadastrousuario.User.addresses.notnull}")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses;

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
