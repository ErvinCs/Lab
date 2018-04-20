package ro.blooddonation.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Donation;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DonorTest
{
    private static final Double QUANTITY = 500.0;
    private static final LocalDate NEW_DATE =  LocalDate.of(2018, 1, 1);
    private static final Donation NEW_DON = new Donation(NEW_DATE, QUANTITY);

    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long iCNP;
    private Account account;
    private Donor donor;

    @Before
    public void setUp() throws Exception
    {
        firstName = "first";
        lastName = "last";
        bDay = LocalDate.of(1997, 11, 12);
        address = new Address("addr", "town", "country");
        residence = new Address("currAddr", "currTown", "currCountry");
        iCNP = new Long("1971111111111");
        account = new Account("User", "Pass");
        donor = new Donor(firstName, lastName, bDay, address, residence, iCNP, account);
    }

    @After
    public void tearDown() throws Exception
    {
        firstName = null;
        lastName = null;
        bDay = null;
        address = null;
        residence = null;
        iCNP = null;
        account = null;
        donor = null;
    }

    @Test
    public void getCurrDonation() throws Exception
    {
        assertEquals(donor.getCurrDonation(), null);
    }

    @Test
    public void setCurrDonation() throws Exception
    {
        donor.setCurrDonation(NEW_DON);
        assertEquals(donor.getCurrDonation(), NEW_DON);
    }

    @Test
    public void getCurrAppointment() throws Exception
    {
        assertEquals(donor.getCurrAppointment(), null);
    }

    @Test
    public void setCurrAppointment() throws Exception
    {
        donor.setCurrAppointment(NEW_DATE);
        assertEquals(donor.getCurrAppointment(), NEW_DATE);
    }

    @Test
    public void getLastDonation() throws Exception
    {
        assertEquals(donor.getLastDonation(), null);
    }

    @Test
    public void setLastDonation() throws Exception
    {
        donor.setLastDonation(NEW_DATE);
        assertEquals(donor.getLastDonation(), NEW_DATE);
    }

    @Test
    public void getDonationHistory() throws Exception
    {
        assertEquals(donor.getDonationHistory().size(), 0);

        Donation don = new Donation(NEW_DATE, QUANTITY);
        donor.updateDonationHistory(don);

        assertEquals(donor.getDonationHistory().size(), 1);
    }

    @Test
    public void updateDonationHistory() throws Exception
    {
        Donation don = new Donation(NEW_DATE, QUANTITY);
        donor.updateDonationHistory(don);
        assertEquals(donor.getDonationHistory().size(), 1);

        don.setBlood(new Blood("rh+", "AB4"));
        don.setRedCellsQuantity(100.0);

        assertEquals(donor.getDonationHistory().size(), 1);
    }

}