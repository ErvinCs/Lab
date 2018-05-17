package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoningCenterDto extends BaseDto
{
    private String address;

    @Override
    public String toString()
    {
        return "DoningCenter{id=" + this.getId() + "; " + address.toString() + "}";
    }

}
