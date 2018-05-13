package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Hospital;
import ro.blooddonation.web.Dto.HospitalDto;

@Component
public class HospitalConverter extends BaseConverter<Hospital, HospitalDto>
{
    private static final Logger log = LoggerFactory.getLogger(HospitalConverter.class);

    @Override
    public Hospital convertDtoToModel(HospitalDto dto)
    {
        Hospital h = new Hospital(dto.getAddress());
        h.setId(dto.getId());
        return h;
    }

    @Override
    public HospitalDto convertModelToDto(Hospital hospital) {
        HospitalDto hospitalDto = new HospitalDto(hospital.getAddress());
        hospitalDto.setId(hospital.getId());
        return hospitalDto;
    }
}
