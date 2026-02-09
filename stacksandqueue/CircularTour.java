package stacksandqueue;/*
    Goal of this class:
    This class determines the starting petrol pump index from which a
    vehicle can successfully complete a circular tour. A custom queue
    is used to simulate the journey by adding petrol pumps one by one
    and tracking the surplus petrol available after covering distances
    between pumps. The simulation continues until a valid starting
    point is identified or all possibilities are exhausted.
*/

public class CircularTour {

    static int[] queue = new int[50];
    static int front = 0;
    static int rear = -1;

    // Adds a pump index to the queue
    static void enqueue(int index) {
        queue[++rear] = index;
    }

    // Removes and returns a pump index from the queue
    static int dequeue() {
        return queue[front++];
    }

    // Checks whether the queue is empty
    static boolean isEmpty() {
        return front > rear;
    }

    // Determines the starting pump index using queue simulation
    static int findStart(int[] petrol, int[] distance) {
        int surplus = 0;
        int i = 0;

        while (i < petrol.length) {
            enqueue(i);
            surplus += petrol[i] - distance[i];

            while (surplus < 0 && !isEmpty()) {
                int removed = dequeue();
                surplus -= petrol[removed] - distance[removed];
            }

            i++;
        }

        return (surplus >= 0 && !isEmpty()) ? queue[front] : -1;
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStart(petrol, distance);

        System.out.println(startIndex);
    }
}
