package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@MappedSuperclass
public abstract class Person
{
    @Id
    @Column
    private Long CNP;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate bDay;

    @AttributeOverrides({
                    @AttributeOverride(name = "address", column = @Column(name = "home_address")),
                    @AttributeOverride(name = "town", column = @Column(name = "home_town")),
                    @AttributeOverride(name = "country", column = @Column(name = "home_country"))
            })
    @Embedded
    private Address address;

    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "current_address")),
            @AttributeOverride(name = "town", column = @Column(name = "current_town")),
            @AttributeOverride(name = "country", column = @Column(name = "current_country"))
    })
    @Embedded
    private Address residence;

    @Column
    private Account account;

    /**
     * Default constructor
     */
    protected Person() {}
    /**
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: String
     * @param residence: String
     * @param CNP: Long
     * @param account: Account
     */
    protected Person(String firstName, String lastName, LocalDate bDay, Address address, Address residence,
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
     * @return: the number of years between the current date and this Person's birthday - int
     */
    public Integer getAge()
    {
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.bDay, now);
        return period.getYears();
    }

    /**
     * Update this Person's fields if the parameters are present.
     * @param firstName: String
     * @param lastName: String
     * @param address: Address
     * @param residence: Address
     */
    public void updateData(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence)
    {
        String fn = firstName.isPresent() ? this.firstName = firstName.get() : this.firstName;
        String ln = lastName.isPresent() ? this.lastName = lastName.get() : this.lastName;
        Address addr = address.isPresent() ? this.address = address.get() : this.address;
        Address res = residence.isPresent() ? this.residence = residence.get() : this.residence;
    }

    public void updateCredentials(Optional<String> username, Optional<String> password)
    {
        account.updateCredentials(username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person ))
            return false;

        return CNP != null && CNP.equals(((Person) o).getCNP());
    }

}