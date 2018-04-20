package ro.blooddonation.Repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Hospital;

import static org.junit.Assert.*;

public class HospitalRepoTest
{

    private Hospital h1;
    private Hospital h2;
    private IRepo<Hospital> hospitalRepo;

    @Before
    public void setUp() throws Exception
    {
        h1 = new Hospital();
        h2 = new Hospital();
        hospitalRepo = new HospitalRepo();
    }

    @After
    public void tearDown() throws Exception
    {
        h1 = null;
        h2 = null;
        hospitalRepo = null;
    }

    @Test
    public void add() throws Exception
    {
        assertEquals(hospitalRepo.add(h1), h1.getId());
        assertEquals(hospitalRepo.add(h2), h2.getId());
        assertEquals(hospitalRepo.getAll().size(), 2);
    }

    @Test
    public void remove() throws Exception
    {
        assertEquals(hospitalRepo.add(h1), h1.getId());
        hospitalRepo.remove(h1.getId());
        assertEquals(hospitalRepo.getAll().size(), 0);
    }

    @Test
    public void update() throws Exception
    {
        hospitalRepo.add(h1);
        hospitalRepo.update(h1.getId(), h2);
        //This might fail
        assertEquals(hospitalRepo.find(h1.getId()), h2);
    }

    @Test
    public void find() throws Exception
    {
        hospitalRepo.add(h1);
        hospitalRepo.add(h2);
        assertEquals(hospitalRepo.find(h1.getId()), h1);
    }

}