package ro.blooddonation.Domain.Users;

import ro.blooddonation.Domain.Address;
import ro.blooddonation.Domain.Blood;
import ro.blooddonation.Domain.Hospital;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Doctor extends User
{
    private Hospital hospital;

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
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
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

}