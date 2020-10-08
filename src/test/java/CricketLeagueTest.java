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

    @Test
    public void givingIPLRunsCSVFile_WhenSortOnStrikingRate_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String sortedCensusData = iplAnalyzer.getSortedSR();
            RunsCSV[] runsCSV = new Gson().fromJson(sortedCensusData, RunsCSV[].class);
            Assert.assertEquals( (Double) 333.33, runsCSV[0].sr);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFile_WhenSortOnSixes_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String sixesHitters = iplAnalyzer.maximumSixesHitter();
            RunsCSV[] runsCSV = new Gson().fromJson(sixesHitters, RunsCSV[].class);
            Assert.assertEquals( "Andre Russell", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givingIPLRunsCSVFile_WhenSortOnFours_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String foursHitter = iplAnalyzer.maximumFoursHitter();
            RunsCSV[] runsCSV = new Gson().fromJson(foursHitter, RunsCSV[].class);
            Assert.assertEquals( "Shikhar Dhawan", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFile_WhenSortOnSixesAndFoursSR_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String hitters = iplAnalyzer.maximumFoursSixesHitter();
            RunsCSV[] runsCSV = new Gson().fromJson(hitters, RunsCSV[].class);
            Assert.assertEquals( "Andre Russell", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFile_WhenSortAverageWithSR_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String averageWithSR = iplAnalyzer.maxAverageWithSR();
            RunsCSV[] runsCSV = new Gson().fromJson(averageWithSR, RunsCSV[].class);
            Assert.assertEquals( "MS Dhoni", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFile_WhenSortRunsWithAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String averageWithSR = iplAnalyzer.maxRunsWithAvg();
            RunsCSV[] runsCSV = new Gson().fromJson(averageWithSR, RunsCSV[].class);
            Assert.assertEquals( "David Warner", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

}
