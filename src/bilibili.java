import java.util.*;

public class bilibili {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] Str = s.split(" ");
//        int re = fun(Str[0], Str[1]);
//        System.out.println(re);
//
//    }
//    public static int fun(String word1, String word2){
//        int n = word1.length();
//        int m = word2.length();
//        if (n*m==0){
//            return n+m;
//        }
//        int[][] D = new int[n+1][m+1];
//        for (int i = 0; i < n+1; i++) {
//            D[i][0] = i;
//        }
//        for (int i = 0; i < m+1; i++) {
//            D[0][i] = i;
//        }
//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < m+1; j++) {
//                int left = D[i-1][j]+1;
//                int down = D[i][j-1]+1;
//                int leftdown = D[i-1][j-1];
//                if (word1.charAt(i-1)!=word2.charAt(j-1)){
//                    leftdown+=1;
//                }
//                D[i][j] = Math.min(left,Math.min(down,leftdown));
//            }
//        }
//        return D[n][m];
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        for (int i = 0; i < Str.length(); i++) {
            char c = Str.charAt(i);
            if (c=='{'||c=='['||c=='('){
                stack.add(c);
            }else {
                Character peek = stack.peek();
                if (c=='}'&&peek=='{'||c==']'&&peek=='['||c==')'||peek=='('){
                    stack.pop();
                }else {
                    System.out.println(map.get(peek)+","+(i+1));
                }
            }
        }
    }
}
