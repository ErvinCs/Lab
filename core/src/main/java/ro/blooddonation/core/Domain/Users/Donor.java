package ro.blooddonation.core.Domain.Users;

import ro.blooddonation.core.Domain.Account;
import ro.blooddonation.core.Domain.Address;
import ro.blooddonation.core.Domain.Donation;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "donors")
public class Donor extends Person {
    
    @Column
    private Donation currDonation = null;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate currAppointment = null;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate lastDonation = null;

    @Column
    @ElementCollection
    private List<Donation> donationHistory;

    /**
     * Default constructor
     */
    public Donor() {}
    /**
     *
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param account: Account
     */
    public Donor(String firstName, String lastName, LocalDate bDay, String address, String residence, Long CNP,
                 Account account)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.donationHistory = new ArrayList<Donation>();
    }

    public Donation getCurrDonation() {
        return currDonation;
    }

    public void setCurrDonation(Donation currDonation) {
        this.currDonation = currDonation;
    }

    public LocalDate getCurrAppointment() {
        return currAppointment;
    }

    public void setCurrAppointment(LocalDate currAppointment) {
        this.currAppointment = currAppointment;
    }

    public LocalDate getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(LocalDate lastDonation) {
        this.lastDonation = lastDonation;
    }

    public List<Donation> getDonationHistory()
    {
        return this.donationHistory;
    }


    /**
     * If the history already contains donation, then update it, otherwise add donation to the history.
     * @param donation
     */
    public void updateDonationHistory(Donation donation)
    {
        for (Donation don : donationHistory)
        {
            if (don.getId().equals(donation.getId()))
            {
                donationHistory.set(donationHistory.indexOf(donation), donation);
                return;
            }
        }
        this.donationHistory.add(donation);
    }
}