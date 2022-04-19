package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="damageTypeRepository")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DamageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "name null")
    @NotBlank(message = "saisir votre name")
    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("damageTypeList")
    @ManyToOne
    private Groupe group;

    @JsonIgnoreProperties("damageTypeRepository")
    @OneToMany(mappedBy = "damageType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageList;
}
