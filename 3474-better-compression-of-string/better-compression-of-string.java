import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String betterCompression(String compressed) {
        TreeMap<Character, Integer> hm = new TreeMap<>();
        int n = compressed.length();
        
        for (int i = 0; i < n; ) {
            char ch = compressed.charAt(i++);
            int count = 0;
            while (i < n && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i++) - '0');
            }
            
            hm.put(ch, hm.getOrDefault(ch, 0) + count);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        
        return sb.toString();
    }
}
