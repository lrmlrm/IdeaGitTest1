import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stream流练习 {
    public static void main(String[] args) {
        String context = readTxt("/home/li/IdeaProjects/TestProject/src/test.txt");
        System.out.println(context);
        System.out.println("----------------开始计算-----------------");
//        String[] arr = context.trim().split(" ");
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(context);
        ArrayList<String> alist = new ArrayList<>();
        while (matcher.find()){
            alist.add(context.substring(matcher.start(),matcher.end()));
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < alist.size(); i++) {
            map.put(alist.get(i),map.getOrDefault(alist.get(i),0)+1);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()- o1.getValue();
            }
        });
        int count = 0;
        for (Map.Entry<String,Integer> m : list) {
            System.out.println(m.getKey()+":"+m.getValue());
            count++;
            if (count==10) break;
        }
    }


    public static String readTxt(String path){
        File file = new File(path);
        // 读取文本
        StringBuilder context = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s= br.readLine())!=null){
                context.append(System.lineSeparator()+s);
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return context.toString();
    }
}