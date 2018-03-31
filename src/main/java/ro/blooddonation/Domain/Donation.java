package ro.blooddonation.Domain;

import java.time.LocalDate;

public class Donation
{
    protected Blood blood;
    protected Double quantity;
    protected LocalDate donationDate;

    /**
     * @param rh: String
     * @param type: String
     * @param quantity: Double
     * @param donationDate: LocalDate
     */
    public Donation(String rh, String type, Double quantity, LocalDate donationDate) {
        blood.rh = rh;
        blood.type = type;
        this.quantity = quantity;
        this.donationDate = donationDate;
    }

}