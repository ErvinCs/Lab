package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public abstract class User
{
    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long CNP;
    private Account account;

    /**
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param account: Account
     */
    protected User(String firstName, String lastName, LocalDate bDay, Address address, Address residence,
                   Long CNP, Account account)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;
        this.address = address;
        this.residence = residence;
        this.CNP = CNP;
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getResidence() {
        return residence;
    }

    public void setResidence(Address residence) {
        this.residence = residence;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return CNP - Long
     */
    public Long getCNP()
    {
        return this.CNP;
    }

    /**
     * @return bDay - LocalDate
     */
    public LocalDate getbDay()
    {
        return this.bDay;
    }

    /**
     * @return: the number of years between the current date and this User's birthday - int
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
    public void updateAccount(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence,
                              Optional<String> username, Optional<String> password)
    {
        String fn = firstName.isPresent() ? this.firstName = firstName.get() : this.firstName;
        String ln = lastName.isPresent() ? this.lastName = lastName.get() : this.lastName;
        Address addr = address.isPresent() ? this.address = address.get() : this.address;
        Address res = residence.isPresent() ? this.residence = residence.get() : this.residence;
        if (username.isPresent())
            this.account.setUsername(username.get());
        if (password.isPresent())
            this.account.setPassword(password.get());
    }

}