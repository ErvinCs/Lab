package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.Donation;

import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DonorDto extends BaseDto
{
    private Donation currDonation;
    private LocalDate currAppointment;
    private LocalDate lastDonation;
    private List<Donation> donationHistory;

    @Override
    public String toString()
    {
        return "Donor{currentDonation=" + currDonation.getId().toString() +
                ", currentAppointment=" + currAppointment.toString() +
                ", lastDonation=" + lastDonation.toString() +
                ", donationHistorySize=" + donationHistory.size() + "}";
    }
}
