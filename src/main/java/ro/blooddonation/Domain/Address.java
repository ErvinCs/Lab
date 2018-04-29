package ro.blooddonation.Domain;

//import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Deprecated
 */


@Entity
@Table(name = "Addresses")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressID", updatable = false, nullable = false)
    private Long id;

    @Column
    private String address;

    @Column
    private String town;

    @Column
    private String country;

//    private static Long idGen = Long.valueOf(1);

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
//        this.id = idGen;
//        idGen += 1;
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

    public Long getId() {
        return id;
    }
}