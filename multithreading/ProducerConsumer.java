/*
 * Producer-Consumer Program.
 *
 * This program demonstrates thread coordination using a shared bounded queue.
 * The producer generates integer tasks and adds them to the queue, while the
 * consumer removes and processes them. Synchronization is handled using
 * wait() and notifyAll() to prevent race conditions, overflow, and underflow.
 */
package multithreading;
import java.util.LinkedList;
import java.util.Queue;

class TaskQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public TaskQueue(int capacity) {
        this.capacity = capacity;
    }

    //Producer adds task
    public synchronized void produce(int task) {
        while(queue.size() == capacity) {
            try {
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        queue.add(task);
        System.out.println("Produced: " + task);
        notifyAll(); //
    }
    public synchronized int consume(){
        while (queue.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        int task = queue.poll();
        System.out.println("Consumed: " + task);
        notifyAll();
        return task;
    }
}
class Producer extends Thread {
    private final TaskQueue queue;
    public Producer(TaskQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++){
                queue.produce(i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted.");
        }
    }
}
//no
class Consumer extends Thread {
    private final TaskQueue queue;
    public Consumer(TaskQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++){
                queue.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted.");
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args){
        TaskQueue queue = new TaskQueue(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Producer Consumer process completed.");
    }
}
