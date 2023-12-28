import java.util.LinkedList;
import java.util.Queue;

public class RR {
    private Queue<Process> processQueue;
    private int currentTime = 0;
    private final int totalMemory = 1024;
    private int availableMemory = totalMemory;
    private int timeQuantum = 2; // Round Robin time quantum (you can adjust this)

    public RR() {
        processQueue = new LinkedList<>();
    }

    public void addProcess(Process process) {
        processQueue.add(process);
    }

    public void schedule() {
        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();
            if (currentProcess.memory <= availableMemory) {
                runProcess(currentProcess);
                // Eğer işlem tamamlanmadıysa, tekrar kuyruğa ekleyin
                if (currentProcess.processTime > 1) {
                    processQueue.add(currentProcess);
                }
            } else {
                System.out.println("Not enough memory to run process: " + currentProcess);
            }
        }
    }

    private void runProcess(Process process) {
        System.out.println("Running process using RR: " + process);
        availableMemory -= process.memory; // Bellek tahsisi

        // Burada, işlem süresi azaltılmak yerine doğrudan tamamlanmış olarak işaretleniyor.
        process.status = "COMPLETED";
        availableMemory += process.memory; // Belleği serbest bırak
        System.out.println("Process completed: " + process);
    }
}
