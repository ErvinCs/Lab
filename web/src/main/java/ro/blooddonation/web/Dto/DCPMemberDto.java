package ro.blooddonation.web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.blooddonation.core.Domain.DoningCenter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DCPMemberDto extends PersonDto
{
    private DoningCenterDto doningCenter;

    public DCPMemberDto(String firstName, String lastName, LocalDate bDay, String address, String residence, Long cnp, DoningCenterDto doningCenter) {
        super(firstName, lastName, bDay, address, residence, cnp);
        this.doningCenter = doningCenter;
    }

    public DoningCenterDto getDoningCenter() {
        return doningCenter;
    }

    public void setDoningCenter(DoningCenterDto doningCenter) {
        this.doningCenter = doningCenter;
    }
}
