package ro.blooddonation.core.Domain;

import javax.persistence.*;

@Entity
@Table(name = "DoningCenter")
public class DoningCenter
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DoningCenterID")
    private Long id;

    @Column
    private String address;

    /**
     * Default constructor
     */
    public DoningCenter() {}

    /**
     * @param address: Address
     */
    public DoningCenter(String address)
    {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }
}