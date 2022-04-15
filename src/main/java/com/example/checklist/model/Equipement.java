package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="equipement")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="type_equipement")
    private String typeEquipement;

    @Column(name="description")
    private String description;

    @JsonIgnoreProperties("equipement")
    @OneToOne(mappedBy = "equipement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Damage damage;

    @JsonIgnoreProperties("equipementList")
    @ManyToOne
    private Groupe groupe;

}
