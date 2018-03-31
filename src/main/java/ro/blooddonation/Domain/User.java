package ro.blooddonation.Domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * 
 */
public abstract class User
{
    protected String firstName;
    protected String lastName;
    protected LocalDate bDay;
    protected Address address;
    protected Address residence;
    protected Long CNP;
    protected String username;
    protected String password;


    /**
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     */
    public User(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                     String username, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;
        this.address = address;
        this.residence = residence;
        this.CNP = CNP;
        this.username = username;
        this.password = password;
    }


    /**
     *
     * @return: the number of years between the current date and this User's birthday
     */
    public Integer getAge()
    {
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.bDay, now);
        return period.getYears();
    }

    /**
     * Update this User's fields if the parameters are present.
     * @param firstName: String
     * @param lastName: String
     * @param address: Address
     * @param residence: Address
     */
    public void updateAccount(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence)
    {
        String fn = firstName.isPresent() ? this.firstName = firstName.get() : null;
        String ln = lastName.isPresent() ? this.lastName = lastName.get() : null;
        Address addr = address.isPresent() ? this.address = address.get() : null;
        Address res = residence.isPresent() ? this.residence = residence.get() : null;
    }


    /**
     * Nuj ce facem cu metoda asta xD
     */
    public abstract void menu();

}