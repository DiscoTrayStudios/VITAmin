package parsing;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    File testFile = new File("src/test/testDataExamples/exampleData1.csv").getCanonicalFile();
    FileParser parserObject = new FileParser(testFile);
    FileParserTest() throws IOException {
    }

    @Test
    void capitalizeNames() {
        assertEquals("JOHN", parserObject.getClientProperty(parserObject.getClient("A1234"), "FIRSTNAME"));
    }

    @Test
    void createKey() {
        List<String> line = parserObject.removeCommas(parserObject.fileLines.get(1));
        assertEquals("A1234", parserObject.createKey(line));
    }

    @Test
    void getColumn() {
        assertEquals(0, parserObject.getColumn("EFIN"));
    }

    @Test
    void getColumnNames() {
        List<String> columnNames = Arrays.asList("EFIN","Last 4","Preparer Name","Agency ID","Return Type","Residency",
                                                 "FilingStatus","First Name","Last Name","Ack Code","Refund",
                                                 "Balance Due","State Withholding","State EIC","State Tax Liability",
                                                 "Created Date Time", "Zip", "State");
        columnNames.replaceAll(String::toUpperCase);
        columnNames.replaceAll(s -> s.replaceAll("\\s+", ""));
        assertEquals(columnNames, parserObject.getColumnNames());
    }

    @Test
    void parseCSV() {
        System.out.println(parserObject.data);
    }

    @Test
    void removeCommas() {
        List<String> line = parserObject.removeCommas(parserObject.fileLines.get(parserObject.fileLines.size()-1));
        String balanceDue = line.get(11);
        assertEquals("3419.00", balanceDue);
    }

    @Test
    void reformatDOB() {
    }

    @Test
    void reformatSS() {
        int ssColumn = parserObject.getColumn("LAST4");
        List<String> line1 = parserObject.removeCommas(parserObject.fileLines.get(2));
        parserObject.reformatSS(line1, ssColumn);
        List<String> line2 = parserObject.removeCommas(parserObject.fileLines.get(3));
        parserObject.reformatSS(line2, ssColumn);
        List<String> line3 = parserObject.removeCommas(parserObject.fileLines.get(4));
        parserObject.reformatSS(line3, ssColumn);
        assertEquals("5678", line1.get(ssColumn));
        assertEquals("9012", line2.get(ssColumn));
        assertEquals("0123", line3.get(ssColumn));
    }

    @Test
    void removeXChars() {
        assertEquals("5678", parserObject.removeXChars("xxxx5678"));
    }
}