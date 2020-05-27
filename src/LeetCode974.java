import java.util.HashMap;
import java.util.Map;

public class LeetCode974 {

    /*
    * 菜鸡只想到了暴力解法，不出意外的超时；
    * */
//    public int subarraysDivByK(int[] A, int K) {
//        int ans = 0;
//        int n = A.length;
//
//
//        for(int i = 0; i < n; ++i){
//            int sum = 0;
//            for(int j = i ; j < n; ++j){
//                sum += A[j];
//                if(sum % K == 0){
//                    ans++;
//                }
//            }
//        }
//
//
//        return ans;
//    }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
//            int same = record.getOrDefault(modulus, 0);
//            ans += same;
//            record.put(modulus, same + 1);
            if(record.containsKey(modulus)){
                ans += record.get(modulus);
            }
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode974 text = new LeetCode974();
        int[] A = new int[]{4,5,0,-2,-3,1};
        int ans = text.subarraysDivByK(A, 5);
        System.out.println(ans);
    }
}
