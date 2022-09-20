import java.util.*;

public class 烟花 {

//    private static final int Max = (int)1e9;
//    private int n;
//    private int p;
//    private int[] numbers;
//    private int[] DP;
//
//    public int minimumIncompatibility (int[] numbers, int k) {
//        n = numbers.length;
//        p = n/k;
//        DP = new int[(1<<n)*n];
//        Arrays.fill(DP,-1);
//        Arrays.sort(numbers);
//        this.numbers = numbers;
//        int res = function((1<<n)-1,0);
//        return res >= Max?-1:res;
//    }
//
//    private int function(int m,int pre){
//        if (m==0) return 0;
//        if (DP[m*n+pre]!=-1) return DP[(m*n+pre)];
//        int cnt = Integer.bitCount(m);
//        int r = cnt%p;
//        int res = Max;
//        if (r==0){
//            res = function(m^Integer.lowestOneBit(m),Integer.numberOfTrailingZeros(m));
//            for (int i = 0; i < n; i++) {
//                DP[m*n+i] = res;
//
//            }
//        }else {
//            if (Integer.bitCount(m>>(pre+1))>=r){
//                for (int i = pre+1; i < n; i++) {
//                    if ((m&(1<<i))!=0&&numbers[i]>numbers[pre]){
//                        res = Math.min(res,function(m^(1<<i),i)+numbers[i]-numbers[pre]);
//                    }
//                }
//            }
//            DP[m*n+pre] = res;
//        }
//        return res;
//    }
//    public int change (int[] oils, int box) {
//        int[] DP = new int[box+1];
//        int Max = Integer.MAX_VALUE;
//        for (int i = 1; i < DP.length; i++) {
//            DP[i] = Max;
//        }
//        for (int i = 0; i < oils.length; i++) {
//            for (int j = oils[i]; j <= box; j++) {
//                if (DP[j-oils[i]]!=Max){
//                    DP[j] = Math.min(DP[j],DP[j-oils[i]]+1);
//                }
//            }
//        }
//        return DP[box]==Max?-1:DP[box];
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[][] nums = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            nums[i][0] = sc.nextInt()-1;
//            nums[i][1] = sc.nextInt()-1;
//            nums[i][2] = sc.nextInt();
//        }
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] wuguize = new int[m];
//        for (int i = 1; i < n; i++) {
//            if(nums[i][0]<=nums[i-1][1]){
//                for (int j = nums[i][0]; j <= nums[i-1][1]; j++) {
//                    map.put(j,0);
//                }
//            }
//        }
//        int add = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = nums[i][0]; j <= nums[i][1]; j++) {
//                wuguize[j] = 1;
//            }
//        }
//        for (int i = 0; i < wuguize.length; i++) {
//            if (wuguize[i] == 0) add++;
//        }
//
//        int[] re = new int[m];
//        for (int i = 0; i < n; i++) {
//            for (int j = nums[i][0]; j <= nums[i][1]; j++) {
//                if(nums[i][2]>=1&&!map.containsKey(j)){
//                    re[j] = 1;
//                    nums[i][2]--;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = nums[i][0]; j <= nums[i][1]; j++) {
//                if(nums[i][2]>=1&&map.containsKey(j)&&map.get(j)==0){
//                    map.put(j,1);
//                    nums[i][2]--;
//                    re[j] = 1;
//                }
//            }
//        }
//        int renum = 0;
//        for (int i = 0; i < re.length; i++) {
//            if (re[i]==1)renum++;
//        }
//        System.out.println(renum+add);
//
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[] num1 = new int[n],num2 = new int[n];
//        for (int i = 0; i < n; i++) num1[i] = sc.nextInt();
//        for (int i = 0; i < n; i++) num2[i] = sc.nextInt();
//        int count = 0, i = 0, j = 0;
//        Set<Integer> Set = new HashSet<>();
//        while (i<n&&j<n){
//            if (Set.contains(num1[i])){
//                i++;
//                continue;
//            }
//            if (num2[j]!=num1[i]){
//                Set.add(num2[j]);
//                count++;
//                j++;
//            }else {
//                j++;i++;
//            }
//        }
//        System.out.println(count);
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        sc.nextLine();
//        int[][] nums = new int[m][3];
//        for (int i = 0; i < m; i++) {
//            nums[i][0] = sc.nextInt()-1;
//            nums[i][1] = sc.nextInt()-1;
//            nums[i][2] = sc.nextInt();
//        }
//        int[] res = new int[n+1];
//        Arrays.fill(res,1);
//        for (int[] num: nums) {
//            int max = num[1]-num[0]+1-num[2];
//            int count = 0;
//            for (int i = num[0]; i <= num[1]; i++) {
//                if (res[i]==0){
//                    count++;
//                }
//            }
//            if (count>=max){
//                continue;
//            }
//            max = max-count;
//            for (int i = num[1]; i >= num[0] ; i--) {
//                if (max==0) break;
//                if (res[i]==0) continue;
//                res[i] = 0;
//                max--;
//            }
//        }
//        int count = 0;
//        for (int i :res) {
//            count+=i;
//        }
//        System.out.println(count-1);
//    }
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,4,2},{3,6,2},{8,9,2},{4,5,3}};
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(nums);
    }

}
