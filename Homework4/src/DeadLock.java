public class DeadLock {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();
    /**
     * method to run DeadLock
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Ресурс 1 захвачен процессом 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Lock2) {
                    System.out.println("Ресурс 1 захвачен процессом 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (Lock2) {
                System.out.println("Ресурс 2 захвачен процессом 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Lock1) {
                    System.out.println("Ресурс 2 захвачен процессом 1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}