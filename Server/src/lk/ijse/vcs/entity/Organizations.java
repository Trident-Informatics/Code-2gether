package lk.ijse.vcs.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Organizations extends SuperID{

    @Column(unique = true)
    private String name;
    private LocalDateTime creation_date;

    @ManyToMany
    private List<Users> users;

    @OneToMany
    private List<Repositories> repositories;

    public Organizations() {
    }

    public Organizations(Integer id, String name, LocalDateTime creation_date) {
        super(id);
        this.setName(name);
        this.setCreation_date(creation_date);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
