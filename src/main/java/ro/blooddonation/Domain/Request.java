package ro.blooddonation.Domain;

public class Request
{
    private Blood blood;
    private Integer urgency;
    private Hospital hospital;
    private Long id;
    private static Long idGen = Long.valueOf(1);

    public Request(Blood blood, Integer urgency, Hospital hospital)
    {
        this.blood = blood;
        this.urgency = urgency;
        this.hospital = hospital;
        this.id = idGen;
        idGen += 1;
    }

    public Long getId()
    {
        return this.id;
    }

    public Blood getBlood() {
        return blood;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public Hospital getHospital() {
        return hospital;
    }
}
