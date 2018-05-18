package ro.blooddonation.core.Domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "donations")
public class Donation extends BaseEntity<Long>
{
//    @Embedded
//    @AttributeOverride(name = "type", column = @Column(name = "rh"))
//    private Blood blood;

    @Enumerated(EnumType.STRING)
    @Column
    private BloodEnum blood;

    @Column
    private Double bloodQuantity;

    @Column
    private Double plasmaQuantity;

    @Column
    private Double thrombocytesQuantity;

    @Column
    private Double redCellsQuantity;

    @Column
    private LocalDate donationDate;

    @ElementCollection
    @CollectionTable(name = "donationsDiseases")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "diseaseName")
    @Column
    private Map<DiseasesEnum, Boolean> diseases;

    @Transient
    public static final Integer plasmaExp = 365;
    @Transient
    public static final Integer thrombocytesExp = 42;
    @Transient
    public static final Integer redCellsExp = 5;

    /**
     * @param donationDate: LocalDate
     */
    public Donation(LocalDate donationDate, Double bloodQuantity)
    {
        this.donationDate = donationDate;
        this.bloodQuantity = bloodQuantity;
        this.blood = null;
        this.diseases = new EnumMap<DiseasesEnum, Boolean>(DiseasesEnum.class);
        this.bloodQuantity = null;
        this.plasmaQuantity = null;
        this.thrombocytesQuantity = null;
        this.redCellsQuantity = null;
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

    public void setBloodQuantity(Double bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    private Boolean hasDisease()
    {
        for(Map.Entry<DiseasesEnum, Boolean> entry : diseases.entrySet())
        {
            if(entry.getValue())
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Donation{blood=" + blood.toString() +
                ", bloodQ=" + bloodQuantity.toString() +
                ", plasmaQ=" + plasmaQuantity.toString() +
                ", thrombocytesQ=" + thrombocytesQuantity.toString() +
                ", redCellsQ" + redCellsQuantity.toString() +
                ", donationDate=" + donationDate.toString() +
                ", diseases=" + this.hasDisease() + "}";
    }
}