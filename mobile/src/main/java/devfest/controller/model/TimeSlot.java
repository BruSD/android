package devfest.controller.model;

import java.util.ArrayList;

/**
 * Created by Brusd on 8/24/2016.
 */

public class TimeSlot {
    private String endTime;
    private String startTime;
    private ArrayList<Sessions> sessionses;

    public TimeSlot() {

    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public ArrayList<Sessions> getSessionses() {
        return sessionses;
    }

    public void setSessionses(ArrayList<Sessions> sessionses) {
        this.sessionses = sessionses;
    }
}
