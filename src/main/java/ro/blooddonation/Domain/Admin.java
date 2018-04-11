package ro.blooddonation.Domain;

public class Admin
{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    /**
     *
     * @param username: String; unique
     * @param password: String
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

}