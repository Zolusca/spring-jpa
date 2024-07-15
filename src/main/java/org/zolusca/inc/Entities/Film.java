package org.zolusca.inc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "film")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @ManyToOne(
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private Genre genre;
}
