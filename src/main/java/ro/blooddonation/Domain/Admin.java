package ro.blooddonation.Domain;

public class Admin
{

    private String username;
    private String password;
    public Long id;
    private static Long idGen = Long.valueOf(1);

    /**
     *
     * @param username: String; unique
     * @param password: String
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = idGen;
        idGen += 1;
    }

}