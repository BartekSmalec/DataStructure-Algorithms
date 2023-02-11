package multithreading.racecondition;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("test", 22);
        map.put("bartek", 13);
        map.put("ada", 15);
        map.put("key", 20);
    }

    public static void main(String[] args) throws InterruptedException {

        String key = map.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(m -> m.getKey())
                .get();

        //System.out.println("Key is: " +  key);


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

/*    public static class InventoryCounter {
        private int items = 0;

        public int getItems() {
            return items;
        }

        public synchronized void increment() {
            items++;
        }

        public synchronized void decrement() {
            items--;
        }
    }*/

 /*   public static class InventoryCounter {
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
    }*/

    public static class InventoryCounter {
        private int items = 0;

        Object lock = new Object();

        public int getItems() {
            return items;
        }

        public void increment() {
            synchronized (lock) {
                items++;
            }
        }

        public void decrement() {
            synchronized (lock) {
                items--;
            }
        }
    }
}
