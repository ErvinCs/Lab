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
        Donor donor = new Donor(dto.getFirstName(), dto.getLastName(), dto.getbDay(), dto.getAddress(), dto.getResidence(), dto.getCNP(), null);
        donor.setCurrAppointment(dto.getCurrAppointment());
        donor.setCurrDonation(dto.getCurrDonation());
        donor.setDonationHistory(dto.getDonationHistory());
        donor.setLastDonation(dto.getLastDonation());
        return donor;
    }

    @Override
    public DonorDto convertModelToDto(Donor donor)
    {
        DonorDto donorDto = new DonorDto(donor.getFirstName(),donor.getLastName(), donor.getbDay(), donor.getAddress(), donor.getResidence(),
                donor.getCNP(), donor.getAccount(), donor.getDonationHistory(), donor.getCurrDonation(),
                donor.getCurrAppointment(), donor.getLastDonation());
        donorDto.setId(donor.getId());
        return donorDto;
    }
}
