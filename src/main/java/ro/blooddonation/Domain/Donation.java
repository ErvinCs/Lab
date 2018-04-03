package ro.blooddonation.Domain;

import java.time.LocalDate;

public class Donation
{
    public Blood blood;
    private Double bloodQuantity;
    public Double plasmaQuantity;
    public Double thrombocytesQuantity;
    public Double redCellsQuantity;
    private LocalDate donationDate;

    public Long id;
    private static Long idGen = Long.valueOf(1);

    private static final Integer plasmaExp = 365;
    private static final Integer thrombocytesExp = 42;
    private static final Integer redCellsExp = 5;

    /**
     * @param donationDate: LocalDate
     */
    public Donation(LocalDate donationDate)
    {
        this.donationDate = donationDate;
        this.id = idGen;
        idGen += 1;
    }

    public Double getBloodQuantity()
    {
        return this.bloodQuantity;
    }

    public LocalDate getDonationDate()
    {
        return this.donationDate;
    }
}