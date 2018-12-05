package basicDataStructures.maxInWindow_5;

import java.util.Scanner;
import java.util.Stack;

public class MaxInWindow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack max = new Stack();
        int max1 = 0;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else if (m == n) {
            for (int i = 0; i < n; i++) {
                if (max1 < a[i]) {
                    max1 = a[i];
                }
            }
            System.out.print(max1 + " ");
        } else {
            for (int i = 0; i < m; i++) {
                stack1.push(a[i]);
                if (max1 < a[i]) {
                    max1 = a[i];
                }
            }
            System.out.print(max1 + " ");
            for (int i = m; i < n; i++) {
                stack1.push(a[i]);
                if (max1 < a[i]) {
                    max1 = a[i];
                }
                if (stack2.isEmpty()) {
                    max1 = 0;
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                        if (max.isEmpty() || (int) max.peek() < (int) stack2.peek()) {
                            max.push(stack2.peek());
                        } else {
                            max.push(max.peek());
                        }
                    }
                }

                stack2.pop();
                max.pop();

                System.out.print((max.isEmpty() || max1 > (int) max.peek()) ? max1 + " " : max.peek() + " ");
            }
        }
    }
}
