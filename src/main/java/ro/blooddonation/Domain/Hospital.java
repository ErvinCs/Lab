package ro.blooddonation.Domain;


public class Hospital {

    public Address address;
    protected Admin admin;
    public Long id;
    private static Long idGen = Long.valueOf(1);

    /**
     * @param address: Address
     * @param admin: Admin
     */
    public Hospital(Address address, Admin admin)
    {
        this.address = address;
        this.admin = admin;
        this.id = idGen;
        idGen += 1;
    }
}