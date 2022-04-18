package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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

    @Column(name="username")
    private String username;

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

    //  @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("users")
    @ManyToOne
    private Role role;

    @JsonIgnoreProperties("userDeclaration")
    @OneToMany(mappedBy = "userDaoDeclaration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserDeclaration;

    @JsonIgnoreProperties("userReceiving")
    @OneToMany(mappedBy = "userDaoReceiving",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReceiving;

    @JsonIgnoreProperties("userReparation")
    @OneToMany(mappedBy = "userDaoReparation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReparation;

    @JsonIgnoreProperties("userClosed")
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
