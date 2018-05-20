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
                 Account account, List<Donation> donationHistory, Donation currDonation, LocalDate currAppointment, LocalDate lastDonation){
        super(firstName, lastName, bDay, address, residence, CNP, account);
        this.donationHistory = donationHistory;
        this.currDonation = currDonation;
        this.currAppointment = currAppointment;
        this.lastDonation = lastDonation;
    }

    private Donation currDonation;
    private LocalDate currAppointment;
    private LocalDate lastDonation;
    private List<Donation> donationHistory;

    public Donation getCurrDonation() {
        return currDonation;
    }

    public List<Donation> getDonationHistory() {
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

    public void setCurrDonation(Donation currDonation) {
        this.currDonation = currDonation;
    }

    public void setDonationHistory(List<Donation> donationHistory) {
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
