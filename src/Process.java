class Process {
    int pid;
    int arrivalTime;
    int priority;
    int cpuTime;
    int processTime; // Eksik olan processTime alanı eklendi.
    int memory;
    int printers;
    int scanners;
    int modems;
    int cds;
    String status;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getPrinters() {
        return printers;
    }

    public void setPrinters(int printers) {
        this.printers = printers;
    }

    public int getScanners() {
        return scanners;
    }

    public void setScanners(int scanners) {
        this.scanners = scanners;
    }

    public int getModems() {
        return modems;
    }

    public void setModems(int modems) {
        this.modems = modems;
    }

    public int getCds() {
        return cds;
    }

    public void setCds(int cds) {
        this.cds = cds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Process sınıfının constructor'ı güncellendi.
    public Process(int pid, int arrivalTime, int priority, int cpuTime, int memory,
                   int printers, int scanners, int modems, int cds) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.cpuTime = cpuTime;
        this.processTime = cpuTime; // processTime, cpuTime olarak başlatıldı.
        this.memory = memory;
        this.printers = printers;
        this.scanners = scanners;
        this.modems = modems;
        this.cds = cds;
        this.status = "WAITING"; // Initial status
    }

    // toString metodu güncellendi.
    @Override
    public String toString() {
        return String.format("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%s",
                pid, arrivalTime, priority, cpuTime, memory,
                printers, scanners, modems, cds, status);
    }
}