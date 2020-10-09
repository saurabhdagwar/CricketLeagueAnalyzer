import com.bridgelabz.RunsCSV;
import com.bridgelabz.WicketCSV;
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
            Assert.assertEquals(  "Ishant Sharma", runsCSV[0].player);
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
            Assert.assertEquals( "David Warner ", runsCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnBawlingAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortedAverage();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnBowlingStrikingRate_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortedSR();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Krishnappa Gowtham", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnBowlingEconomyRate_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnEconomy();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Ben Cutting", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnSRWithWickets_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnSRWithWicket();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Lasith Malinga", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnAverageWithSR_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.maxAverageWithSR();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Krishnappa Gowtham", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLWicketsCSVFile_WhenSortOnWicketsWithAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLWicketsCensusData(MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnWicketsWithAverage();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Imran Tahir", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLCSVFiles_WhenSortOnBattingAndBowlingAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numberOfRecord = iplAnalyzer.loadIPLCensusData(MOST_RUNS_CSV,MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortedAverage();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Krishnappa Gowtham", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLCSVFiles_WhenSortOnAllRounderRunsAndWickets_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            int numberOfRecord = iplAnalyzer.loadIPLCensusData(MOST_RUNS_CSV,MOST_WICKET_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnRunsAndWickets();
            WicketCSV[] wicketCSV = new Gson().fromJson(sortedCensusData, WicketCSV[].class);
            Assert.assertEquals(  "Kagiso Rabada", wicketCSV[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFiles_WhenSortOnHundredsAndAverage_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnHundredsAndAverage();
            RunsCSV[] runsCSVS = new Gson().fromJson(sortedCensusData, RunsCSV[].class);
            Assert.assertEquals(  "David Warner ", runsCSVS[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givingIPLRunsCSVFiles_WhenSortAverageWithout100s50s_ShouldReturnSortedResult() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIPLRunsCensusData(MOST_RUNS_CSV);
            String sortedCensusData = iplAnalyzer.getSortOnAverageWithout100s50s();
            RunsCSV[] runsCSVS = new Gson().fromJson(sortedCensusData, RunsCSV[].class);
            Assert.assertEquals(  "Marcus Stoinis", runsCSVS[0].player);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
}