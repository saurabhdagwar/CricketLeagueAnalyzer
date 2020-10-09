import com.bridgelabz.RunsCSV;
import com.bridgelabz.RunsWicketDAO;
import com.bridgelabz.WicketCSV;
import com.csvbuilder.CSVBuilderException;
import com.csvbuilder.CSVBuilderFactory;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public class IPLLoader {
    public <E> Map<String, RunsWicketDAO> loadCensusData(Class<E> IPLCSVClass, String csvFilePath) throws CSVBuilderException {
        Map<String, RunsWicketDAO> iplMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            Iterator<E> iplIterator = CSVBuilderFactory.createCSVBuilder().getCSVFileIterator(reader, IPLCSVClass);
            Iterable<E> iplCSV = () -> iplIterator;
            String className = IPLCSVClass.getSimpleName();
            switch (className) {
                case "RunsCSV":
                    StreamSupport.stream(iplCSV.spliterator(), false)
                            .map(RunsCSV.class::cast)
                            .forEach(iplCSVObj -> iplMap.put(iplCSVObj.player, new RunsWicketDAO(iplCSVObj)));
                    break;
                case "WicketCSV" :
                    StreamSupport.stream(iplCSV.spliterator(), false)
                            .map(WicketCSV.class::cast)
                            .forEach(iplCSVObj -> iplMap.put(iplCSVObj.player, new RunsWicketDAO(iplCSVObj)));
                    break;
            }
            return iplMap;
        } catch (IOException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public Map<String, RunsWicketDAO> loadBothData(String CSVPath1,String CSVPath2) throws CSVBuilderException {
        Map<String, RunsWicketDAO> map1 = loadCensusData( RunsCSV.class,CSVPath1);
        Map<String, RunsWicketDAO> map2 = loadCensusData( WicketCSV.class,CSVPath2);
        Map<String, RunsWicketDAO> iplMap = new HashMap<>();
        for(Map.Entry<String, RunsWicketDAO> m1: map1.entrySet()){
            for (Map.Entry<String, RunsWicketDAO> m2: map2.entrySet()){
                if(m1.getValue().player.equals(m2.getValue().player)){
                    iplMap.put(m2.getKey(),m2.getValue());
                }
            }
        }
        return iplMap;
        }
    }

