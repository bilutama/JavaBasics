package ClassTasks;

public class CyclesClassTasks {
    public static void main(String[] args) {
        for (int i = 100; i >= 0; --i) {
            if (i % 4 == 0) {
                System.out.printf("%d%n", i);
            }
        }
        
        int n = 5;
        
        for (int i = 1; i <= n; ++i) {
            System.out.printf("%d%n", i*i);
        }

        
    }
}
