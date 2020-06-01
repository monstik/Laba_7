import java.util.ArrayList;
import java.util.List;

public class MonteСarlo {

    private long GLOBAL_ADEQUATE_POINTS = 0;
    private long GLOBAL_ITERATIONS = 0;
    private int threadsCount = 0;

    public MonteСarlo(int threadsCount, long globalIterationsNumber) {
        if (threadsCount > 0)
            this.threadsCount = threadsCount;
        if (globalIterationsNumber > 0)
            this.GLOBAL_ITERATIONS = globalIterationsNumber;
    }

    private List<Executor> executors = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    private long calcTime = 0;
    public final double GetCalculationTime() {
        return calcTime / Math.pow(10, 9);
    }
    public final long GetIterations() {
        return GLOBAL_ITERATIONS;
    }
    public final long GetSuitablePoints() {
        return GLOBAL_ADEQUATE_POINTS;
    }

    public double CalculatePi() throws InterruptedException {
        long startTime = System.nanoTime();
        for (int i = 0; i < threadsCount; i++) {
            Executor executor = new Executor(GLOBAL_ITERATIONS / threadsCount);
            Thread thread = new Thread(executor);
            thread.start();
            executors.add(executor);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            if (thread.isAlive()){
                thread.join();
            }
        }
        GLOBAL_ITERATIONS = 0;
        for (Executor executor : executors) {
            GLOBAL_ADEQUATE_POINTS += executor.GET_ADEQUATE_POINTS();
            GLOBAL_ITERATIONS += executor.GET_THREAD_ITERATIONS();
        }
        calcTime = System.nanoTime() - startTime;

        return (GLOBAL_ADEQUATE_POINTS * 1.0 / GLOBAL_ITERATIONS) * 4;
    }

}