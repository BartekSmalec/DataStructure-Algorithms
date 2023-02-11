package multithreading.racecondition.datarace;

public class Main {
    public static void main(String[] args) {
        DataRaceExample sharedClass = new DataRaceExample();

        Thread one = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkIfRanceConditionOccurs();
            }
        });

        one.start();
        two.start();
    }

    public static class DataRaceExample {
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkIfRanceConditionOccurs() {
            if (y > x) System.out.println("Data race is detected");
        }
    }
}
