package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.DoningCenter;
import ro.blooddonation.Exceptions.AppointmentException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class DCPMember
{
    private DoningCenter doningCenter;
    private Account account;
    private Long CNP;

    /**
     * Default constructor
     */
    public DCPMember() {}
    /**
     *
     * @param doningCenter: DoningCenter
     * @param account: Account
     */
    public DCPMember(DoningCenter doningCenter, Account account, Long CNP)
    {
        this.doningCenter = doningCenter;
        this.account = account;
        this.CNP = CNP;
    }

    public Long getCNP() {
        return CNP;
    }

    public DoningCenter getDoningCenter() {
        return doningCenter;
    }

    public void setDoningCenter(DoningCenter doningCenter) {
        this.doningCenter = doningCenter;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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