package multithreading.runnable;

import java.math.BigInteger;

public class DeamonThreadsAndInterrupt {
    public static void main(String[] args) {

  /*      Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
   */
        Thread thread2 = new Thread(new LongComputationTask(new BigInteger("20000000"), new BigInteger("10000000000")));

        //thread2.setDaemon(true);
        thread2.start();
        thread2.interrupt();

    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exit blocking thread");
            }
        }
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematureley interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }


}


