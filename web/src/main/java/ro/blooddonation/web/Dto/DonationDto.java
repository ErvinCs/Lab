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
@AllArgsConstructor
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

    /**
     * Deprecated
     */
    private String diseasesToString()
    {
        String str = "(";
        for(Map.Entry<DiseasesEnum, Boolean> entry : diseases.entrySet())
        {
            str += "<" + entry.getKey().toString() + ", " +
                    entry.getValue().toString() + ">";
        }
        str += ")";
        return str;
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
