package ro.blooddonation.Domain;

import java.time.LocalDate;

public class Admin
{

    private String username;
    private String password;
    protected Long id;
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

    /**
     * @return new Doctor object
     */
    public Doctor createDoctor(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                               String username, String password, Hospital hospital)
    {
        return new Doctor(firstName, lastName, bDay, address, residence, CNP, username, password, hospital);
    }

    /**
     * @param CNP: Long
     */
    public void removeDoctor(Long CNP)
    {
        // TODO: calls remove from the repo; coupling?
    }

}