package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Hospital;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
@Entity
@Table(name = "DOCTOR")
public class Doctor extends Person
{
    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long CNP;
    private Account account;

    private Hospital hospital;
    //private Account account;
    //private Long CNP;

    /**
     * Default constructor
     */
    public Doctor() {}

    /**
     *
     * @param firstName
     * @param lastName
     * @param bDay
     * @param address
     * @param residence
     * @param CNP
     * @param account
     * @param hospital
     */
    public Doctor(String firstName, String lastName, LocalDate bDay, Address address, Address residence,
                  Long CNP, Account account, Hospital hospital) //, Account account, Long CNP)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.hospital = hospital;
        //this.account = account;
        //this.CNP = CNP;
    }

//    public Long getCNP() {
//        return CNP;
//    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

//    public Account getAccount() {
//        return account;
//    }

//    public void setAccount(Account account) {
//        this.account = account;
//    }

    //Should the doctors be able to modify their account?
    /**
     *
     * @param hospital: Hospital
     * @param username: String
     * @param password: String
     */
    public void updateAccount(Optional<Hospital> hospital, Optional<String> username, Optional<String> password) {
        Hospital h = hospital.isPresent() ? this.hospital = hospital.get() : this.hospital;
        if (username.isPresent())
            this.account.setUsername(username.get());
        if (password.isPresent())
            this.account.setPassword(password.get());
    }

}