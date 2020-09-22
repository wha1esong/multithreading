
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();
        Condition condition3=lock.newCondition();
        Condition condition4=lock.newCondition();
        lock.lock();
        Thread.sleep(3000);

        new Thread(() -> {
            System.out.println("t1 start");
            lock.lock();
            try {
                System.out.println("t1 get lock");
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "t1").start();
//        Thread.sleep(100);
//        new Thread(() -> {
//            System.out.println("t2 start");
//            lock.lock();
//            lock.unlock();
//            System.out.println("t2 get lock");
//        }, "t2").start();
//        Thread.sleep(100);
//        new Thread(() -> {
//            System.out.println("t3 start");
//            lock.lock();
//            lock.unlock();
//            System.out.println("t3 get lock");
//        }, "t3").start();
//        Thread.sleep(100);
//        new Thread(() -> {
//            System.out.println("t4 start");
//            lock.lock();
//            lock.unlock();
//            System.out.println("t4 get lock");
//        }, "t4").start();
        Thread.sleep(3000);

        lock.unlock();

    }


}

