package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class RunsCSV {

    @CsvBindByName(column = "PLAYER", required = true )
    public String player;

    @CsvBindByName(column = "Mat", required = true )
    public int match;

    @CsvBindByName(column = "Runs", required = true )
    public int runs;

    @CsvBindByName(column = "SR", required = true )
    public Double sr;

    @CsvBindByName(column = "Avg", required = true )
    public Double average;

    @CsvBindByName(column = "100", required = true )
    public int hundred;

    @CsvBindByName(column = "50", required = true )
    public int fifty;

    @CsvBindByName(column = "4s", required = true )
    public int fours;

    @CsvBindByName(column = "6s", required = true )
    public int sixes;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "PLAYER='" + player + '\'' +
                "Match='" + match + '\'' +
                ", Total runs='" + runs + '\'' +
                ", Average='" + average + '\'' +
                ", Striking Rates ='" + sr + '\'' +
                ", Hundreds ='" + hundred + '\'' +
                ", Fifty ='" + fifty + '\'' +
                ", Fours ='" + fours + '\'' +
                ", Sixes ='" + sixes + '\'' +
                '}';
    }
}
