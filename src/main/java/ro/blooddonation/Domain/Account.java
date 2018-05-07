package ro.blooddonation.Domain;

import ro.blooddonation.Domain.Users.Person;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "Accounts")
public class Account
{
    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person owner;

    /**
     * Default constructor
     */
    public Account() {}

    /**
     *
     * @param username
     * @param password
     */
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void updateCredentials(Optional<String> username, Optional<String> password)
    {
        if (username.isPresent())
            this.setUsername(username.get());
        if (password.isPresent())
             this.setPassword(password.get());
    }

}
