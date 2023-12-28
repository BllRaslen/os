import java.util.Comparator;
import java.util.PriorityQueue;

class ProcessScheduler {
    private PriorityQueue<Process> processQueue;
    private int currentTime = 0;
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
            Process currentProcess = processQueue.peek();
            if (currentProcess != null && currentProcess.arrivalTime <= currentTime) {
                processQueue.poll();
                if (currentProcess.memory > availableMemory) {
                    currentProcess.setStatus("DELETED");
                } else if (currentProcess.cpuTime > 20) {
                    currentProcess.setStatus("TIME_EXCEEDED");
                } else {
                    runProcess(currentProcess);
                }
                System.out.println(currentProcess);
            }
            currentTime++;
            try {
                Thread.sleep(100); // Simulate time passing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runProcess(Process process) {
        process.setStatus("RUNNING");
        availableMemory -= process.memory;

        try {
            Thread.sleep(process.cpuTime * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        availableMemory += process.memory;
        process.setStatus("COMPLETED");
    }
}

