package ro.blooddonation.Domain;

import java.time.LocalDate;

public class Donation
{
    private Blood blood;
    private Double bloodQuantity;
    private Double plasmaQuantity;
    private Double thrombocytesQuantity;
    private Double redCellsQuantity;
    private LocalDate donationDate;

    private Long id;
    private static Long idGen = Long.valueOf(1);

    public static final Integer plasmaExp = 365;
    public static final Integer thrombocytesExp = 42;
    public static final Integer redCellsExp = 5;

    /**
     * @param donationDate: LocalDate
     */
    public Donation(LocalDate donationDate, Double bloodQuantity)
    {
        this.donationDate = donationDate;
        this.bloodQuantity = bloodQuantity;
        this.id = idGen;
        idGen += 1;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
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

    public Long getId() {
        return id;
    }
}