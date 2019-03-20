import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    //    Hamlet = 472
//    Horatio = 158
    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public String changeHoratioToTariq(String name) {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(name);
        name = matcher.replaceAll("Tariq");
        return name;
    }

    public String changeHamletToLeon(String name) {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(name);
        name = matcher.replaceAll("Leon");
        return name;
    }

    public Boolean findHoratio(String name) {
        Pattern myPattern = Pattern.compile("Horatio");
        Matcher m = myPattern.matcher(name);
        if (m.find())
            return true;
        else
            return false;
    }

    public Boolean findHamlet(String name) {
        Pattern myPattern = Pattern.compile("Hamlet");
        Matcher m = myPattern.matcher(name);
        if (m.find())
            return true;
        else
            return false;
    }
}
