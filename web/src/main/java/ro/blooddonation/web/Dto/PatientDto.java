package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.*;

import java.time.LocalDate;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class PatientDto extends PersonDto {


    public PatientDto(String firstName, String lastName, LocalDate bDay, String address, String residence, Long CNP,
                      DoctorDto doctor, BloodEnum blood, Double requestedBloodQuantity, Integer urgency){
        super(firstName, lastName, bDay, address, residence, CNP);
        this.doctor = doctor;
        this.blood = blood;
        this.requestedBloodQuantity = requestedBloodQuantity;
        this.urgency = urgency;

    }

    private DoctorDto doctor;
    private BloodEnum blood;
    private Double requestedBloodQuantity;
    private Integer urgency;

    public BloodEnum getBlood() {
        return blood;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public Double getRequestedBloodQuantity() {
        return requestedBloodQuantity;
    }

    public void setBlood(BloodEnum blood) {
        this.blood = blood;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public void setRequestedBloodQuantity(Double requestedBloodQuantity) {
        this.requestedBloodQuantity = requestedBloodQuantity;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

}
