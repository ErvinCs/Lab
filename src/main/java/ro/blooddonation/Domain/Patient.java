package ro.blooddonation.Domain;

import java.time.LocalDate;

public class Patient extends User {

    protected Address hospitalAddress;
    protected Blood blood = null;

    /**
     *
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param username: String
     * @param password: String
     * @param hospitalAddress: Address
     */
    public Patient(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                   String username, String password, Address hospitalAddress)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.hospitalAddress = hospitalAddress;
    }


    public void menu()
    {
        //TODO: ???
    }

}