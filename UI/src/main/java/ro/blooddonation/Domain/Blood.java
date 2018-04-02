package ro.blooddonation.Domain;

import java.util.*;

public class Blood
{
    protected String rh;
    protected String type;
    protected Map testResults = null;

    /**
     * @param rh: String("+" or "-")
     * @param type: String("O1", "A2", "B3" or "AB4")
     */
    public Blood(String rh, String type) {
       this.rh = rh;
       this.type = type;
       this.testResults = new HashMap<String, Boolean>();

    }

    private void initTestResults()
    {
        //TODO: nuj exact cum sa modelez treaba asta
    }
}