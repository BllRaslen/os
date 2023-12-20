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
            } else {
                System.out.println("Not enough memory to run process: " + currentProcess);
            }
            // Add the process back to the queue if it's not completed
            if (currentProcess.processTime > 0) {
                processQueue.add(currentProcess);
            }
            try {
                Thread.sleep(100); // Simulate time passing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runProcess(Process process) {
        System.out.println("Running process using RR: " + process);
        availableMemory -= process.memory; // Allocate memory
        // Simulate process running for a time quantum
        for (int i = 0; i < timeQuantum && process.processTime > 0; i++) {
            process.processTime--;
            currentTime++;
            try {
                Thread.sleep(100); // Simulate time passing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableMemory += process.memory; // Release memory
        System.out.println("Process completed: " + process);
    }
}