import java.util.HashMap;

public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < s1.length(); ++i){
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == need.get(c)){
                    valid++;
                }
            }

            while(right - left >= s1.length()){
                if(valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d) == need.get(d)){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0 ) - 1);
                }
            }
        }
        return false;


    }
}

