package br.edu.unipaulista.backend.Blog.domainModel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @Column(name = "TITLE")
    private @Getter @Setter String title;

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private @Getter @Setter String content;

    @ManyToOne
    private @Getter @Setter User user;

    @ManyToMany
    private @Getter @Setter Set<Tag> tags;
}
