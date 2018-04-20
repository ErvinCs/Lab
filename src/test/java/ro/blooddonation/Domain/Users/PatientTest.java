package ro.blooddonation.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Hospital;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PatientTest
{
    public static final Integer NEW_URGENCY = 3;
    public static final Double NEW_REQ_B_QUANTITY = 100.0;
    public static final Blood NEW_B = new Blood("rh+", "O1");

    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long iCNP;
    private Account account;

    private Doctor doctor;
    private Hospital docHospital;
    private Address hospitalAddr;
    private Account docAccount;
    private Long docCNP;

    private Patient patient;

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

        hospitalAddr = new Address("hAddr", "hTwon", "hCountry");
        docHospital = new Hospital(hospitalAddr);
        docAccount = new Account("docUser", "docPass");
        docCNP = new Long("297111111111");
        doctor = new Doctor(docHospital, docAccount, docCNP);

        patient = new Patient(firstName, lastName, bDay, address, residence, iCNP, account, doctor);
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

        hospitalAddr = null;
        docHospital = null;
        docAccount = null;
        docCNP = null;
        doctor = null;

        patient = null;
    }

    @Test
    public void getBlood() throws Exception
    {
        assertEquals(patient.getBlood(), null);
    }

    @Test
    public void setBlood() throws Exception
    {
        patient.setBlood(NEW_B);
        assertEquals(patient.getBlood(), NEW_B);
    }

    @Test
    public void getRequestedBloodQuantity() throws Exception
    {
        assertEquals(patient.getRequestedBloodQuantity(), null);
    }

    @Test
    public void setRequestedBloodQuantity() throws Exception
    {
        patient.setRequestedBloodQuantity(NEW_REQ_B_QUANTITY);
        assertEquals(patient.getRequestedBloodQuantity(), NEW_REQ_B_QUANTITY);
    }

    @Test
    public void getUrgency() throws Exception
    {
        assertEquals(patient.getUrgency(), null);
    }

    @Test
    public void setUrgency() throws Exception
    {
        patient.setUrgency(NEW_URGENCY);
        assertEquals(patient.getUrgency(), NEW_URGENCY);
    }

}