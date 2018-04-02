package ro.blooddonation.Domain;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Donor extends User {

    protected LocalDate currAppointment = null;
    protected LocalDate lastDonation = null;
    protected List<Donation> donationHistory;

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
            // TODO: search for patient in the repo
            return null;
        }
        // TODO: updateBloodStocks
        // TODO: call updateDonationHistory
        return null;
    }

    /**
     * @param donation
     *  If the history already contains donation, then update it, otherwise add donation to the history.
     */
    private void updateDonationHistory(Donation donation)
    {
        if (donationHistory.contains(donation))
            donationHistory.set(donationHistory.indexOf(donation), donation);
        else
            this.donationHistory.add(donation);
    }


    public void menu()
    {
        // TODO: ???
    }


}