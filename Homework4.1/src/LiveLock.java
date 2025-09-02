public class LiveLock {
    private static boolean canMove = true;
    /**
     * method to run the LiveLock
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (canMove) {
                    System.out.println("Thread 1 move");
                    canMove = false;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!canMove) {
                        System.out.println("Thread 1 back");
                        canMove = true;
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (canMove) {
                    System.out.println("Thread 2 move");
                    canMove = false;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!canMove) {
                        System.out.println("Thread 2 back");
                        canMove = true;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}