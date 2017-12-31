package lk.ijse.vcs.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Users extends SuperID{

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime join_date;

    @OneToMany
    private List<Repositories> repositories;

    public Users() {
    }

    public Users(Integer id, String username, String email, String password, LocalDateTime join_date) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.join_date = join_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getJoin_date() {
        return join_date;
    }

    public void setJoin_date(LocalDateTime join_date) {
        this.join_date = join_date;
    }
}
