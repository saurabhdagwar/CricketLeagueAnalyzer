package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class WicketCSV {
    @CsvBindByName(column = "PLAYER", required = true )
    public String player;

    @CsvBindByName(column = "Mat", required = true )
    public int match;

    @CsvBindByName(column = "Ov", required = true )
    public Double overs;

    @CsvBindByName(column = "Wkts", required = true )
    public int wickets;

    @CsvBindByName(column = "5w", required = true )
    public int fiveWicket;

    @CsvBindByName(column = "4w", required = true )
    public int fourWicket;


    @CsvBindByName(column = "SR", required = true )
    public Double sr;

    @CsvBindByName(column = "Avg", required = true )
    public Double average;

    @CsvBindByName(column = "Econ", required = true )
    public Double economy;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "PLAYER='" + player + '\'' +
                ", Average='" + average + '\'' +
                ", Economy ='" + economy + '\'' +
                ", Match ='" + match + '\'' +
                ", Overs ='" + overs + '\'' +
                ", Four Wicket ='" + fourWicket + '\'' +
                ", Five Wicket  ='" + fiveWicket + '\'' +
                ", Wickets ='" + wickets + '\'' +
                ", Striking Rates ='" + sr + '\'' +
                '}';
    }



}
