package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.Account;
import ro.blooddonation.core.Domain.Donation;

import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DonorDto extends PersonDto {

    public DonorDto(String firstName, String lastName, LocalDate bDay, String address, String residence, Long CNP,
                    List<DonationDto> donationHistory, DonationDto currDonation, LocalDate currAppointment, LocalDate lastDonation){
        super(firstName, lastName, bDay, address, residence, CNP);
        this.donationHistory = donationHistory;
        this.currDonation = currDonation;
        this.currAppointment = currAppointment;
        this.lastDonation = lastDonation;
    }

    private DonationDto currDonation;
    private LocalDate currAppointment;
    private LocalDate lastDonation;
    private List<DonationDto> donationHistory;

    public DonationDto getCurrDonation() {
        return currDonation;
    }

    public List<DonationDto> getDonationHistory() {
        return donationHistory;
    }

    public LocalDate getCurrAppointment() {
        return currAppointment;
    }

    public LocalDate getLastDonation() {
        return lastDonation;
    }

    public void setCurrAppointment(LocalDate currAppointment) {
        this.currAppointment = currAppointment;
    }

    public void setCurrDonation(DonationDto currDonation) {
        this.currDonation = currDonation;
    }

    public void setDonationHistory(List<DonationDto> donationHistory) {
        this.donationHistory = donationHistory;
    }

    public void setLastDonation(LocalDate lastDonation) {
        this.lastDonation = lastDonation;
    }

    @Override
    public String toString()
    {
        return "Donor{currentDonation=" + currDonation.getId().toString() +
                ", currentAppointment=" + currAppointment.toString() +
                ", lastDonation=" + lastDonation.toString() +
                ", donationHistorySize=" + donationHistory.size() + "}";
    }
}
