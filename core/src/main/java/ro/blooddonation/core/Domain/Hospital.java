package ro.blooddonation.core.Domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospitals")
public class Hospital extends BaseEntity<Long>
{
    @Column
    private String address;

    @OneToMany( mappedBy = "hospitals",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Doctor> doctors;

    /**
     * @param address: Address
     */
    public Hospital(String address)
    {
        this.address = address;
        this.doctors = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor)
    {
        doctors.add(doctor);
        doctor.setHospital(this);
    }

    public void removeDoctor(Doctor doctor)
    {
        doctors.remove(doctor);
        doctor.setHospital(null);
    }

    @Override
    public String toString()
    {
        return "Hospital{id=" + this.getId() + "; " + address.toString() + "}";
    }
}