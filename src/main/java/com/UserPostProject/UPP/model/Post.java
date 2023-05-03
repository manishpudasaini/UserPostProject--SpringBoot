package com.UserPostProject.UPP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "title",length = 100,nullable = false)
    private String title;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_path",nullable = false)
    private String image_path;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = User.class)
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_post_userId"))
    private User user;

    @OneToMany(targetEntity = Like.class,mappedBy = "post")
    private List<Like> likeList;

}
