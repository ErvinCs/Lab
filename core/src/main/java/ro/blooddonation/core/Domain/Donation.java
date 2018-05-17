package ro.blooddonation.core.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
//@NoArgsConstructor
//@Table(name = "donations")
public class Donation extends BaseEntity<Long>
{
//    @Column
//    @Embedded
    private Blood blood;

//    @Column
    private Double bloodQuantity;

//    @Column
    private Double plasmaQuantity;

//    @Column
    private Double thrombocytesQuantity;

//    @Column
    private Double redCellsQuantity;

//    @Column
    private LocalDate donationDate;

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
        this.bloodQuantity = null;
        this.plasmaQuantity = null;
        this.thrombocytesQuantity = null;
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
}