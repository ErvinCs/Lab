package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Donation;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "DONOR")
public class Donor extends User {

    private Donation currDonation = null;
    private LocalDate currAppointment = null;
    private LocalDate lastDonation = null;
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
    public Donor(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
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