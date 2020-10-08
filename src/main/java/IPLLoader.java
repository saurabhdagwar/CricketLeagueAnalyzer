import com.bridgelabz.RunsCSV;
import com.bridgelabz.RunsWicketDAO;
import com.bridgelabz.WicketCSV;
import com.csvbuilder.CSVBuilderException;
import com.csvbuilder.CSVBuilderFactory;
import com.csvbuilder.ICSVBuilder;

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
}
