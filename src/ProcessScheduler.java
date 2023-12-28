import java.util.Comparator;
import java.util.PriorityQueue;

class ProcessScheduler {
    private PriorityQueue<Process> processQueue;
    private final int totalMemory = 1024;
    private int availableMemory = totalMemory;

    public ProcessScheduler() {
        processQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.arrivalTime));
    }

    public void addProcess(Process process) {
        processQueue.add(process);
    }

    public void schedule() {
        while (!processQueue.isEmpty()) {
            Process process = processQueue.poll();

            // Eğer işlem bellek sınırlarını aşıyorsa:
            if (process.memory > availableMemory) {
                process.setStatus("HATA - Proses çok sayıda kaynak talep ediyor - proses silindi");
            }
            // Eğer gerçek-zamanlı proses var ve belleği aşıyorsa:
            else if (process.priority == 1 && process.memory > 64) {
                process.setStatus("HATA - Gerçek-zamanlı proses (" + process.memory + "MB) tan daha fazla bellek talep ediyor - proses silindi");
            }
            // Diğer durumlar için işlemi çalıştırın:
            else {
                // Proses çalıştırma kodları burada olacak.
                process.setStatus("RUNNING");
                // Prosesin çalışma simülasyonu burada olacak.
                process.setStatus("COMPLETED");
            }
            System.out.println(process); // Proses sonucunu yazdır
        }
    }
}