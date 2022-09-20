import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 小红书 {

    static boolean[] bianIf;
    static int m;
    static int[][] Bian;
    static int n;
    static int[] value;
    static ArrayList<Integer> path = new ArrayList<>();
    static ArrayList<Integer> re = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        Bian = new int[m][2];
        value = new int[m];
        bianIf = new boolean[m];
        for (int i = 0; i < m; i++) Bian[i][0] = sc.nextInt();
        for (int i = 0; i < m; i++) Bian[i][1] = sc.nextInt();
        for (int i = 0; i < m; i++) value[i] = sc.nextInt();
        dfs(k,1);

        int min = Integer.MAX_VALUE;
        for (int i : re) {
            min = i<min?i:min;
        }
        System.out.println(min);

    }
    public static void dfs(int left, int index){
        if (index==n && left>=0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < path.size(); i++) {
                max = value[path.get(i)]>max?value[path.get(i)]:max;
            }
            re.add(max);
            return;
        }
        if (left==0) return;

        for (int i = 0; i < m; i++) {
            if (bianIf[i]==false && Bian[i][0]==index){
                path.add(i);
                bianIf[i] = true;
                dfs(left-1,Bian[i][1]);
                path.remove(path.size()-1);
                bianIf[i] = false;
            }
        }
    }
    /**
     5 6 3
     1 1 2 3 3 4
     2 5 3 4 5 5
     1 3 1 2 1 1
     **/
}
