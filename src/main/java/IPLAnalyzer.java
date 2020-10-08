import com.bridgelabz.RunsCSV;
import com.bridgelabz.RunsWicketDAO;
import com.csvbuilder.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;

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
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.average);
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }

    public String getSortedSR() throws CSVBuilderException {
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.sr);
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }

    public String maximumSixesHitter() throws CSVBuilderException{
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.sixes);
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }

    public String maximumFoursHitter() throws CSVBuilderException{
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.fours );
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }

    public String maximumFoursSixesHitter() throws CSVBuilderException{
        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> census.fours + census.sixes );
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }

    public String maxAverageWithSR() throws CSVBuilderException {

        Comparator<RunsWicketDAO> censusComparator = Comparator.comparing(census -> ((census.average)/334)*100 + ((census.sr)*334)*100 );
        this.sortIPLData(censusComparator);
        String sortedStatedCensusJson = new Gson().toJson(this.iplList);
        return sortedStatedCensusJson;
    }


    private void sortIPLData( Comparator<RunsWicketDAO> csvComparator) throws CSVBuilderException {
        if(iplMap == null || iplMap.size() ==0){
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
        iplList.addAll(iplMap.values());
        for (int i=0 ; i<iplList.size()-1;i++)
        {
            for (int j=0 ; j<iplList.size()-i-1;j++){
                RunsWicketDAO census1=iplList.get(j);
                RunsWicketDAO census2=iplList.get(j+1);
                if(csvComparator.compare(census1,census2) < 0)
                {
                    iplList.set(j,census2);
                    iplList.set(j+1,census1);
                }
            }
        }
    }


}
