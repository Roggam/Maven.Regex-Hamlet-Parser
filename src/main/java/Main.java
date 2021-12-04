import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HamletParser hamletParser = new HamletParser();
        System.out.println(hamletParser.parser());
        hamletParser.output();
       // System.out.println(hamletParser.getHamletData());
    }
}
