import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 裁缝 {
        private static Set<String> set = new HashSet<>();
        private static List<String> list = new ArrayList<>();
        private static boolean[] vis;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] nm = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            String str = sc.nextLine();
            int[] ms = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();//每个子串的长度
            String[] substr = new String[nm[1]];
            for (int i = 0; i < nm[1]; i++) substr[i] = sc.nextLine();  // 子串
            vis = new boolean[nm[1]]; // 每一个子字符串，创建一个boolean判断
            dfs(str, ms, nm[1], substr, 0); // 深度优先遍历
            System.out.println(set.size());
        }

        private static void dfs(String str, int[] arr, int n, String[] substr, int level) {
            if (level == n) {
                set.add(list.toString());
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!vis[i] && str.startsWith(substr[i])) {
                    // 状态记录器，vis[i]记录子串是否匹配到，list记录整个路径
                    vis[i] = true;
                    list.add(0, substr[i]);
                    dfs(str.substring(arr[i]), arr, n, substr, level + 1);
                    // 状态回滚
                    list.remove(0);
                    vis[i] = false;
                }
            }
        }
//    static Set<String> set = new HashSet<String>();//记录成功匹配的
//    static List<String> list = new ArrayList<>();//记录路径
//    static String[] subStr;
//    static boolean[] subStrState;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String Str = sc.nextLine();
//        List<String> ArrLs = new ArrayList<>();
//        int n = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < n; i++) {
//            ArrLs.add(sc.nextLine());
//        }
//        subStr = ArrLs.toArray(new String[ArrLs.size()]);
//        subStrState = new boolean[subStr.length];
//        dfs(Str,0);
//        System.out.println(set.size());
//    }
//
//    /**收获：想要暴力递归同时记录当时的状态：
//    方法1:给每一个节点new一个状态，
//    方法2:只创建一个状态，但是这个状态只是记录当前，当递归函数调用结束，将状态还回去，确保状态的内容是当前的节点的，这样的好处在于不需要给每个节点都创建new一个状态出来，
//     **/
//    public static void dfs(String searchStr,int index){
//        if(index==subStr.length){
//            set.add(list.toString());
//        }
//        // 进行全排列遍历每个子串
//        for (int i = 0; i < subStr.length; i++) {
//            if(!subStrState[i]){
//                Matcher matcher = Pattern.compile(subStr[i]).matcher(searchStr);
//                while (matcher.find()){
//                    list.add(0,subStr[i]); // 路径记录
//                    subStrState[i] = true; // 更改此节点状态，说明找到了subStr[i]
//                    dfs(searchStr.substring(matcher.start()),index+1);
//                    subStrState[i] = false; // 还回去
//                    list.remove(0); // 路径撤销
//                }
//            }
//        }
//    }
}
