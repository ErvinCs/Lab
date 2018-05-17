package ro.blooddonation.core.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "doningcenters")
public class DoningCenter extends BaseEntity<Long>
{
    //@Column
    private String address;

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
}