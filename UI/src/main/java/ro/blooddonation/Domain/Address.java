package ro.blooddonation.Domain;

public class Address
{
    protected String address;
    protected String town;
    protected String country;

    /**
     *
     * @param address: String
     * @param town: String
     * @param country: String
     */
    public Address(String address, String town, String country)
    {
        this.address = address;
        this.town = town;
        this.country = country;
    }

}