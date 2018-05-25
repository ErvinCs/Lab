package ro.blooddonation.web.Dto;

import lombok.*;
import ro.blooddonation.core.Domain.Doctor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalDto extends BaseDto {
    private String address;
    private DoctorsDto doctors;

    @Override
    public String toString()
    {
        return "Hospital{address=" + this.address.toString() +
                ", doctorNo=" + //this.doctors.getDoctors().size() +
                "}" + super.toString();
    }
}
