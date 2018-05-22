package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class PersonDto extends BaseDto
{
    private Long CNP;

    private String firstName;

    private String lastName;

    private LocalDate bDay;

    private String address;

    private String residence;

}
