package ro.blooddonation.Domain;

public class DoningCenter
{
    private Address address;

    /**
     * @param address: Address
     */
    public DoningCenter(Address address)
    {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}