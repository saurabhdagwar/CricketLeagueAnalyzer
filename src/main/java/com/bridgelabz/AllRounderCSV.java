package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class AllRounderCSV {

    @CsvBindByName(column = "PLAYER", required = true )
    public String player;

    @CsvBindByName(column = "Mat", required = true )
    public int match;

    @CsvBindByName(column = "Runs", required = true )
    public int runs;

    @CsvBindByName(column = "Wkts", required = true )
    public int wickets;

    @CsvBindByName(column = "SR", required = true )
    public Double sr;

    @CsvBindByName(column = "Avg", required = true )
    public Double average;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "PLAYER='" + player + '\'' +
                "Match='" + match + '\'' +
                ", Total runs='" + runs + '\'' +
                ", Wickets ='" + wickets + '\'' +
                ", Average='" + average + '\'' +
                ", Striking Rates ='" + sr + '\'' +

                '}';
    }
}
