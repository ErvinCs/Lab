package ro.blooddonation.Domain;

import ro.blooddonation.Domain.Users.Doctor;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST")
public class Request
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @Embedded
    private Blood blood;

    @Column
    private Integer urgency;

    @Column
    @Embedded
    private Doctor doctor;

    @Column
    private String status;

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
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {this.blood = blood;}

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency){this.urgency = urgency;}

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {this.id = id;}
}
