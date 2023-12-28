import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "giris.txt";
        ProcessScheduler scheduler = new ProcessScheduler(); // ProcessScheduler nesnesi oluşturuldu.

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    Process process = new Process(
                            Integer.parseInt(parts[0].trim()), // PID
                            Integer.parseInt(parts[1].trim()), // Arrival Time
                            Integer.parseInt(parts[2].trim()), // Priority
                            Integer.parseInt(parts[3].trim()), // CPU Time
                            Integer.parseInt(parts[4].trim()), // Memory
                            Integer.parseInt(parts[5].trim()), // Printers
                            Integer.parseInt(parts[6].trim()), // Scanners
                            Integer.parseInt(parts[7].trim()), // Modems
                            0 // CDs, varsayılan olarak 0 alındı çünkü girdide yok.
                    );
                    scheduler.addProcess(process); // ProcessScheduler'a proses eklendi.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scheduler.schedule(); // Zamanlama başlatıldı.
    }
}