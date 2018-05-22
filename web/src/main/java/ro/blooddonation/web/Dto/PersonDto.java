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

    public PersonDto(Long id, String firstName, String lastName, LocalDate bDay, String address, String residence, Long cnp) {
        super(id);
        this.CNP = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;
        this.address = address;
        this.residence = residence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Long getCNP() { return this.CNP; }

    public void setCNP(Long CNP) {
        this.CNP = CNP;
    }

    public LocalDate getbDay()
    {
        return this.bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }
}
