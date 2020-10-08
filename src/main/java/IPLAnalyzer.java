import com.bridgelabz.RunsCSV;
import com.bridgelabz.RunsWicketDAO;
import com.csvbuilder.CSVBuilderException;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IPLAnalyzer {
    Map<String, RunsWicketDAO> iplMap ;
    List<RunsWicketDAO> iplList;
    public IPLAnalyzer(){
        this.iplMap = new HashMap<>();
        this.iplList = new ArrayList<>();
    }

    public int loadIPLRunsCensusData(String csvFilePath) throws CSVBuilderException {
        iplMap = new IPLLoader().loadCensusData(RunsCSV.class, csvFilePath);
        return iplMap.size();
    }

    public String getSortedAverage() throws CSVBuilderException {
        if(iplMap == null || iplMap.size() ==0){
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
        iplList.addAll(iplMap.values());
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.average,Comparator.reverseOrder());
        this.sortCensusData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);

        return sortedStatedCensusJson;
    }

    private void sortCensusData( Comparator<RunsWicketDAO> csvComparator) {
        for (int i=0 ; i<iplList.size()-1;i++)
        {
            for (int j=0 ; j<iplList.size()-i-1;j++){
                RunsWicketDAO census1=iplList.get(j);
                RunsWicketDAO census2=iplList.get(j+1);
                if(csvComparator.compare(census1,census2) > 0)
                {
                    iplList.set(j,census2);
                    iplList.set(j+1,census1);
                }
            }
        }
    }
}
