package stacksandqueue;

class StackNode{
    int data;
    StackNode next;

    StackNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MyStack{
    private StackNode top;

    MyStack(){
        top = null;
    }
    boolean isEmpty(){
        return top == null;
    }
    void push(int value) {
        StackNode newNode = new StackNode(value);
        newNode.next = top;
        top = newNode;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    int peek(){
        if(isEmpty()){
            return -1;
        }
        return top.data;
    }
}

class QueueStacks{
    private MyStack s1;
    private MyStack s2;

    QueueStacks(){
        s1 = new MyStack();
        s2 = new MyStack();
    }

    void enqueue(int value){
        s1.push(value);
        System.out.println(value + " enqueued");
    }
    void dequeue(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        System.out.println("Dequeued: " + s2.pop());
    }
    void front(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        System.out.println("Front Element: " + s2.peek());
    }
}
public class QueueUsingStack {
    public static void main(String[] args){

        QueueStacks queue = new QueueStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(40);


    }
}
