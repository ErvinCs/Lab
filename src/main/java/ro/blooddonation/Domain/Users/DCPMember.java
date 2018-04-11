package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.DoningCenter;
import ro.blooddonation.Exceptions.AppointmentException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class DCPMember extends User
{
    private DoningCenter doningCenter;

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
    }

    public DoningCenter getDoningCenter() {
        return doningCenter;
    }

    public void setDoningCenter(DoningCenter doningCenter) {
        this.doningCenter = doningCenter;
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