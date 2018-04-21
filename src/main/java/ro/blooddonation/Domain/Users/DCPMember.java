package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.DoningCenter;
import ro.blooddonation.Exceptions.AppointmentException;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Entity
@Table(name = "DCPMEMBER")
public class DCPMember extends Person
{
    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long CNP;
    private Account account;

    private DoningCenter doningCenter;
    //private Account account;
    //private Long CNP;

    /**
     * Default constructor
     */
    public DCPMember() {}

    /**
     *
     * @param firstName
     * @param lastName
     * @param bDay
     * @param address
     * @param residence
     * @param CNP
     * @param account
     * @param doningCenter
     */
    public DCPMember(String firstName, String lastName, LocalDate bDay, Address address, Address residence,
                     Long CNP, Account account, DoningCenter doningCenter) //, Account account, Long CNP)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.doningCenter = doningCenter;
        //this.account = account;
        //this.CNP = CNP;
    }

//    public Long getCNP() {
//        return CNP;
//    }

    public DoningCenter getDoningCenter() {
        return doningCenter;
    }

    public void setDoningCenter(DoningCenter doningCenter) {
        this.doningCenter = doningCenter;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    //Should the DCP be able to modify their accounts?
    /**
     *
     * @param doningCenter: DoningCenter
     * @param username: String
     * @param password: String
     */
    public void updateAccount(Optional<DoningCenter> doningCenter, Optional<String> username, Optional<String> password)
    {
        DoningCenter dc = doningCenter.isPresent() ? this.doningCenter = doningCenter.get() : this.doningCenter;
        if (username.isPresent())
            this.account.setUsername(username.get());
        if (password.isPresent())
            this.account.setPassword(password.get());
    }
}