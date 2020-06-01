public class Executor implements Runnable {

    private long THREAD_ITR;
    private long ADEQUATE_POINTS = 0;

    public Executor(long iterations) {
        this.THREAD_ITR = iterations;
    }

    public final long GET_THREAD_ITERATIONS() {
        return THREAD_ITR;
    }

    public final long GET_ADEQUATE_POINTS() {
        return ADEQUATE_POINTS;
    }

    @Override
    public void run() {

        int currentIterations = 0;

        while (currentIterations < THREAD_ITR) {

            double x = Math.random();
            double y = Math.random();
            double distance = Math.sqrt((x * x) + (y * y));

            if (distance <= 1) {

                ADEQUATE_POINTS++;
            }
            currentIterations++;
        }
    }
}