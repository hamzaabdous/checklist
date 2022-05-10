package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departement")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Departement  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("departement")
    // @JoinColumn(name = "id_departement")
    private List<Role> roles;
}
