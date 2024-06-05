package com.barmao.school_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a School.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School {

    /**
     * The unique identifier for the school.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the school.
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * The location of the school.
     */
    @Column(name = "location", nullable = false, length = 100)
    private String location;

    /**
     * The name of the principal of the school.
     */
    @Column(name = "principal_name", nullable = false, length = 100)
    private String principalName;
}
