package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class RunsWicketDAO {
    public String player;
    public int match;
    public int runs;
    public double sr;
    public double average;
    public int hundred;
    public int fifty;
    public int fours;
    public int sixes;
    public double overs;
    public int wickets;

    public RunsWicketDAO(RunsCSV runsCSV){
    player = runsCSV.player;
    match = runsCSV.match;
    runs = runsCSV.runs;
    sr = runsCSV.sr;
    average = runsCSV.average;
    hundred = runsCSV.hundred;
    fifty = runsCSV.fifty;
    fours = runsCSV.fours;
    sixes = runsCSV.sixes;
    }

    public RunsWicketDAO(WicketCSV wicketCSV){
        player = wicketCSV.player;
        match = wicketCSV.match;
        runs = wicketCSV.runs;
        overs = wicketCSV.overs;
        wickets = wicketCSV.wickets;
        sr = wicketCSV.sr;
        average = wicketCSV.average;

    }
}