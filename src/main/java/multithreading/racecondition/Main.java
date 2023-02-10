package multithreading.racecondition;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();

        //ThreadLocal<InventoryCounter> inventoryCounterThreadLocal = ThreadLocal.withInitial(InventoryCounter::new);

        IncrementingThread thread = new IncrementingThread(inventoryCounter);
        DecrementingThread dThread = new DecrementingThread(inventoryCounter);

        thread.start();
        dThread.start();

        thread.join();
        dThread.join();

        System.out.println(inventoryCounter.getItems());

    }

    public static class DecrementingThread extends Thread {
        InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {
        InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    public static class InventoryCounter {
        private int items = 0;

        public int getItems() {
            return items;
        }

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }
    }
}
