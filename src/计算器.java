import java.util.Stack;

public class 计算器 {

    public static void main(String[] args) {
        String Str = "(1+(4+5+2)-3)+(6+8)";
        char[] chars = Str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c: chars){
            if (c!=')') stack.push(c);
            else{
                int re = outKuo(stack);
                char[] chars1 = new Integer(re).toString().toCharArray();
                for (char cs: chars1) stack.push(cs);
            }
        }
        String s = stack.toString();
//        System.out.println(re);
    }

    public static int outKuo(Stack<Character> stack){
        int re = 0;
        int num = 0;
        int b = 0;
        while (true){
            char c = stack.pop();
            if (c=='(') {
                re+=num;
                break;
            } else if (c=='+') {
                re+=num;
                num = 0;
                b=0;
            } else if (c=='-') {
                re-=num;
                num = 0;
                b=0;
            } else {
                num += (c-'0')*Math.pow(10,b++);
            }
        }
        return re;
    }

}
