package com.UserPostProject.UPP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "like_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "post_id",foreignKey = @ForeignKey(name = "fk_likeTable_postId"))
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = User.class)
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_likeTable_userId"))
    private User user;

}
