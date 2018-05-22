package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Doctor;
import ro.blooddonation.core.Domain.Patient;
import ro.blooddonation.web.Dto.DoctorDto;
import ro.blooddonation.web.Dto.PatientDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorConverter extends BaseConverter<Doctor, DoctorDto>
{
    private static final Logger log = LoggerFactory.getLogger(Doctor.class);

    @Override
    public Doctor convertDtoToModel(DoctorDto dto)
    {
        HospitalConverter hospitalConverter = new HospitalConverter();
        Doctor doctor = new Doctor(dto.getFirstName(), dto.getLastName(), dto.getBDay(), dto.getAddress(), dto.getResidence(),
                dto.getCNP(), null, hospitalConverter.convertDtoToModel(dto.getHospital()));
        return doctor;
    }

    @Override
    public DoctorDto convertModelToDto(Doctor doctor)
    {
        HospitalConverter hospitalConverter = new HospitalConverter();
        PatientConverter patientConverter = new PatientConverter();
        RequestConverter requestConverter = new RequestConverter();

        List<Patient> patients = doctor.getPatients();
        List<PatientDto> patientDtos = new ArrayList<>();
        patients.forEach(patient -> {
            patientDtos.add(patientConverter.convertModelToDto(patient));
        });

        DoctorDto doctorDto = new DoctorDto(hospitalConverter.convertModelToDto(doctor.getHospital()), patientDtos);
        doctorDto.setId(doctor.getId());
        doctorDto.setFirstName(doctor.getFirstName());
        doctorDto.setLastName(doctor.getLastName());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setBDay(doctor.getbDay());
        doctorDto.setCNP(doctor.getCNP());
        doctorDto.setResidence(doctor.getResidence());
        return doctorDto;
    }
}
