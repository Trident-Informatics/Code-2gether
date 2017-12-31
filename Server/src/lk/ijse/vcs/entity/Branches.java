package lk.ijse.vcs.entity;

import javax.persistence.*;
import java.util.List;

public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne
    private Repositories repository;

    private String name;

    @OneToMany
    private List<Commits> commits;
}
