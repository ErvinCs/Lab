package ro.blooddonation.Repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class HospitalRepoTest
{

    private Hospital h1;
    private Hospital h2;
    private IRepo<Hospital> hospitalRepo;
    private Address address1;
    private Address address2;
//    private Connection con;

    @Before
    public void setUp() throws Exception
    {
        address1 =  new Address("Street1", "Town1", "Country1");
        address2 =  new Address("Street2", "Town2", "Country2");
        h1 = new Hospital(address1);
        h2 = new Hospital(address2);

        hospitalRepo = new HospitalRepo();
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7234108", "sql7234108", "bffwTudTUU");
//        } catch (SQLException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
    }

    @After
    public void tearDown() throws Exception
    {
        address1 = null;
        address2 = null;
        h1 = null;
        h2 = null;
        hospitalRepo = null;
    }

    @Test
    public void add() throws Exception
    {
        System.out.println("H1ID=" + h1.getId());
        assertEquals(hospitalRepo.add(h1), h1.getId());
        assertEquals(hospitalRepo.add(h2), h2.getId());
        assertEquals(hospitalRepo.getAll().size(), 2);
    }

    @Test
    public void remove() throws Exception
    {
        hospitalRepo.remove(h1.getId());
        hospitalRepo.remove(h2.getId());
        assertEquals(hospitalRepo.getAll().size(), 0);
    }

    @Test
    public void update() throws Exception
    {
        hospitalRepo.add(h1);
        hospitalRepo.update(h1.getId(), h2);
        assertEquals(hospitalRepo.find(h1.getId()).getAddress(), h2.getAddress());
        hospitalRepo.remove(h1.getId());
    }

    @Test
    public void find() throws Exception
    {
        hospitalRepo.add(h1);
        hospitalRepo.add(h2);
        assertEquals(hospitalRepo.find(h1.getId()), h1);
        hospitalRepo.remove(h1.getId());
        hospitalRepo.remove(h2.getId());
    }

}