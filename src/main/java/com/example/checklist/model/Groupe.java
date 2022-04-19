package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="groupe")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="departement")
    private String departement;

    @JsonIgnoreProperties("groupeList")
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_groupe",joinColumns = @JoinColumn(name = "id_groupe"),inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserDao> userDaoList;

    @JsonIgnoreProperties("groupeList")
    @ManyToOne
    private Domaine domaine;

    @JsonIgnoreProperties("groupe")
    @OneToMany(mappedBy = "groupe",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Equipement> equipementList;

    @JsonIgnoreProperties("group")
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DamageType> damageTypeList;
}
