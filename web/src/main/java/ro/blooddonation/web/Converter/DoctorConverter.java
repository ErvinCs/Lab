package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Doctor;
import ro.blooddonation.web.Dto.DoctorDto;

@Component
public class DoctorConverter extends BaseConverter<Doctor, DoctorDto>
{
    private static final Logger log = LoggerFactory.getLogger(Doctor.class);

    @Override
    public Doctor convertDtoToModel(DoctorDto dto)
    {
        Doctor d = new Doctor(

        );
        return d;
    }

    @Override
    public DoctorDto convertModelToDto(Doctor doctor)
    {
        DoctorDto doctorDto = new DoctorDto(

        );
        doctorDto.setId(doctor.getId());
        return doctorDto;
    }
}
