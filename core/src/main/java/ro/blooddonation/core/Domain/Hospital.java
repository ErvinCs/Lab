package ro.blooddonation.core.Domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "hospitals")
public class Hospital extends BaseEntity<Long>
{
    //@Column
    private String address;

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

    @Override
    public String toString()
    {
        return "Hospital{id=" + this.getId() + "; " + address.toString() + "}";
    }
}