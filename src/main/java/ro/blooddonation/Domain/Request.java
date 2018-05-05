package ro.blooddonation.Domain;

import ro.blooddonation.Domain.Users.Doctor;

import javax.persistence.*;

@Entity
@Table(name = "Request")
public class Request
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RequestID")
    private Long id;

    @Column
    @Embedded
    private Blood blood;

    @Column
    private Integer urgency;

    @Column
    //
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
