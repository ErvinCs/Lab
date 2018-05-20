package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientsDto
{
    public Set<PatientDto> patients;

    public Set<PatientDto> getPatients() {
        return patients;
    }

    public void setPatients(Set<PatientDto> patients) {
        this.patients = patients;
    }
}
