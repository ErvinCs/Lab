package ro.blooddonation.web.Dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalDto extends BaseDto
{
    private String address;

    @Override
    public String toString()
    {
        return "Hospital{id=" + this.getId() + "; " + address.toString() + "}";
    }
}
