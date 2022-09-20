import java.util.ArrayList;

public class 最上角右下角最短路径 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1,3},{4,1,5},{6,1,1}};
        recursion(nums,0,0);
        System.out.println(min+nums[0][0]);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void recursion(int[][] nums,int x,int y){
        if (x==nums.length-1 && y==nums[0].length-1){
            int sum = 0;
            for (int n:list){
                sum+=n;
            }
            min = min<sum?min:sum;
        }
        if (x<nums.length-1){
            list.add(nums[x+1][y]);
            recursion(nums,x+1,y);
            list.remove(list.size()-1);
        }
        if (y<nums[0].length-1) {
            list.add(nums[x][y+1]);
            recursion(nums, x, y + 1);
            list.remove(list.size()-1);
        }
    }
}
