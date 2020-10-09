package com.bridgelabz;

public class AllRounderDAO {
    public String player;
    public int match;
    public Double sr;
    public Double average;

    public AllRounderDAO(RunsCSV runsCSV) {
        player = runsCSV.player;
        match = runsCSV.match;
        sr = runsCSV.sr;
        average = runsCSV.average;
    }
    public AllRounderDAO(WicketCSV wicketCSV) {
        player = wicketCSV.player;
        match = wicketCSV.match;
        sr = wicketCSV.sr;
        average = wicketCSV.average;
    }

}
