package org.zolusca.inc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "role")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
