package br.edu.unipaulista.backend.Blog.domainModel;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_PROFILES")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter String bio;
    private @Getter @Setter String pictureUrl;

    @OneToOne(mappedBy = "profile")
    private @Getter @Setter User user;
}
