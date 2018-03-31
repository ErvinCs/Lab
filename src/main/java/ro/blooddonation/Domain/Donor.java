package ro.blooddonation.Domain;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Donor extends User {

    protected LocalDate currApointment = null;
    protected LocalDate lastDonation = null;
    protected List<Donation> donationHistory;

    public Donor(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                 String username, String password)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.donationHistory = new ArrayList<Donation>();
    }

    /**
     * @param patient 
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
     * 
     */
    private void updateDonationHistory() {
        // TODO: add Donation to donationHistory
    }


    /**
     * 
     */
    public void menu()
    {
        // TODO: ???
    }


}