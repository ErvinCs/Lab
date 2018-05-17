package ro.blooddonation.core.Domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@NoArgsConstructor
//@Table(name = "Request")
public class Request extends BaseEntity<Long>
{

//    @Column
//    @Embedded
    private Blood blood;

//    @Column
    private Integer urgency;

//    @Column
    private Doctor doctor;

//    @Column
    private String status;


    /**
     *
     * @param blood
     * @param urgency
     * @param doctor
     */
    public Request(Blood blood, Integer urgency, Doctor doctor)
    {
        this.blood = blood;
        this.urgency = urgency;
        this.doctor = doctor;
        this.status = "Request sent.";
    }

    public Blood getBlood() {
        return blood;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
