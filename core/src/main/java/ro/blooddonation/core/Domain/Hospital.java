package ro.blooddonation.core.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity<Long> implements Serializable
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "hid", updatable = false, nullable = false)
//    private Long id;

    @Column
    private String address;

    /**
     * Default constructor
     */
    public Hospital() {}
    /**
     * @param address: Address
     */
    public Hospital(String address)
    {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }

    @Override
    public String toString()
    {
        return "Hospital{id=" + this.getId() + "; " + address.toString() + "}";
    }
}