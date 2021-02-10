import java.util.*;

public class Main {
    static Map implent = new HashMap();
    static List list = new ArrayList();
    static String temp;


    static class LRUCache {
        static int maxSize;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public static void insertKeyValuePair(String key, int value) {
            if(implent.size() < maxSize){
            implent.put(key,value);
            temp = key;
            sort(key);
            } else {
                implent.remove(list.get(0));
                implent.put(key,value);
                sort(key);
                temp =key;
                sort(key);
                list.remove(0);
            }
        }

        public static void sort (String key){
            if (list.contains(key)){
                list.remove(key);
            }
            list.add(key);
        }

        public static LRUResult getValueFromKey(String key) {
            // Write your code here.
            LRUResult result;
            if(implent.containsKey(key)) {
                result = new LRUResult(false, (Integer) implent.get(key));
                temp = key;
                sort(key);

            }else {
                result = new LRUResult(false, (Integer) implent.get(key));
            }
            return result;
        }

        public  static String getMostRecentKey() {
            return temp;
        }
    }

    static class LRUResult {
        boolean found;
        Integer value;

        public LRUResult(boolean found, Integer value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        new LRUCache(1);
        LRUCache.insertKeyValuePair("a", 1);
        LRUCache.insertKeyValuePair("b", 2);
        System.out.println(LRUCache.getValueFromKey("a"));
        LRUCache.insertKeyValuePair("c", 3);
        System.out.println(LRUCache.getValueFromKey("a"));
        System.out.println(LRUCache.getValueFromKey("a").value);
        System.out.println(LRUCache.getValueFromKey("b").value);
        System.out.println(LRUCache.getValueFromKey("b").value);
        System.out.println(LRUCache.getMostRecentKey());
        System.out.println(implent);
        System.out.println(list);

    }
}
