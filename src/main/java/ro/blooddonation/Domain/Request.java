package ro.blooddonation.Domain;

import ro.blooddonation.Domain.Users.Doctor;

public class Request
{
    private Blood blood;
    private Integer urgency;
    private Doctor doctor;
    private String status;
    private Long id;
    private static Long idGen = Long.valueOf(1);

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
        this.id = idGen;
        idGen += 1;
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
