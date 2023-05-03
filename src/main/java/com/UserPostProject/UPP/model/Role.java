package com.UserPostProject.UPP.model;

import com.UserPostProject.UPP.eum.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role", uniqueConstraints = {
        @UniqueConstraint(name = "uk_role_name", columnNames = "name"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")  //columnDefination = text means we can write anything without limit
    private String description;


}
