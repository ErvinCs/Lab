package ro.blooddonation.Domain;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Doctor extends User {


    protected List<Patient> patientList;
    protected Hospital hospital;

    /**
     * @param firstName: String
     * @param lastName: String
     * @param bDay: LocalDate
     * @param address: Address
     * @param residence: Address
     * @param CNP: Long
     * @param hospital: Hospital
     */
    public Doctor(String firstName, String lastName, LocalDate bDay, Address address, Address residence, Long CNP,
                  String username, String password, Hospital hospital)
    {
        super(firstName, lastName, bDay, address, residence, CNP, username, password);
        this.hospital = hospital;
        this.patientList = new ArrayList<Patient>();
    }

    /**
     * @param patientCNP
     */
    public void trackDonationAmountForPatient(Long patientCNP) {
        // TODO: if patient exists in repo, return donationAmount
    }

    /**
     * 
     */
    public void trackAllRequestStatuses() {
        // TODO: request status list
    }

    /**
     * @param blood
     */
    public void makeBloodRequest(Blood blood) {
        // TODO: add a Request(blood) to the requestRepo
    }


    /**
     * @param firstName: String
     * @param lastName: String
     * @param address: Address
     * @param residence: Address
     * @param hospital: Hospital
     */
    public void updateAccount(Optional<String> firstName, Optional<String> lastName, Optional<Address> address, Optional<Address> residence, Optional<Hospital> hospital) {
        super.updateAccount(firstName, lastName, address, residence);
        Hospital h = hospital.isPresent() ? this.hospital = hospital.get() : null;
    }


    public void menu() {
        // TODO: ???
    }

}