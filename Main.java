public class Main {

    public static void main(String[] args) {
        long iterations = 1000000;
        int threads = 20;
        MonteСarlo pi = new MonteСarlo(threads, iterations);
        double piValue = 0;
        try {
            piValue = pi.CalculatePi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("вычисление pi: " + piValue +
                "\n кол-во точек в кругу:" + pi.GetSuitablePoints() +
                "\nкол-во итераций:  " + pi.GetIterations() +
                "\nвремя вычесления:  " + pi.GetCalculationTime());

    }
}