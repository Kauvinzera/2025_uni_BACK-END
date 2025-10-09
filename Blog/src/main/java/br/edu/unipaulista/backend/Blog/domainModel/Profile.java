package br.edu.unipaulista.backend.Blog.domainModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Profile {
    @Id

    private @Getter @Setter long id;
    private @Getter @Setter String bio;
    private @Getter @Setter String pictureUrl;

    @OneToOne(cascade = CascadeType.ALL)
    private @Getter @Setter String user;
}
