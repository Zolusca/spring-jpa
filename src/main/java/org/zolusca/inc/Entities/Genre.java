package org.zolusca.inc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "genre")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(unique = true)
    private String name;
    @OneToMany(
            mappedBy = "genre",
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Film> films;
}
