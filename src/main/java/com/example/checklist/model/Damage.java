package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="damage")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Damage  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private String status;

    @JsonIgnoreProperties("damageUserDeclaration")
    @ManyToOne
    private User userDeclaration;

    @JsonIgnoreProperties("damageUserReceiving")
    @ManyToOne
    private User userReceiving;

    @JsonIgnoreProperties("damageUserReparation")
    @ManyToOne
    private User userReparation;

    @JsonIgnoreProperties("damageUserClosed")
    @ManyToOne
    private User userClosed;

    @Column(name="description")
    private String description;

    @Column(name="type_damage")
    private String typeDamage;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="update_date")
    private Date updateDate;

    @JsonIgnoreProperties("damage")
    @OneToOne
    @JoinColumn(name="equipement_id")
    private Equipement equipement;
}