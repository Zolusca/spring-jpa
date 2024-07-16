package org.zolusca.inc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "course")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String name;
    @ManyToMany(
            mappedBy = "courses",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )

    private List<Student> students;
}
