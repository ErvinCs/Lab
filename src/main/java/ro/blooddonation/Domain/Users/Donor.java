package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Donation;

import java.time.LocalDate;
import java.util.*;

public class Donor extends User {

    public Donation currDonation;
    public LocalDate currAppointment = null;
    public LocalDate lastDonation = null;
    private List<Donation> donationHistory;

    public Donor(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                 String username, String password)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.donationHistory = new ArrayList<Donation>();
    }

    /**
     * @param patient: to donate to
     * @return
     */
    public Donation donate(Optional<Patient> patient)
    {

        if (patient.isPresent())
        {
            // TODO: update patient requestedBloodQuantity
            return null;
        }
        // TODO: updateBloodStocks
        // TODO: update donationHistory <- not here tho
        return null;
    }

    public List<Donation> getDonationHistory()
    {
        return this.donationHistory;
    }


    /**
     * If the history already contains donation, then update it, otherwise add donation to the history.
     * @param donation
     */
    private void updateDonationHistory(Donation donation)
    {
        if (donationHistory.contains(donation))
            donationHistory.set(donationHistory.indexOf(donation), donation);
        else
            this.donationHistory.add(donation);
    }

}