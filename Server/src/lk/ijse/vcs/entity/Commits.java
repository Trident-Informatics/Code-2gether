package lk.ijse.vcs.entity;

import javax.persistence.*;

public class Commits {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne
    private Branches branch;

    @OneToOne
    private Commits parent;

    @ManyToOne
    private Users author;
}
