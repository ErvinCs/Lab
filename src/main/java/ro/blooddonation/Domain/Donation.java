package ro.blooddonation.Domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DONATION")
public class Donation
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "blood")
    private Blood blood;

    @Column(name = "bloodQuantity")
    private Double bloodQuantity;

    @Column(name = "plasmaQuantity")
    private Double plasmaQuantity;

    @Column(name = "thrombocytesQuantity")
    private Double thrombocytesQuantity;

    @Column(name = "redCellsQuantity")
    private Double redCellsQuantity;

    @Column(name = "donationDate")
    private LocalDate donationDate;

    //private static Long idGen = Long.valueOf(1);

    public static final Integer plasmaExp = 365;
    public static final Integer thrombocytesExp = 42;
    public static final Integer redCellsExp = 5;

    /**
     * Default constructor
     */
    public Donation() {}
    /**
     * @param donationDate: LocalDate
     */
    public Donation(LocalDate donationDate, Double bloodQuantity)
    {
        this.donationDate = donationDate;
        this.bloodQuantity = bloodQuantity;
        //this.id = idGen;
        //idGen += 1;
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