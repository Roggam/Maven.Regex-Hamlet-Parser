import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String parser(){
        String parsedString = "";
        Pattern pattern = Pattern.compile("(?i)(Hamlet)");
        Matcher matcher = pattern.matcher(loadFile());

        while(matcher.find()) {
         parsedString = matcher.replaceAll("Leon");
        }

        Pattern pattern1 = Pattern.compile("(?i)(Horatio)");
        Matcher matcher1 = pattern1.matcher(parsedString);
        while (matcher1.find()){

            parsedString = matcher1.replaceAll("Tariq");
        }

        return  parsedString;
    }


     public void output() throws FileNotFoundException {

         FileOutputStream outputStream= new FileOutputStream("output.txt");
         Formatter formatter = new Formatter(outputStream);
          formatter.format(parser());
         formatter.flush();

     }



    public String getHamletData(){
        return hamletData;
    }

}
