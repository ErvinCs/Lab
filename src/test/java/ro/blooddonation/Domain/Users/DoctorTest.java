package ro.blooddonation.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Hospital;

import java.util.Optional;

import static org.junit.Assert.*;

public class DoctorTest
{
    private static final Address NEW_ADDR = new Address("New", "New", "New");
    private static final Hospital NEW_H = new Hospital(NEW_ADDR);
    private static final Account NEW_ACC = new Account("New", "New");

    private Hospital hospital;
    private Address addr;
    private Doctor doctor;
    private Account acc;
    private Long iCNP;

    @Before
    public void setUp() throws Exception
    {
        addr = new Address("Street, house", "Town", "Country");
        hospital = new Hospital(addr);
        acc = new Account("User", "Pass");
        iCNP = new Long("1971111111111");
        doctor = new Doctor(hospital, acc, iCNP);
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
    public void updateAccount() throws Exception
    {
        doctor.updateAccount(Optional.of(NEW_H), Optional.empty(), Optional.empty());
        assertEquals(doctor.getHospital(), NEW_H);
        assertEquals(doctor.getCNP(), iCNP);
        doctor.updateAccount(Optional.empty(), Optional.of(NEW_ACC.getUsername()), Optional.of(NEW_ACC.getPassword()));
        assertEquals(doctor.getAccount().getUsername(), NEW_ACC.getUsername());
        assertEquals(doctor.getAccount().getPassword(), NEW_ACC.getPassword());
    }

}