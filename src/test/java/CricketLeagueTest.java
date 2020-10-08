import com.bridgelabz.RunsCSV;
import com.csvbuilder.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueTest {

public static final String MOST_RUNS_CSV = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
public static final String MOST_WICKET_CSV = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLRunsCensusCSVFile_ReturnsCorrectRecords() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numOfRecords = iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            Assert.assertEquals(100, numOfRecords);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givingIPLRunsCSVFile_WhenSortOnBattingAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String sortedCensusData = iplAnalyzer.getSortedAverage();
            RunsCSV[] runsCSV = new Gson().fromJson(sortedCensusData, RunsCSV[].class);
            Assert.assertEquals("MS Dhoni", runsCSV[0].player);

        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }


}
