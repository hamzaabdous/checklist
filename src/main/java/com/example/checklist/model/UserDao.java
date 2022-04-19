package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDao implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "username null")
    @NotBlank(message = "saisir votre username")
    @Size(min = 3, message = "username  must have at least 3 characters")
    @Column(name="username")
    private String username;

    @NotNull(message = "lastName null")
    @Size(min = 3, message = "lastName  must have at least 3 characters")
    @NotBlank(message = "saisir votre lastName")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "firstName null")
    @Size(min = 3, message = "firstName  must have at least 3 characters")
    @NotBlank(message = "saisir votre firstName")
    @Column(name = "firstName")
    private String firstName;


    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_Number")
    private String phoneNumber;


    @Column(name="created_Date")
    private String createdDate;
    @Column(name="update_Date")
    private String updateDate;

    @JsonIgnoreProperties("userDaos")
    @ManyToOne()
    private Role role;

    @JsonIgnoreProperties("userDaoDeclaration")
    @OneToMany(mappedBy = "userDaoDeclaration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserDeclaration;

    @JsonIgnoreProperties("userDaoReceiving")
    @OneToMany(mappedBy = "userDaoReceiving",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReceiving;

    @JsonIgnoreProperties("userDaoReparation")
    @OneToMany(mappedBy = "userDaoReparation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReparation;

    @JsonIgnoreProperties("userDaoClosed")
    @OneToMany(mappedBy = "userDaoClosed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserClosed;

    @JsonIgnoreProperties("userList")
    @ManyToMany
    @JoinTable(name = "user_groupe",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_groupe"))
    private List<Groupe> groupeList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
