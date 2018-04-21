package ro.blooddonation.Domain.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.DoningCenter;

import java.util.Optional;

import static org.junit.Assert.*;

public class DCPMemberTest
{
    private static final Address NEW_ADDR = new Address("New", "New", "New");
    private static final DoningCenter NEW_DC = new DoningCenter(NEW_ADDR);
    private static final Account NEW_ACC = new Account("New", "New");

    private DoningCenter doningCen;
    private Address addr;
    private DCPMember dcpMem;
    private Account acc;
    private Long iCNP = new Long("1971111111111");



    @Before
    public void setUp() throws Exception
    {
        addr = new Address("Street, house", "Town", "Country");
        doningCen = new DoningCenter(addr);
        acc = new Account("Person", "Pass");
        dcpMem = new DCPMember(doningCen, acc, iCNP);
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
    public void updateAccount() throws Exception
    {
        dcpMem.updateAccount(Optional.of(NEW_DC), Optional.empty(), Optional.empty());
        assertEquals(dcpMem.getDoningCenter(), NEW_DC);
        assertEquals(dcpMem.getCNP(), iCNP);
        dcpMem.updateAccount(Optional.empty(), Optional.of(NEW_ACC.getUsername()), Optional.of(NEW_ACC.getPassword()));
        assertEquals(dcpMem.getAccount().getUsername(), NEW_ACC.getUsername());
        assertEquals(dcpMem.getAccount().getPassword(), NEW_ACC.getPassword());
    }

}