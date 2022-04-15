package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

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
    @OneToMany(mappedBy = "userDeclaration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserDeclaration;

    @JsonIgnoreProperties("userReceiving")
    @OneToMany(mappedBy = "userReceiving",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReceiving;

    @JsonIgnoreProperties("userReparation")
    @OneToMany(mappedBy = "userReparation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserReparation;

    @JsonIgnoreProperties("userClosed")
    @OneToMany(mappedBy = "userClosed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageUserClosed;

    @JsonIgnoreProperties("userList")
    @ManyToMany
    @JoinTable(name = "user_groupe",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_groupe"))
    private List<Groupe> groupeList;
}
