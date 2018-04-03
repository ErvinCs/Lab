package ro.blooddonation.Domain;

public class Blood
{
    private String rh;
    private String type;

    /**
     * @param rh: String("+" or "-")
     * @param type: String("O1", "A2", "B3" or "AB4")
     */
    public Blood(String rh, String type) {
       this.rh = rh;
       this.type = type;
    }

    public String getRh()
    {
        return this.rh;
    }

    public String getType()
    {
        return this.type;
    }
}