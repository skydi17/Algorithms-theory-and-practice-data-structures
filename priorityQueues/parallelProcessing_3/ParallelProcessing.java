import java.util.PriorityQueue;
import java.util.Scanner;

public class ParallelProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] t = new long[m];
        for (int i = 0; i < m; i++) {
            t[i] = scanner.nextInt();
        }

        PriorityQueue<Processor> queue =
                new PriorityQueue<>(n,(a,b) -> (int) (a.getTime() - b.getTime()));

        long time = 0;
        int i = 0;
        StringBuilder res = new StringBuilder();

        while (i < m) {
            boolean flag = true;
            //fill empty buffer
            if (queue.isEmpty()) {
                while ((queue.size() < n || flag) && i != m - 1) {
                    res.append(queue.size()).append(" ").append(time).append("\n");
                    if (t[i] > 0) {
                        flag = false;
                        Processor processor = new Processor(time + t[i], queue.size());
                        queue.add(processor);
                    }
                    i++;
                }
            }

            //getting current time
            if (!queue.isEmpty()) {
                time = queue.peek().getTime();
            }
            //check executed tasks and fill buffer on current time
            while (!queue.isEmpty() && queue.peek().getTime() == time && i < m) {
                res.append(queue.peek().getProcNumber()).append(" ").append(time).append("\n");
                if (t[i] > 0) {
                    Processor processor = new Processor(time + t[i], queue.peek().getProcNumber());
                    queue.add(processor);
                    queue.poll();
                }
                i++;
            }
        }
        System.out.println(res);
    }
}
