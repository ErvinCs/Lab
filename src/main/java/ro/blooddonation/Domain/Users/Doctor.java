package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Hospital;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Doctor
{
    private Hospital hospital;
    private Account account;
    private Long CNP;

    /**
     *
     * @param hospital: Hospital
     * @param account: Account
     */
    public Doctor(Hospital hospital, Account account, Long CNP)
    {
        this.hospital = hospital;
        this.account = account;
        this.CNP = CNP;
    }

    public Long getCNP() {
        return CNP;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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