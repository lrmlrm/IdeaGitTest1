import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 百度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int f = 0;
        int fmax = 0;
        boolean isfirst = false;
//        System.out.println(s);
        while(sc.hasNextLine()){
            String s = sc.nextLine();

            System.out.println(s);
            for (int i = 0; i < s.length(); i++) {
//                list.add(s.charAt(i));
                char c = s.charAt(i);
                if (c=='f' && (i+2<=s.length())){
                    if (s.charAt(i)=='f' && s.charAt(i)=='o' && s.charAt(i)=='r') {
                        stack.push('f');
                        f++;
                        fmax = f>fmax?f:fmax;
                    }
                }
                if (c=='{') {
                    isfirst = true;
                    stack.push(c);
                }
                if (c=='}') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek()=='f'){
                        stack.pop();
                        f--;
                    }
                }
                max = max>stack.size()?max:stack.size();
            }

            if (stack.isEmpty() && isfirst) {
                System.out.println(fmax);
                return;
            }
        }
    }
}
