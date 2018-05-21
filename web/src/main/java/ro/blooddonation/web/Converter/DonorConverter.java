package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Donor;
import ro.blooddonation.web.Dto.DonationDto;
import ro.blooddonation.web.Dto.DonationDtos;
import ro.blooddonation.web.Dto.DonorDto;

import java.util.HashSet;
import java.util.Set;

@Component
public class DonorConverter extends BaseConverter<Donor, DonorDto>
{
    private static final Logger log = LoggerFactory.getLogger(DonorConverter.class);

    @Override
    public Donor convertDtoToModel(DonorDto dto)
    {
        DonationConverter donationConvertor = new DonationConverter();
        Donor donor = new Donor(dto.getFirstName(), dto.getLastName(), dto.getbDay(), dto.getAddress(), dto.getResidence(), dto.getCNP(), null);
        donor.setCurrAppointment(dto.getCurrAppointment());
        donor.setCurrDonation(donationConvertor.convertDtoToModel(dto.getCurrDonation()));
        DonationDtos donationDtos = new DonationDtos();
        Set<DonationDto> set = new HashSet<DonationDto>(dto.getDonationHistory());
        donationDtos.donations = set;
        donor.setDonationHistory(donationConvertor.convertDtoToModel(donationDtos);
        donor.setLastDonation(dto.getLastDonation());
        return donor;
    }

    @Override
    public DonorDto convertModelToDto(Donor donor) {
        DonationConverter donationConvertor = new DonationConverter();
        DonorDto donorDto = new DonorDto(donor.getFirstName(), donor.getLastName(), donor.getbDay(), donor.getAddress(),
                donor.getResidence(), donor.getCNP(), donationConvertor.convertModelToDto(donor.getDonationHistory()),
                donationConvertor.convertModelToDto(donor.getCurrDonation()), donor.getCurrAppointment(), )
        donorDto.setId(donor.getId());
        return donorDto;
    }
}
