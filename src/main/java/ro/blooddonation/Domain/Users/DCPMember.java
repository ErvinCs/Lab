package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.DoningCenter;
import ro.blooddonation.Exceptions.AppointmentException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class DCPMember extends User
{
    protected List<Donor> donorList;
    public DoningCenter doningCenter;

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
     * @param donor: Donor
     */
    public void updateDonorHistory(Donor donor)
    {
        // TODO: search for donor in the repo by CNP; if found, updateDonationHistory
    }


    /**
     * 
     */
    public void processRequest() {
        // TODO implement here
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
}