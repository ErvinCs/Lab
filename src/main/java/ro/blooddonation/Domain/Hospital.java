package ro.blooddonation.Domain;

import javax.persistence.*;

@Entity
@Table(name = "HOSPITAL")
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name = "HOSPITAL_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    //private static Long idGen = Long.valueOf(1);

    /**
     * Default constructor
     */
    public Hospital() {}
    /**
     * @param address: Address
     */
    public Hospital(Address address)
    {
        this.address = address;
        //this.id = idGen;
        //idGen += 1;
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