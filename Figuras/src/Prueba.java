import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        String fileName = "my-file.txt";
        try{
            List<String> lines = Arrays.asList("The first line", "The second line");
            Path file = Paths.get(fileName);
            System.out.println(file.toString());
            Files.write(file, lines, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
