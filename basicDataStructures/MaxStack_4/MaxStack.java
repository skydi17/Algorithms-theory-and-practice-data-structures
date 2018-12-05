package basicDataStructures.maxStack_4;

import java.util.Scanner;
import java.util.Stack;

public class MaxStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        Stack stack = new Stack();
        Stack maxStack = new Stack();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < q; i++) {
            String command = scanner.next();
            if (command.startsWith("push")) {
                int v = Integer.valueOf(scanner.next());
                stack.push(v);
                if (maxStack.isEmpty() || (int) maxStack.peek() < v) {
                    maxStack.push(v);
                } else {
                    maxStack.push(maxStack.peek());
                }
            } else if (command.equals("pop")) {
                stack.pop();
                maxStack.pop();
            } else {
                builder.append(maxStack.peek() + "\n");
            }
        }
        System.out.println(builder);
    }
}
