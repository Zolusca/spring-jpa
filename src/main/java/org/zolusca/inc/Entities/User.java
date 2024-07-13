package org.zolusca.inc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "user")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Role role;
}
