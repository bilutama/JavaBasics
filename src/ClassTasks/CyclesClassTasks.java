package ClassTasks;

public class CyclesClassTasks {
    public static void main(String[] args) {
        // TASK 1 ==================================
        for (int i = 100; i >= 0; --i) {
            if (i % 4 == 0) {
                System.out.printf("%d%n", i);
            }
        }
        
        // TASK 2 ==================================
        int n = 5;
        
        for (int i = 1; i <= n; ++i) {
            System.out.printf("%d%n", i*i);
        }

        // TASK 3 ==================================
        
        int x = 4;
        int y = 10;
        int sum = 0;
        
        for (int i = x; i <= y; ++i) {
            sum += i;
        }

        double average = (double) sum / (y - x + 1);
    }
}
