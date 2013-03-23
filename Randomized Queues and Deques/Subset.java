import java.lang.*;

public class Subset {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        //Deque<String> queue = new Deque<String>();
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            //queue.addLast(StdIn.readString());
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.iterator().next());
        }
    }

}