package ro.blooddonation.web.Dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalsDto
{
    public Set<HospitalDto> hospitals;

    public Set<HospitalDto> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<HospitalDto> hospitals) {
        this.hospitals = hospitals;
    }
}
