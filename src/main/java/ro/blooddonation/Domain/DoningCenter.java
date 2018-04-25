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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressID")
    private Address address;

//    private static Long idGen = Long.valueOf(1);

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
//        this.id = idGen;
//        idGen += 1;
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