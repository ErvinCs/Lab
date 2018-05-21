package ro.blooddonation.web.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.blooddonation.core.Domain.Donation;
import ro.blooddonation.core.Domain.Donor;
import ro.blooddonation.web.Dto.DonationDto;
import ro.blooddonation.web.Dto.DonationDtos;
import ro.blooddonation.web.Dto.DonorDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        donor.setCurrDonation(donationConvertor.convertDtoToModel(dto.getCurrDonation()));
        donor.setCurrAppointment(dto.getCurrAppointment());
        donor.setLastDonation(dto.getLastDonation());

        List<Donation> donations = new ArrayList<>();
        List<DonationDto> donationHistory = dto.getDonationHistory();
        donationHistory.forEach(item ->{
            donations.add(donationConvertor.convertDtoToModel(item));
        });
        donor.setDonationHistory(donations);

        return donor;
    }

    @Override
    public DonorDto convertModelToDto(Donor donor) {
        DonationConverter donationConvertor = new DonationConverter();

        List<Donation> donations = new ArrayList<>(donor.getDonationHistory());
        List<DonationDto> donationHistory = new ArrayList<>();
        donations.forEach(item -> {
            donationHistory.add(donationConvertor.convertModelToDto(item));
        });

        DonorDto donorDto = new DonorDto(donor.getFirstName(), donor.getLastName(), donor.getbDay(),
                donor.getAddress(), donor.getResidence(), donor.getCNP(), donationHistory,
                donationConvertor.convertModelToDto(donor.getCurrDonation()), donor.getCurrAppointment(), donor.getLastDonation());
        donorDto.setId(donor.getId());
        return donorDto;
    }
}
