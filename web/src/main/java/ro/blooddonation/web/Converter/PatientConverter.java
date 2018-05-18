package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Patient;
import ro.blooddonation.web.Dto.PatientDto;

@Component
public class PatientConverter extends BaseConverter<Patient, PatientDto>
{
    private static final Logger log = LoggerFactory.getLogger(Patient.class);

    @Override
    public Patient convertDtoToModel(PatientDto dto)
    {
        Patient p = new Patient(

        );
        return p;
    }

    @Override
    public PatientDto convertModelToDto(Patient patient)
    {
        PatientDto patientDto = new PatientDto(

        );
        patientDto.setId(patient.getId());
        return patientDto;
    }
}
