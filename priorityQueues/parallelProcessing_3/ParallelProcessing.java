import java.util.PriorityQueue;
import java.util.Scanner;

public class ParallelProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] t = new long[m];
        for (int i = 0; i < m; i++) {
            t[i] = scanner.nextLong();
        }

        PriorityQueue<Processor> queue =
                new PriorityQueue<>(n,(a,b) -> (int) (a.getTime() - b.getTime() != 0 ?
                        a.getTime() - b.getTime() : a.getProcNumber() - b.getProcNumber()));

        StringBuilder res = new StringBuilder();

        int ind = 0;
        while (queue.size() < n && ind != m) {
            res.append(queue.size()).append(" ").append(0).append("\n");
            if (t[ind] != 0) {
                Processor processor = new Processor(t[ind], queue.size());
                queue.add(processor);
            }
            ind++;
        }

        for (int i = ind; i < m; i++) {
            res.append(queue.peek().getProcNumber()).append(" ").append(queue.peek().getTime()).append("\n");
            if (t[i] != 0) {
                Processor processor = new Processor(queue.peek().getTime() + t[i], queue.peek().getProcNumber());
                queue.poll();
                queue.add(processor);
            }
        }
        System.out.println(res);
    }
}
