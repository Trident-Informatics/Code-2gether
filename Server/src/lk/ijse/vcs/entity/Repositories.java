package lk.ijse.vcs.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"owner","name"})
})
public class Repositories {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    @ManyToOne
    private SuperID owner;
    private String name;
    private LocalDateTime creation_date;

    @OneToMany
    private List<Branches> branches;
}
