import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class dz2 {
    public static void main(String[] args) {
        tasks();
    }
    
    static void tasks(){
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(simpleFormatter);
            
        } catch (SecurityException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);   

        String json = "{[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"
                        +"{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"
                        +"{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]}";

        json = json.substring(4, json.length()-4);
        String[] student = json.split("},"); //\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"
        StringBuilder name = new StringBuilder();
        StringBuilder rate = new StringBuilder();
        StringBuilder object = new StringBuilder();      
        
        for (int k = 0; k < student.length; k++) {
            for (int i = 0; i < student.length; i++) {
                String[] parse1 = student[k].split(",");//\"фамилия\":\"Иванов\"
                String[] parse2 = parse1[i].split(":");//\"фамилия\"
                if (i == 0) {
                    name.append(parse2[1]+"\n");
                }else if (i == 1) {
                    rate.append(parse2[1]+"\n");
                }else if (i == 2) {
                    object.append(parse2[1]+"\n");
                }
            }          
        }
        String nameStr = name.toString();
        String formatNameStr = nameStr.replaceAll("\"", "");
        String[] nameArr = formatNameStr.split("\n");
        
        String rateStr = rate.toString();
        String formatRateString = rateStr.replaceAll("\"", "");
        String[] rateArr = formatRateString.split("\n");
        
        String objectStr = object.toString();
        String formatObjectString = objectStr.replaceAll("\"", "");     
        String[] objectArr = formatObjectString.split("\n");

        for (int i = 0; i < 3; i++) {
            System.out.printf("Студент %s получил %s по предмету %s. \n", nameArr[i], rateArr[i], objectArr[i]);
        }
        logger.log(Level.INFO, "Все хорошо");
    }
}




