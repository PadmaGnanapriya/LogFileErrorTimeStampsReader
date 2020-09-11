package lk.ac.uok.setu;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Padma Gnanapiya (SE/2017/014)
 */


public class LogReader {

    public void checkTimeFinding(String path) throws IOException {
        String t1 = "^^^^^^^Line NOw 43971 Takes times^^^^^^^^";
        String t3 = "^^^^^^^ Line NOw 1209981 Takes times^^^^^";

        long lastTime = 0l;
        long count = 0;
        lastTime = System.currentTimeMillis();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (t1.equals(data)) {
                    System.out.print("'" + data + "' ,Time =   ");
                    System.out.println(System.currentTimeMillis() - lastTime);
                }
                if (t3.equals(data)) {
                    System.out.print("'" + data + "' ,Time =   ");
                    System.out.println(System.currentTimeMillis() - lastTime);
                }
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(count + " lines read time(miliSecond) =  " + (System.currentTimeMillis() - lastTime) + "\n\n");


        lastTime = System.currentTimeMillis();
        ;
        count = 0l;
        String strpath = path;
        FileReader fr = new FileReader(strpath);
        BufferedReader br = new BufferedReader(fr);
        String data;
        int time = 0;

        String Conversion = "";
        do {
            data = br.readLine();
            if (t1.equals(data)) {
                System.out.print(data + ", Time =   ");
                System.out.println(System.currentTimeMillis() - lastTime);
            }
            if (t3.equals(data)) {
                System.out.print(data + ", Time =   ");
                System.out.println(System.currentTimeMillis() - lastTime);
            }
            count++;

        } while (data != null);
        fr.close();
        System.out.print(count + " lines read time(miliSecond) = " + (System.currentTimeMillis() - lastTime) + "\n\n");


//        lastTime=System.currentTimeMillis();;
//        count=0l;
//        ReversedLinesFileReader frr = new ReversedLinesFileReader(new File(strpath));
//        String ch;
//        do {
//            ch = frr.readLine();
//            if(t1.equals(ch)){
//                System.out.print(ch+", Time =   ");
//                System.out.println(System.currentTimeMillis()-lastTime);
//            }
//            if(t3.equals(ch)){
//                System.out.print(ch+", Time =   ");
//                System.out.println(System.currentTimeMillis()-lastTime);
//            }
//            count++;
//        } while (ch != null);
//        frr.close();
//        fr.close();
//        System.out.print(count+" lines read time(miliSecond) = "+(System.currentTimeMillis()-lastTime)+"\n\n");


//        System.out.println("NIO Reader : Load all file into RAM");
//        lastTime=System.currentTimeMillis();
//        Files.lines(Path.of(path))
//                .filter(line -> line.contains("^^^^^^^ Line NOw 124937 Takes times^^^^^"))
//                .forEach(System.out::println);
//        System.out.println(System.currentTimeMillis()-lastTime);
//        lastTime=System.currentTimeMillis();;
//        Files.lines(Path.of(path))
//                .filter(line -> line.contains("^^^^^^^^^ Line NOw 1209981"))
//                .forEach(System.out::println);
//        System.out.print(count+" lines read time(miliSecond) = "+(System.currentTimeMillis()-lastTime)+"\n\n");


//
        lastTime = System.currentTimeMillis();
        try (FileInputStream is = new FileInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            int b;
            while ((b = bis.read()) != -1) {
//                System.out.println("Byte: " + b);
//                System.out.print((char)b);
                if (t1.equals(b)) {
                    System.out.print(b + ", Time =   ");
                    System.out.println(System.currentTimeMillis() - lastTime);
                }
                if (t3.equals(b)) {
                    System.out.print(b + ", Time =   ");
                    System.out.println(System.currentTimeMillis() - lastTime);
                }
            }
            System.out.println("BufferedInputStream");
            System.out.print(count + " lines read time(miliSecond) = " + (System.currentTimeMillis() - lastTime) + "\n\n");


            lastTime = System.currentTimeMillis();
            try (FileReader reader = new FileReader(path);
                 BufferedReader bufferedReader = new BufferedReader((reader))) {
                int c;
                while ((c = bufferedReader.read()) != -1) {
//                    System.out.println("Char: " + (char) c);
                }
            }
            System.out.print("bufferedReader  ");
            System.out.print(count + " lines read time(miliSecond) =" + (System.currentTimeMillis() - lastTime) + "\n\n"); //334   // Read by a single letter


            lastTime = System.currentTimeMillis();
            try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
                lines.forEachOrdered(line -> process(line));
            }
            System.out.print(count + " lines read time(miliSecond) by API = " + (System.currentTimeMillis() - lastTime) + "\n\n");
        }

    }

    private void process(String line) {
        if (line.indexOf("ERROR") != -1) {
//            System.out.println(line);
        }
    }


}




//---------------------------------------------------


//"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1\lib\idea_rt.jar=52697:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;H:\A_Padma_Codes\Code_Java\LogFileErrorTimeStampsReader\out\production\LogFileErrorTimeStampsReader" lk.ac.uok.setu.Main
//        '^^^^^^^Line NOw 43971 Takes times^^^^^^^^' ,Time =   136
//        '^^^^^^^ Line NOw 1209981 Takes times^^^^^' ,Time =   1263
//        1210002 lines read time(miliSecond) =  1264
//
//        ^^^^^^^Line NOw 43971 Takes times^^^^^^^^, Time =   16
//        ^^^^^^^ Line NOw 1209981 Takes times^^^^^, Time =   288
//        1210003 lines read time(miliSecond) = 288
//
//        BufferedInputStream
//        1210003 lines read time(miliSecond) = 1090
//
//        bufferedReader  1210003 lines read time(miliSecond) =1228
//
//        1210003 lines read time(miliSecond) by API = 343
//
//        '^^^^^^^Line NOw 43971 Takes times^^^^^^^^' ,Time =   32
//        '^^^^^^^ Line NOw 1209981 Takes times^^^^^' ,Time =   870
//        1210002 lines read time(miliSecond) =  871
//
//        ^^^^^^^Line NOw 43971 Takes times^^^^^^^^, Time =   15
//        ^^^^^^^ Line NOw 1209981 Takes times^^^^^, Time =   315
//        1210003 lines read time(miliSecond) = 315
//
//        BufferedInputStream
//        1210003 lines read time(miliSecond) = 350
//
//        bufferedReader  1210003 lines read time(miliSecond) =419
//
//        1210003 lines read time(miliSecond) by API = 295