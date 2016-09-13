package devfest.controller.model;

import java.util.ArrayList;

/**
 * Created by Brusd on 8/24/2016.
 */

public class Day {
    private String date;
    private String dateReadable;
//    private ArrayList<TimeSlot> timeslots;
//    private ArrayList<String> tracks;

    public Day() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateReadable() {
        return dateReadable;
    }

    public void setDateReadable(String dateReadable) {
        this.dateReadable = dateReadable;
    }

//    public ArrayList<TimeSlot> getTimeslots() {
//        return timeslots;
//    }

//    public void setTimeslots(ArrayList<TimeSlot> timeslots) {
//        this.timeslots = timeslots;
//    }
//
//    public ArrayList<String> getTracks() {
//        return tracks;
//    }
//
//    public void setTracks(ArrayList<String> tracks) {
//        this.tracks = tracks;
//    }
}
