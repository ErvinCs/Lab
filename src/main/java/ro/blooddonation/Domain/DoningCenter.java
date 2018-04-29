package ro.blooddonation.Domain;

import javax.persistence.*;

@Entity
@Table(name = "DoningCenter")
public class DoningCenter
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Embedded
    private Address address;


    /**
     * Default constructor
     */
    public DoningCenter() {}

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

    public Long getId() {
        return id;
    }
}