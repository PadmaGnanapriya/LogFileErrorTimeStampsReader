package lk.ac.uok.setu;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String logPath = "H:\\A_Padma_Codes\\Code_Java\\SampleLogGenarator\\src\\lk\\ac\\uok\\setu\\sampleLogFile.log";
        String timeStampsRecodePath = "src\\main\\java\\timeStampsRecord.txt";



        LogReader logReaders = new LogReader();
        logReaders.checkTimeFinding(logPath);

        logReaders.checkTimeFinding(logPath);


    }
}
