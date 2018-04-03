package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Donation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

    public Address hospitalAddress;
    public Blood blood = null;
    public Double requestedBloodQuantity;
    public List<Donation> donations;
    public Integer urgency;

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
                   String username, String password, Address hospitalAddress, Integer urgency)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.hospitalAddress = hospitalAddress;
        this.donations = new ArrayList<Donation>();
        this.urgency = urgency;
    }


}