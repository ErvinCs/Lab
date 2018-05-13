package ro.blooddonation.core.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.core.Domain.Account;
import ro.blooddonation.core.Domain.Address;
import ro.blooddonation.core.Domain.DoningCenter;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class DCPMemberTest
{
    private static final Address NEW_ADDR = new Address("New", "New", "New");
    private static final DoningCenter NEW_DC = new DoningCenter(NEW_ADDR);
    private static final Account NEW_ACC = new Account("New", "New");

    private String firstName;
    private String lastName;
    private LocalDate bDay;
    private Address address;
    private Address residence;
    private Long iCNP;
    private Account acc;

    private DoningCenter doningCen;
    private Address addr;

    private DCPMember dcpMem;



    @Before
    public void setUp() throws Exception
    {
        addr = new Address("Street, house", "Town", "Country");
        doningCen = new DoningCenter(addr);

        firstName = "first";
        lastName = "last";
        bDay = LocalDate.of(1997, 11, 12);
        address = new Address("addr", "town", "country");
        residence = new Address("currAddr", "currTown", "currCountry");
        iCNP = new Long("1971111111111");
        acc = new Account("Person", "Pass");
        iCNP = new Long("1971111111111");

        dcpMem = new DCPMember(firstName, lastName, bDay, address, residence, iCNP, acc, doningCen);
    }

    @After
    public void tearDown() throws Exception
    {
        addr = null;
        doningCen = null;
        acc = null;
        dcpMem = null;
    }

    @Test
    public void getCNP() throws Exception
    {
        assertEquals(dcpMem.getCNP(), iCNP);
    }

    @Test
    public void getDoningCenter() throws Exception
    {
        assertEquals(dcpMem.getDoningCenter(), doningCen);
    }

    @Test
    public void setDoningCenter() throws Exception
    {
        dcpMem.setDoningCenter(NEW_DC);
        assertEquals(dcpMem.getDoningCenter(), NEW_DC);
    }

    @Test
    public void getAccount() throws Exception
    {
        assertEquals(dcpMem.getAccount(), acc);
    }

    @Test
    public void setAccount() throws Exception
    {
        dcpMem.setAccount(NEW_ACC);
        assertEquals(dcpMem.getAccount(), NEW_ACC);
    }

    @Test
    public void updateCredentials() throws Exception
    {
        dcpMem.updateCredentials(Optional.of(NEW_ACC.getUsername()), Optional.of(NEW_ACC.getPassword()));
        assertEquals(dcpMem.getAccount().getUsername(), NEW_ACC.getUsername());
        assertEquals(dcpMem.getAccount().getPassword(), NEW_ACC.getPassword());
    }

}