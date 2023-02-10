package multithreading.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Long> inputNumber = Arrays.asList(0L, 123L, 211L, 1234L, 123L, 22L);

        List<FactorialThread> threads = new ArrayList<>();

        inputNumber.forEach(l -> threads.add(new FactorialThread(l)));

        threads.forEach(t -> t.start());

        threads.forEach(t -> {
            try {
                t.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threads.forEach(thread -> {
            if (thread.isFinished()) {
                System.out.println("Factorial of: " + thread.getInputNumber() + " is: " + thread.getResult());
            } else {
                System.out.println("The calculation for: " + thread.getInputNumber() + " is still in progress");
            }
        });


    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public long getInputNumber() {
            return inputNumber;
        }

        public void setInputNumber(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        public BigInteger getResult() {
            return result;
        }

        public void setResult(BigInteger result) {
            this.result = result;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void setFinished(boolean finished) {
            isFinished = finished;
        }
    }
}
