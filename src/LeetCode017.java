import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode017 {
    Map<String, String> phone = new HashMap<>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    List<String> output = new ArrayList<String>();

    public void backtrack (String combination, String nextDigits){
        if(nextDigits.length() == 0){
            output.add(combination);
        }else{
            String digit = nextDigits.substring(0,1);//取当前串的首位数字
            String letters = phone.get(digit);//拿到对应的字母集(比如2对应:abc)
            for(int i = 0; i < letters.length(); ++i){//遍历当前字母集
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));//构建combination
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            backtrack("",digits);
        }
        return output;

    }
}
