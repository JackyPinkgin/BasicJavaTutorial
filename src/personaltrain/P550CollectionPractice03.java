package personaltrain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2021/10/29
 */
@SuppressWarnings("all")
public class P550CollectionPractice03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("Jack",650);
        hashMap.put("Tom",1200);
        hashMap.put("Smith",2900);

        out(hashMap);
        hashMap.put("Jack",2600);
        out(hashMap);
        Set set = hashMap.keySet();
        for (Object o :set) {
//            int i = (int)hashMap.get(o)+100;
            hashMap.put(o,((int)hashMap.get(o))+100);
        }
        out(hashMap);



    }
    public static void out(HashMap hashMap){
        Set set = hashMap.entrySet();
        for (Object o :set) {
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("====输出完成====");
    }
}
