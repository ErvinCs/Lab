package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Doctor;
import ro.blooddonation.core.Domain.Patient;
import ro.blooddonation.web.Dto.PatientDto;

@Component
public class PatientConverter extends BaseConverter<Patient, PatientDto>
{
    private static final Logger log = LoggerFactory.getLogger(Patient.class);

    @Override
    public Patient convertDtoToModel(PatientDto dto) {
        Patient p = new Patient(dto.getFirstName(), dto.getLastName(), dto.getbDay(),dto.getAddress(), dto.getResidence(),
                dto.getCNP(), null, dto.getDoctor());
        p.setBlood(dto.getBlood());
        p.setRequestedBloodQuantity(dto.getRequestedBloodQuantity());
        p.setUrgency(dto.getUrgency());
        return p;
    }

    @Override
    public PatientDto convertModelToDto(Patient patient) {

        PatientDto patientDto = new PatientDto(patient.getFirstName(), patient.getLastName(), patient.getbDay(),
                patient.getAddress(), patient.getResidence(), patient.getCNP(), patient.getDoctor(), patient.getBlood(),
                patient.getRequestedBloodQuantity(), patient.getUrgency());
        patientDto.setId(patient.getId());
        return patientDto;
    }
}
