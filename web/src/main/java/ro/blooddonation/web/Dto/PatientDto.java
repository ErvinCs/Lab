package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDto extends PersonDto {

    private DoctorDto doctor;
    private BloodEnum blood;
    private Double requestedBloodQuantity;
    private Integer urgency;

}
