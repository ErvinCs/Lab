package ro.blooddonation.Domain;

public class Address
{
    private String address;
    private String town;
    private String country;

    /**
     * Default constructor
     */
    public Address() {}
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}