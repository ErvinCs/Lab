package ro.blooddonation.core.Domain.Users;

import ro.blooddonation.core.Domain.Account;
import ro.blooddonation.core.Domain.Address;
import ro.blooddonation.core.Domain.DoningCenter;
import ro.blooddonation.core.Exceptions.AppointmentException;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Entity
@Table(name = "DCPMembers")
public class DCPMember extends Person
{
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private DoningCenter doningCenter;

    /**
     * Default constructor
     */
    public DCPMember() {}

    /**
     *
     * @param firstName
     * @param lastName
     * @param bDay
     * @param address
     * @param residence
     * @param CNP
     * @param account
     * @param doningCenter
     */
    public DCPMember(String firstName, String lastName, LocalDate bDay, String address, String residence,
                     Long CNP, Account account, DoningCenter doningCenter) //, Account account, Long CNP)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.doningCenter = doningCenter;
    }

    public DoningCenter getDoningCenter() {
        return doningCenter;
    }

    public void setDoningCenter(DoningCenter doningCenter) {
        this.doningCenter = doningCenter;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param residence
     * @param doningCenter
     */
    public void updateData(Optional<String> firstName, Optional<String> lastName, Optional<String> address, Optional<String> residence, Optional<DoningCenter> doningCenter)
    {
        super.updateData(firstName, lastName, address, residence);
        DoningCenter dc = doningCenter.isPresent() ? this.doningCenter = doningCenter.get() : this.doningCenter;
    }
}