import java.util.Stack;

public class BracketSequence {

    private static String checkBrackets(String str) {
        int savedIndex = 0;
        Stack stack = new Stack();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
                stack.push(arr[i]);
                savedIndex = i + 1;
            } else {
                if (arr[i] != ']' && arr[i] != ')' && arr[i] != '}')
                    continue;
                if (stack.isEmpty()) return String.valueOf(i + 1);
                String top = stack.pop().toString();
                if (top.equals("[") && arr[i] != ']' ||
                        top.equals("(") && arr[i] != ')' ||
                        top.equals("{") && arr[i] != '}') {
                    return String.valueOf(i + 1);
                }
            }
        }
        return (stack.isEmpty()) ? "Success" : String.valueOf(savedIndex);
    }

    public static void main(String[] args) {
        System.out.println(checkBrackets("[]"));
        System.out.println(checkBrackets("{}[]"));
        System.out.println(checkBrackets("[()]"));
        System.out.println(checkBrackets("(())"));
        System.out.println(checkBrackets("{[]}()"));
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("{[}"));
        System.out.println(checkBrackets("foo(bar);"));
        System.out.println(checkBrackets("foo(bar[i)"));
    }
}