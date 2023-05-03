package com.UserPostProject.UPP.model;

import com.UserPostProject.UPP.eum.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_name", columnNames = "name"),
        @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_user_mobileNumber", columnNames = "mobile_number")
})
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "name" , length = 25, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) //to  make the enum string otherwise it will give answer in 0/1
    @Column(name = "user_type",length = 10,nullable = false)
    private UserType userType;

    @Column(name = "email",length = 100 ,nullable = false)
    private String email;

    @Column(name = "mobile_number",length = 10,nullable = false)
    private String mobile_number;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role_generated_table")
    private List<Role> roleList;

    @OneToMany(mappedBy = "user",targetEntity = Post.class)
    private List<Post> postList;

}
