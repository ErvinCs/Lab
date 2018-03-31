package ro.blooddonation.Domain;

import ro.blooddonation.Exceptions.AppointmentException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * 
 */
public class DCPMember extends User
{
    protected List<Donor> donorList;
    protected DoningCenter doningCenter;

    /**
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param doningCenter: DoningCenter
     */
    public DCPMember(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                     String username, String password, DoningCenter doningCenter)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.doningCenter = doningCenter;
        this.donorList = new ArrayList<Donor>();
    }

    /**
     * @param CNP: Long
     */
    public void updateDonorData(Long CNP)
    {
        // TODO: search for donor in the repo by CNP; if found, updateDonationHistory
    }

    /**
     * @return
     */
    public List<Donation> getBloodStocks()
    {
        // TODO: we need some kind of global BloodStockRepo
        return null;
    }

    /**
     * @return
     */
    public Optional<List<Donor>> idleDonors() {
        // TODO: has not donated in 5 years
        return null;
    }

    /**
     * 
     */
    public void removeDonor() {
        // TODO: by CNP
    }

    /**
     * 
     */
    public void processRequest() {
        // TODO implement here
    }

    /**
     * @return
     */
    private List<Donor> sortCloseDonors() {
        // TODO: by distance to the current DC location
        return null;
    }

    /**
     * @param donor: to set currApointment
     */
    private void appointDonor(Donor donor, LocalDate appointment)
    {
        LocalDate now = LocalDate.now();
        if (Period.between(now, appointment).getDays() < 0)
            throw new AppointmentException("Invalid date!");
        donor.currAppointment = appointment;
    }

    /**
     * @param firstName: String
     * @param lastName: String
     * @param address: Address
     * @param residence: Address
     * @param doningCenter: DoningCenter
     */
    public void updateAccount(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence, Optional<DoningCenter> doningCenter)
    {
        super.updateAccount(firstName, lastName, address, residence);
        DoningCenter dc = doningCenter.isPresent() ? this.doningCenter = doningCenter.get() : null;
    }

    public void menu() {
        // TODO: ???
    }

}