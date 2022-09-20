import java.util.HashSet;
import java.util.Scanner;

public class 携程 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n  = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//        int index = Con(nums);
//        int min = Integer.MAX_VALUE;
//        int old = nums[index-1];
//        int cha = nums[index]-nums[index-1];
//        for (int i = 1; i <= Math.abs(cha) ; i++) {
//            if(cha>=0){
//                nums[index-1] += 1;
//                int i1 = ConMax(nums);
//                min = i1<min?i1:min;
//            }else{
//                nums[index-1] -= 1;
//                int i1 = ConMax(nums);
//                min = i1<min?i1:min;
//            }
//        }
//        nums[index-1] = old;
//        for (int i = 1; i <= Math.abs(cha) ; i++) {
//            if(cha>=0){
//                nums[index] -= 1;
//                int i1 = ConMax(nums);
//                min = i1<min?i1:min;
//            }else{
//                nums[index] += 1;
//                int i1 = ConMax(nums);
//                min = i1<min?i1:min;
//            }
//        }
//        System.out.println(min);
//
//    }
//
//    public static int Con(int[] nums){
//        int max = 0;
//        int re = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int t = Math.abs(nums[i]-nums[i-1]);
//            if(max < t){
//                max = t;
//                re = i;
//            }
//        }
//        return re;
//    }
//    public static int ConMax(int[] nums){
//        int max = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int t = Math.abs(nums[i]-nums[i-1]);
//            if(max < t){
//                max = t;
//            }
//        }
//        return max;
//    }

    static int n;
    static int[] num1;
    static int[] num2;
    static String str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        sc.nextLine();
        str = sc.nextLine();
        num1 = new int[n-1];
        num2 = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            num1[i] = sc.nextInt();
            num2[i] = sc.nextInt();
        }
        // 遍历边
        int c=0;
        for (int i = 0; i < n-1; i++) {
            boolean pcheck = Check(i);
            if (pcheck) c++;
        }
        System.out.println(c);

    }
    public static boolean Check(int i){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int j = 0; j < n-1; j++) {
            if(j==i) continue;
            if (set1.isEmpty()&& set2.isEmpty()){
                set1.add(num1[j]);
                set1.add(num2[j]);
            }else {
                if (set1.contains(num1[j])||set1.contains(num2[j])){
                    set1.add(num1[j]);
                    set1.add(num2[j]);
                }else {
                    set2.add(num1[j]);
                    set2.add(num2[j]);
                }
            }
        }
        boolean r = false,g = false, b =false;
        for (Integer integer : set1) {
            if (str.charAt(integer-1)=='r') r = true;
            if (str.charAt(integer-1)=='g') g = true;
            if (str.charAt(integer-1)=='b') b = true;
        }
        boolean r2 = false,g2 = false, b2 =false;
        for (Integer integer : set2) {
            if (str.charAt(integer-1)=='r') r2 = true;
            if (str.charAt(integer-1)=='g') g2 = true;
            if (str.charAt(integer-1)=='b') b2 = true;
        }
        return r && g && b && r2 && g2 && b2;

    }
}
