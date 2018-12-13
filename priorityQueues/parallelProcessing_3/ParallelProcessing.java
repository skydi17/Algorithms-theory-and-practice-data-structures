package priorityQueues.parallelProcessing_3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ParallelProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] res = new String[m];
        long[] t = new long[m];
        for (int i = 0; i < m; i++) {
            t[i] = scanner.nextInt();
        }

        //Comparator<Integer> comparator = new Processor();
        PriorityQueue<Processor> queue =
                new PriorityQueue<Processor>(n,(a,b) -> (int) (a.getTime() - b.getTime()));
        //PriorityQueue<Processor> queue = new PriorityQueue<Processor>(n, comparator);

        for (int i = 0; i < m; i++) {
            long timeLeft = 0;
            if (!queue.isEmpty()) {
                timeLeft = Math.max(t[i], queue.peek().getTime());
            } else {
                timeLeft = t[i];
            }
            while (!queue.isEmpty() && queue.peek().getTime() < timeLeft) {
                res[queue.peek().getI()] = queue.peek().getProcNumber() + " " + queue.peek().getTime();
                queue.poll();
            }
            if (!(queue.size() == n)) {
                Processor processor = new Processor(t[i] + timeLeft, queue.size(), i);
                queue.add(processor);
            }
        }
        /*while (!queue.isEmpty()) {

        } */
        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }
    }
}
