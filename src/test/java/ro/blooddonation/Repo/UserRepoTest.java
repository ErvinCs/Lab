package ro.blooddonation.Repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Users.Donor;
import ro.blooddonation.Domain.Users.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRepoTest {
    private Person p1;
    private IRepo<Person> userRepo;
    private Address address1;
    private Address address2;
    private Account a;


    @Before
    public void setUp() throws Exception
    {
        address1 =  new Address("Street1", "Town1", "Country1");
        address2 =  new Address("Street2", "Town2", "Country2");
        a = new Account("dfhkd","hcudhfk");
        long cnp=1234834552;
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse("24.10.1994", germanFormatter);
        p1 = new Donor("Bob","Grey",date,address1,address2,cnp,a);

        userRepo = new UserRepo<>();
    }

    @After
    public void tearDown() throws Exception
    {
        address1 = null;
        address2 = null;
        p1 = null;
        userRepo = null;
    }

    @Test
    public void add() throws Exception
    {
        int initialSize = userRepo.getAll().size();
        Long id1 = userRepo.add(p1);
        try {
            assertEquals(userRepo.getAll().size(), initialSize + 1);
        }finally {
            userRepo.remove(id1);
        }
    }

    @Test
    public void remove() throws Exception
    {
        Long id1 = userRepo.add(p1);
        int initialSize = userRepo.getAll().size();

        userRepo.remove(id1);
        assertEquals(userRepo.getAll().size(), initialSize - 1);
    }

    @Test
    public void getAll() throws Exception
    {
        int initialSize = userRepo.getAll().size();

        Long id1 = userRepo.add(p1);
        assertEquals(userRepo.getAll().size(), initialSize + 1);

        userRepo.remove(id1);
        assertEquals(userRepo.getAll().size(), initialSize);
    }

    @Test
    public void find() throws Exception {
        Long id1 = userRepo.add(p1);
        p1.setCNP(id1);
        try {
            assertTrue(userRepo.find(Long.valueOf(-1)) == null);
            assertEquals(userRepo.find(id1).getCNP(), p1.getCNP());
        } finally {
            userRepo.remove(id1);
        }
    }
}
