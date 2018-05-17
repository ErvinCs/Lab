package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Donor;
import ro.blooddonation.web.Dto.DonorDto;

@Component
public class DonorConverter extends BaseConverter<Donor, DonorDto>
{
    private static final Logger log = LoggerFactory.getLogger(DonorConverter.class);

    @Override
    public Donor convertDtoToModel(DonorDto dto)
    {
        //TODO
        return null;
    }

    @Override
    public DonorDto convertModelToDto(Donor hospital)
    {
        //TODO
        return null;
    }
}
