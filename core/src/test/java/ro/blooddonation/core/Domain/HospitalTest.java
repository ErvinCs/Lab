package ro.blooddonation.core.Domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HospitalTest
{
    private Hospital h1;
    private Address address1;
    private Address address2;

    @Before
    public void setUp() throws Exception
    {
        address1 =  new Address("Street1", "Town1", "Country1");
        h1 = new Hospital(address1);
        address2 =  new Address("Street2", "Town2", "Country2");

    }

    @After
    public void tearDown() throws Exception
    {
        address1 = null;
        address2 = null;
        h1 = null;
    }

    @Test
    public void getAddress() throws Exception
    {
        assertEquals(h1.getAddress(), address1);
    }

    @Test
    public void setAddress() throws Exception
    {
        assertEquals(h1.getAddress(), address1);
        h1.setAddress(address2);
        assertEquals(h1.getAddress(), address2);
    }

    @Test
    public void getId() throws Exception
    {
        System.out.println(h1.getId());
    }

}