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
        HospitalConverter hospitalConverter = new HospitalConverter();
        Doctor doctor = new Doctor(dto.getFirstName(), dto.getLastName(), dto.getbDay(), dto.getAddress(), dto.getResidence(),
                            dto.getCNP(), null, hospitalConverter.convertDtoToModel(dto.getHospital()));
        return doctor;
    }

    @Override
    public DoctorDto convertModelToDto(Doctor doctor)
    {
        HospitalConverter hospitalConverter = new HospitalConverter();
        DoctorDto doctorDto = new DoctorDto(doctor.getFirstName(), doctor.getLastName(), doctor.getbDay(),
                                doctor.getAddress(), doctor.getResidence(),
                                doctor.getCNP(), hospitalConverter.convertModelToDto(doctor.getHospital()));
        doctorDto.setId(doctor.getId());
        return doctorDto;
    }
}
