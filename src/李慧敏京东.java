import java.util.*;

public class 李慧敏京东 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        int ou = 0;
//        int ji = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//            if (nums[i]%2==0) ou++;
//            else ji++;
//        }
//        // 偶数部分
//        int ouRe = 0;
//        for (int i = 2; i <= ou; i++) {
//            ouRe += c(ou,i);
//        }
//        // 奇数
//        int jiRe= 0;
//        if (ji>=2){
//            jiRe = c(ji,2);
//        }
//        System.out.println((ouRe+jiRe)%1000000007);
//
//    }
//    public static int c(int n,int m){
//        int fenzi = 1;
//        for (int i = n; i >= n-m+1; i--) {
//            fenzi*=i;
//        }
//        int fenmu = 1;
//        for (int i = m; i >= 1; i--) {
//            fenmu*=i;
//        }
//        return fenzi/fenmu;
//    }

    /**
     5 8
     1 1 1 3 3 3 5 5
     2 5 4 2 5 4 2 4
     1 8 7 3 4 5 2 6
     * **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //节点
        int m = sc.nextInt(); //道路
        int[][] bian = new int[3][m];
        for (int i = 0; i < m; i++) bian[0][i] = sc.nextInt();
        for (int i = 0; i < m; i++) bian[1][i] = sc.nextInt();
        for (int i = 0; i < m; i++) bian[2][i] = sc.nextInt();
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int num1 = bian[0][i];
            int num2 = bian[1][i];
            int num3 = bian[2][i];
            int[] s = new int[]{num1,num2,num3};
            list.add(s);
        }
        HashSet<Integer> set = new HashSet<>();
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        set.add(list.get(0)[0]);
        set.add(list.get(0)[1]);
        int re = list.get(0)[2];
        list.remove(0);
        while (set.size()!=n){
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2];
                }
            });
            for (int i = 0; i < list.size(); i++) {
                if ((set.contains(list.get(i)[0]) && !set.contains(list.get(i)[1])) || (!set.contains(list.get(i)[0]) && set.contains(list.get(i)[1]))){
                    set.add(list.get(i)[0]);
                    set.add(list.get(i)[1]);
                    re+=list.get(i)[2];
                    list.remove(i);
                    break;
                }
            }
        }
        System.out.println(re);
    }
}
