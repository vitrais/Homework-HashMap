public class Alternation {
    private static final Object LOCK = new Object();
    private static boolean queue = true;
    /**
     * method to run the alternation
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    while (!queue) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("1");
                    queue = false;
                    LOCK.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    while (queue) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print("2");
                    queue = true;
                    LOCK.notifyAll();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
