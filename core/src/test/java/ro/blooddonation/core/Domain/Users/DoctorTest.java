package ro.blooddonation.core.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.core.Domain.Account;
import ro.blooddonation.core.Domain.Address;
import ro.blooddonation.core.Domain.Hospital;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class DoctorTest
{
    private static final Address NEW_ADDR = new Address("New", "New", "New");
    private static final Hospital NEW_H = new Hospital(NEW_ADDR);
    private static final Account NEW_ACC = new Account("New", "New");

    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long iCNP;
    private Account acc;

    private Hospital hospital;
    private Address addr;

    private Doctor doctor;



    @Before
    public void setUp() throws Exception
    {
        addr = new Address("Street, house", "Town", "Country");
        hospital = new Hospital(addr);

        firstName = "first";
        lastName = "last";
        bDay = LocalDate.of(1997, 11, 12);
        address = new Address("addr", "town", "country");
        residence = new Address("currAddr", "currTown", "currCountry");
        iCNP = new Long("1971111111111");
        acc = new Account("Person", "Pass");
        iCNP = new Long("1971111111111");

        doctor = new Doctor(firstName, lastName, bDay, address, residence, iCNP, acc, hospital);
    }

    @After
    public void tearDown() throws Exception
    {
        addr = null;
        hospital = null;
        acc = null;
        doctor = null;
    }

    @Test
    public void getHospital() throws Exception
    {
        assertEquals(doctor.getHospital(), hospital);
    }

    @Test
    public void setHospital() throws Exception
    {
        doctor.setHospital(NEW_H);
        assertEquals(doctor.getHospital(), NEW_H);
    }

    @Test
    public void getAccount() throws Exception
    {
        assertEquals(doctor.getAccount(), acc);
    }

    @Test
    public void setAccount() throws Exception
    {
        doctor.setAccount(NEW_ACC);
        assertEquals(doctor.getAccount(), NEW_ACC);
    }

    @Test
    public void updateCredentials() throws Exception
    {
        doctor.updateCredentials(Optional.of(NEW_ACC.getUsername()), Optional.of(NEW_ACC.getPassword()));
        assertEquals(doctor.getAccount().getUsername(), NEW_ACC.getUsername());
        assertEquals(doctor.getAccount().getPassword(), NEW_ACC.getPassword());
    }

}