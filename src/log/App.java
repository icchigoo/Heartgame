package log;


// this class is used for finding log of the app

public class App {
    public static void main(String[] args) throws Exception {
       MyLog.writeToLog("started from external class", "info");
        try {
            for(int i=0; i<5; i++){
                int d = 10/1;
            }
        } catch (Exception e) {
            MyLog.writeToLog("Exception" + e.toString(), "error");
        }

        MyLog.writeToLog("Program Exectued Successfully", "info");
    }
}
