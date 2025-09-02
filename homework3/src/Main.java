import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Виктор\\Documents\\homework3.txt";
        FileOperations fileOps = new FileOperations(filePath);
        List<String> dataToWrite = List.of(
                "один",
                "два",
                "три"
        );

        try {
            System.out.println("Запись данных в файл...");
            fileOps.writeToFile(dataToWrite);
            System.out.println("Данные записаны успешно!");

            System.out.println("Чтение данных из файла...");
            List<String> readData = fileOps.readFromFile();
            System.out.println("Данные из файла:");
            for (String line : readData) {
                System.out.println(line);
            }
        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

class FileOperationException extends Exception {
    public FileOperationException(String message) {
        super(message);
    }
}

class FileOperations {
    private String filePath;
    public FileOperations(String filePath) {
        this.filePath = filePath;
    }

    /**
     * writing to a file
     */
    public void writeToFile(List<String> data) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    /**
     * reading to a file
     */
    public List<String> readFromFile() throws FileOperationException {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения из файла: " + e.getMessage());
        }
        return data;
    }
}
