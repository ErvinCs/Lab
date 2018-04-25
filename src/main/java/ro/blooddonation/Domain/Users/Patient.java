package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "Patients")
public class Patient extends Person {

    @Column
    private Doctor doctor;

    @Column
    private Blood blood = null;

    @Column
    private Double requestedBloodQuantity = null;

    @Column
    private Integer urgency = null;

    /**
     * Default constructor
     */
    public Patient() {}
    /**
     *
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param account: Account
     */
    public Patient(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                   Account account, Doctor doctor)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.doctor = doctor;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public Double getRequestedBloodQuantity() {
        return requestedBloodQuantity;
    }

    public void setRequestedBloodQuantity(Double requestedBloodQuantity) {
        this.requestedBloodQuantity = requestedBloodQuantity;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

}