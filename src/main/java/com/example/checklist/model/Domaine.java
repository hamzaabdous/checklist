package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="domaine")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("domaine")
    @OneToMany(mappedBy = "domaine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Groupe> groupeList;
}
