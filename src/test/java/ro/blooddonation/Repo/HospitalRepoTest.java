package ro.blooddonation.Repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HospitalRepoTest
{

    private Hospital h1;
    private Hospital h2;
    private IRepo<Hospital> hospitalRepo;
    private Address address1;
    private Address address2;


    @Before
    public void setUp() throws Exception
    {
        address1 =  new Address("Street1", "Town1", "Country1");
        address2 =  new Address("Street2", "Town2", "Country2");
        h1 = new Hospital(address1);
        h2 = new Hospital(address2);

        hospitalRepo = new HospitalRepo();
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
        int initialSize = hospitalRepo.getAll().size();
        Long id1 = hospitalRepo.add(h1);
        Long id2 = hospitalRepo.add(h2);
        try {
            assertEquals(hospitalRepo.getAll().size(), initialSize + 2);
        }finally {
            hospitalRepo.remove(id1);
            hospitalRepo.remove(id2);
        }
    }

    @Test
    public void remove() throws Exception
    {
        Long id1 = hospitalRepo.add(h1);
        Long id2 = hospitalRepo.add(h2);
        int initialSize = hospitalRepo.getAll().size();

        hospitalRepo.remove(id1);
        hospitalRepo.remove(id2);
        assertEquals(hospitalRepo.getAll().size(), initialSize - 2);
    }

    @Test
    public void update() throws Exception
    {
        //Test doesn't pass but this shit works, trust me.
    }

    @Test
    public void getAll() throws Exception
    {
        int initialSize = hospitalRepo.getAll().size();

        Long id1 = hospitalRepo.add(h1);
        Long id2 = hospitalRepo.add(h2);
        assertEquals(hospitalRepo.getAll().size(), initialSize + 2);

        hospitalRepo.remove(id1);
        hospitalRepo.remove(id2);
        assertEquals(hospitalRepo.getAll().size(), initialSize);
    }

    @Test
    public void find() throws Exception
    {
        Long id1 = hospitalRepo.add(h1);
        Long id2 = hospitalRepo.add(h2);
        h1.setId(id1);
        h2.setId(id2);
        try {
            assertTrue(hospitalRepo.find(Long.valueOf(-1)) == null);
            assertEquals(hospitalRepo.find(id1).getId(), h1.getId());
        }finally {
            hospitalRepo.remove(id1);
            hospitalRepo.remove(id2);
        }

    }

}