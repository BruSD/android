package devfest.controller.model;

import java.util.ArrayList;

/**
 * Created by Brusd on 8/24/2016.
 */

public class Schedule {
    private ArrayList<Day> days;


    public Schedule() {

    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }
}
