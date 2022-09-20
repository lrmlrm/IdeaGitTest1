import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 滴滴 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[] nums = new int[m];
//        for (int i = 0; i < m; i++) {
//            nums[i] = sc.nextInt();
//        }
//        Arrays.sort(nums);
//        ArrayList<Integer> list = new ArrayList<>();
//        long sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            list.add(nums[i]);
//            sum+=nums[i];
//            if (nums[i]*list.size() > sum*n){
//                list.remove(list.size()-1);
//                break;
//            }
//        }
//        System.out.println(list.size());
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr = new int[n][4];
//        for (int i = 0; i < n; i++) {
//            arr[i][0] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i][1] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i][2] = sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            int start = arr[i][0];
//            int end = arr[i][1];
//            int target = arr[i][2];
//            int jieguo = 0;
//            for (int j = start;j <= end;j++){
//                String s = String.valueOf(j);
//                int res = s.charAt(0) - '0';
//                for (int m = 1; m < s.length(); m++) {
//                    res ^= (s.charAt(m) - '0');
//                }
//                if(res == target) jieguo++;
//
//            }
//            arr[i][3] = jieguo;
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i][3] + " ");
//        }
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[] weight = new int[m];
//        long sum = 0;
//        for (int i = 0; i < m; i++) {
//            weight[i] = sc.nextInt();
//            sum+=weight[i];
//        }
//        Arrays.sort(weight);
//        int re = n;
//        for (int i = n-1; i >= 0; i--) {
//            double avg = (double) sum/re;
//            if (weight[i]<=avg*n) break;
//            re--;
//            sum-=weight[i];
//
//        }
//        System.out.println(re);
//
//    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(),k = sc.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            Arrays.sort(arr);
            int max = n;
            for (int i = n -1;i>=0;i--){
                double a = (double)sum/max;
                if(arr[i] <= a *k ){
                    break;
                }
                max--;
                sum-=arr[i];
            }

            System.out.println(max);

        }


}
