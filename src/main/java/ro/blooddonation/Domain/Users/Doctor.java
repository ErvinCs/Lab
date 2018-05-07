package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Account;
import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Hospital;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
@Entity
@Table(name = "Doctors")
public class Doctor extends Person
{
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Hospital hospital;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CNP")
    private List<Patient> patients;

    /**
     * Default constructor
     */
    public Doctor() {}

    /**
     *
     * @param firstName
     * @param lastName
     * @param bDay
     * @param address
     * @param residence
     * @param CNP
     * @param account
     * @param hospital
     */
    public Doctor(String firstName, String lastName, LocalDate bDay, Address address, Address residence,
                  Long CNP, Account account, Hospital hospital) //, Account account, Long CNP)
    {
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.hospital = hospital;
        this.patients = new ArrayList<Patient>();
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param residence
     * @param hospital
     */
    public void updateData(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence, Optional<Hospital> hospital)
    {
        super.updateData(firstName, lastName, address, residence);
        Hospital h = hospital.isPresent() ? this.hospital = hospital.get() : this.hospital;
    }

    public void addPatient(Patient patient)
    {
        this.patients.add(patient);
        patient.setDoctor(this);
    }

    public void removePatient(Patient patient)
    {
        this.patients.remove(patient);
        patient.setDoctor(null);
    }

}