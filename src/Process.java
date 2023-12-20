public class Process {
    int arrivalTime;
    int priority;
    int processTime;
    int memory;
    int printers;
    int scanners;
    int modems;
    int cds;

    public Process(int arrivalTime, int priority, int processTime, int memory,
                   int printers, int scanners, int modems, int cds) {
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.processTime = processTime;
        this.memory = memory;
        this.printers = printers;
        this.scanners = scanners;
        this.modems = modems;
        this.cds = cds;
    }

    @Override
    public String toString() {
        return arrivalTime + "," + priority + "," + processTime + "," + memory + ","
                + printers + "," + scanners + "," + modems + "," + cds;
    }
}