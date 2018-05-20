package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorDto extends PersonDto
{
    private HospitalDto hospital;

    private List<PatientDto> patients;

    public DoctorDto(String firstName, String lastName, LocalDate bDay, String address, String residence, Long cnp, HospitalDto hospitalDto) {
        super(firstName, lastName, bDay, address, residence, cnp);
        this.hospital = hospitalDto;
    }

    public HospitalDto getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDto hospital) {
        this.hospital = hospital;
    }

    public List<PatientDto> getPatients() { return patients; }

    public void setPatients(List<PatientDto> patients) {
        this.patients = patients;
    }

    public void addPatient(PatientDto patient)
    {
        this.patients.add(patient);
        patient.setDoctorDto(this);
    }

    public void removePatient(PatientDto patient)
    {
        this.patients.remove(patient);
        patient.setDoctorDto(null);
    }

}
