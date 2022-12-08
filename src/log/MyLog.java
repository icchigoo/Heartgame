package log;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class MyLog {
    
    public static void writeToLog(String msg, String filename){
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName =  filename+"_"+formattedDate+".txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            LocalDateTime currentDateTime = LocalDateTime.now();
            String format = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            writer.append(format+":");
            writer.append(msg+"\n");
            writer.close();

            
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Exception writing logs" + e.getMessage());
            
        }

      

    }
}
