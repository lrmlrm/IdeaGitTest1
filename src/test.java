import java.util.*;
import java.util.stream.Collectors;


public class test {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{2,3},{2,4},{3,5},{3,6}};
//        PriorityQueue queue = new PriorityQueue<Map.Entry<Integer,Integer>>((o1, o2) -> o1.getValue() - o2.getValue());
//        PriorityQueue queue = new PriorityQueue<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer,Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
//                int i = o1.getValue() - o2.getValue();
//                return i;
//            }
//        });
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i][0])) map.put(nums[i][0],map.get(nums[i][0])+1);
            else map.put(nums[i][0],1);
            if(map.containsKey(nums[i][1])) map.put(nums[i][1],map.get(nums[i][1])+1);
            else map.put(nums[i][1],1);
        }

        // map.entySet()将map转化成List,然后转换成stream流，通过stream流的sorted方法排序
        List<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(((o1, o2) -> o1.getValue() - o2.getValue())).collect(Collectors.toList());
        System.out.println(sorted);


//        for (Map.Entry e: map.entrySet()){
//            queue.add(e);
//        }
//        while(!queue.isEmpty()){
//            Map.Entry poll = (Map.Entry) queue.poll();
//            System.out.println(poll.getKey()+":"+poll.getValue());
//        }
    }
}
