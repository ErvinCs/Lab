package ro.blooddonation.Domain;

import javax.persistence.*;

@Entity
@Table(name = "Hospitals")
@Embeddable
public class Hospital
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HospitalID", updatable = false, nullable = false)
    private Long id;

    @Embedded
    private Address address;

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
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return "Hospital{id=" + id + "; " + address.toString() + "}";
    }
}