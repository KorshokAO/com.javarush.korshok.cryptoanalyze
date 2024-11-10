
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;


public class FileManager {
    //ЧТЕНИЕ И ЗАПИСЬ В ЛИСТ СТРОК
    public static List<String> readFile(Path filePath) {
        try {
            return Files.readAllLines(filePath, UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("ОШИБКА ЧТЕНИЯ ФАЙЛА");
        }
    }
    //ЗАПИСЬ
    public static void writeFile(String content, Path filePath) {
        try {
            Files.write(filePath, content.getBytes(UTF_8), StandardOpenOption.APPEND);
        } catch (Exception e) {
            throw new RuntimeException("ОШИБКА ЗАПИСИ ФАЙЛА");
        }

    }


}
