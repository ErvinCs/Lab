package ro.blooddonation.Domain;

import java.util.*;

public class DoningCenter
{
    protected Address address;
    protected Set<Donation> bloodStocks;

    /**
     * @param address: Address
     */
    public DoningCenter(Address address)
    {
        this.address = address;
        bloodStocks = new HashSet<Donation>();
    }
}