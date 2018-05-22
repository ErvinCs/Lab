package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.Blood;
import ro.blooddonation.core.Domain.BloodEnum;
import ro.blooddonation.core.Domain.Doctor;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class RequestDto extends BaseDto {

    private BloodEnum blood;
    private Integer urgency;
    private DoctorDto doctor;
    private String status;

    public RequestDto(Long id, BloodEnum blood, Integer urgency, DoctorDto doctor, String status){
        super(id);
        this.blood = blood;
        this.urgency = urgency;
        this.doctor = doctor;
        this.status = status;
    }
    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public void setBlood(BloodEnum blood) {
        this.blood = blood;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public BloodEnum getBlood() {
        return blood;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
