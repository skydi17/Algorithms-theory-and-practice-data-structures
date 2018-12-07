package basicDataStructures.NetworkPacketProcessing_3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class NetworkPacketProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arrival = new int[n];
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = scanner.nextInt();
            duration[i] = scanner.nextInt();
        }

        Queue buffer = new PriorityQueue<>(size);
        for (int i = 0; i < n; i++) {
            if (buffer.isEmpty()) {
                buffer.add(arrival[i] + duration[i]);
                System.out.println(arrival[i]);
                continue;
            }
            if ((int) buffer.peek() < arrival[i] || buffer.size() == size) {
                System.out.println("-1");
            } else {
                buffer.add((int)buffer.peek() + duration[i]);
                System.out.println((int)buffer.poll());
            }
            if (buffer.size() < size) {
                buffer.add(arrival[i] + duration[i]);
            }
        }
    }
}
