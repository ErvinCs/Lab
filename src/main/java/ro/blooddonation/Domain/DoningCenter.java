package ro.blooddonation.Domain;

import java.util.*;

public class DoningCenter
{
    Address address;
    Set<Donation> bloodStocks;

    /**
     * @param address: Address
     */
    public DoningCenter(Address address)
    {
        this.address = address;
        bloodStocks = new HashSet<Donation>();
    }


}