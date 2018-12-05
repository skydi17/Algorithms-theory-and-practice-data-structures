package basicDataStructures.bracketSequence_1;

import java.util.Stack;
import java.util.Scanner;

class BracketSequence {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack indexes = new Stack();
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.nextLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
                stack.push(arr[i]);
                indexes.push(i + 1);
            } else if (arr[i] == ']' || arr[i] == ')' || arr[i] == '}') {
                if (stack.isEmpty()) {
                    System.out.println(String.valueOf(i + 1));
                    return;
                }
                String top = stack.peek().toString();
                if (top.equals("[") && arr[i] != ']' ||
                        top.equals("(") && arr[i] != ')' ||
                        top.equals("{") && arr[i] != '}') {
                    System.out.println(String.valueOf(i + 1));
                    return;
                } else {
                    stack.pop();
                    indexes.pop();
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Success" : String.valueOf(indexes.firstElement()));
    }
}