package ro.blooddonation.Domain;

import javax.persistence.Embeddable;
import java.util.Optional;

@Embeddable
public class Account
{
    private String username;
    private String password;

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

    public void updateCredentials(Optional<String> username, Optional<String> password)
    {
        if (username.isPresent())
            this.setUsername(username.get());
        if (password.isPresent())
             this.setPassword(password.get());
    }

}
