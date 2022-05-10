package com.example.checklist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="domain")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("domain")
    @OneToMany(mappedBy = "domain",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Groupe> groupeList;
}
