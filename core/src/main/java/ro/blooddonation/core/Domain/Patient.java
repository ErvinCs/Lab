package ro.blooddonation.core.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
//@NoArgsConstructor
//@Table(name = "Patients")
public class Patient extends Person {

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CNP")
    private Doctor doctor;

//    @Column
//    @Embedded
    private Blood blood;

//    @Column
    private Double requestedBloodQuantity;

//    @Column
    private Integer urgency;

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
    public Patient(String firstName, String lastName, LocalDate bDay, String address, String residence, Long CNP,
                   Account account, Doctor doctor)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.doctor = doctor;
        this.blood = null;
        this.requestedBloodQuantity = null;
        this.urgency = null;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}