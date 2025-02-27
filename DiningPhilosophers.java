import java.util.concurrent.Semaphore;

class Fork {
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Semaphore semaphore;

    public Philosopher(int id, Fork leftFork, Fork rightFork, Semaphore semaphore) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.semaphore = semaphore;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " thinks");
        Thread.sleep((int) (Math.random() * 10000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating");
        Thread.sleep((int) (Math.random() * 10000));
    }

    @Override
    public void run() {
        while (true) {
            try {
                think(); 

                semaphore.acquire(); 

                synchronized (leftFork) {
                    System.out.println("Philosopher " + id + " took fork " + leftFork.getId());
                    synchronized (rightFork) {
                        System.out.println("Philosopher " + id + " took fork " + rightFork.getId());
                        eat(); 
                    }
                    System.out.println("Philosopher " + id + " returned fork " + rightFork.getId());
                }
                System.out.println("Philosopher " + id + " returned fork " + leftFork.getId());

                semaphore.release(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Fork[] forks = new Fork[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        // Создаем семафор с количеством разрешений = numPhilosophers - 1
        Semaphore semaphore = new Semaphore(numPhilosophers - 1);

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < numPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, semaphore);
            philosophers[i].start();
        }
    }
}