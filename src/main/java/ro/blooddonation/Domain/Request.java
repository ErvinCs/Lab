package ro.blooddonation.Domain;

import ro.blooddonation.Domain.Users.Doctor;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST")
public class Request
{
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Blood blood;

    @Column
    private Integer urgency;

    @Column
    private Doctor doctor;

    @Column
    private String status;

    //private static Long idGen = Long.valueOf(1);

    /**
     * Default constructor
     */
    public Request() {}
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
        //this.id = idGen;
        //idGen += 1;
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

    public Long getId() {
        return this.id;
    }
}
