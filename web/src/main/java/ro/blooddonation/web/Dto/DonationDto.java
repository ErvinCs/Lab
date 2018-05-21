package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.BloodEnum;
import ro.blooddonation.core.Domain.DiseasesEnum;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class DonationDto extends BaseDto
{
    private BloodEnum blood;
    private Double bloodQuantity;
    private Double plasmaQuantity;
    private Double thrombocytesQuantity;
    private Double redCellsQuantity;
    private LocalDate donationDate;
    private Map<DiseasesEnum, Boolean> diseases;
    private Boolean hasDisease;

    public DonationDto(BloodEnum blood, Double bloodQuantity, Double plasmaQuantity, Double thrombocytesQuantity, Double redCellsQuantity, LocalDate donationDate, Map<DiseasesEnum, Boolean> diseases, Boolean status) {
        super();
        this.blood = blood;
        this.bloodQuantity = bloodQuantity;
        this.plasmaQuantity = plasmaQuantity;
        this.thrombocytesQuantity = thrombocytesQuantity;
        this.redCellsQuantity = redCellsQuantity;
        this.donationDate = donationDate;
        this.diseases = diseases;
        this.hasDisease = status;
    }

    public BloodEnum getBlood() {
        return blood;
    }

    public void setBlood(BloodEnum blood) {
        this.blood = blood;
    }

    public Double getBloodQuantity() {
        return this.bloodQuantity;
    }

    public Double getPlasmaQuantity() {
        return plasmaQuantity;
    }

    public void setPlasmaQuantity(Double plasmaQuantity) {
        this.plasmaQuantity = plasmaQuantity;
    }

    public Double getThrombocytesQuantity() {
        return thrombocytesQuantity;
    }

    public void setThrombocytesQuantity(Double thrombocytesQuantity) {
        this.thrombocytesQuantity = thrombocytesQuantity;
    }

    public Double getRedCellsQuantity() {
        return redCellsQuantity;
    }

    public void setRedCellsQuantity(Double redCellsQuantity) {
        this.redCellsQuantity = redCellsQuantity;
    }

    public LocalDate getDonationDate() {
        return this.donationDate;
    }

    public Map<DiseasesEnum, Boolean> getDiseases() {
        return diseases;
    }

    public void setDiseases(Map<DiseasesEnum, Boolean> diseases) {
        this.diseases = diseases;
    }

    public void setBloodQuantity(Double bloodQuantity) { this.bloodQuantity = bloodQuantity; }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Boolean getHasDisease() {
        return hasDisease;
    }

    public void setHasDisease(Boolean status) {
        this.hasDisease = status;
    }
}
