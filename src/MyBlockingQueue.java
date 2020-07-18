import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue <T> {
    final private List<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int  count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put (T t){
        try {
            lock.lock();
            while(lists.size() == MAX){
                System.out.println("队列元素满了，进入阻塞...");
                producer.await();
            }
            lists.add(t);
            System.out.println("添加了元素："+ t);
            count++;
            consumer.signalAll();
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("put 方法释放了锁");
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            while(lists.size() == 0){
                System.out.println("队列元素为空，进入阻塞...");
                consumer.await();
            }
            t = lists.remove(0);
            System.out.println("得到了元素："+ t);
            count--;
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("get 方法释放了锁");
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> mbq = new MyBlockingQueue<Integer>();
        Thread t1 = new Thread(){
            public void run(){
                try {
                    mbq.put(1);
                    Thread.sleep(1000);
                    mbq.put(2);
                    Thread.sleep(1000);
                    mbq.put(3);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){

                    while(true){
                        Integer item = mbq.get();
                    }

            }
        };

        t2.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t1.start();
    }
}
