import java.util.*;

public class LeetCode137SongleNumber2 {
    public int singleNumber(int[] nums) {
//        int ans =0;
//        int sum = 0;
//        int tresum = 0;
//        Set<Integer> set = new HashSet<>();
//        for(Integer i : nums){
//            set.add(i);
//            sum += i;
//        }
//        for(Integer i : set){
//            tresum += 3 * i;
//        }
//        ans = (tresum - sum) / 2;
//
//        return ans;
        /*
        * 上面的解法有一个BUG：当nums中的元素是2^31-1 时  sum 和 tresum都会溢出；
        * */
        int ans =0;
        Hashtable<Integer,Integer> table = new Hashtable<>();
        for(Integer i : nums){
            Integer count = table.get(i);
            if(count == null){
                table.put(i,1);
            }else{
                count++;
                table.put(i,count);
            }


        }
//        Enumeration e = table.keys();
//        while(e.hasMoreElements()){
//            Object temp = e.nextElement();
//            if(table.get(temp) == 1){
//                ans = (int)temp;
//                break;
//            }
//        }
        /*
        * 上面的Enumeration接口被IDEA标注为较老的API，建议用Iterator；
        * */
        Integer key = null;
        Integer val = null;
        Iterator iterator = table.keySet().iterator();
        while(iterator.hasNext()){
            key = (Integer) iterator.next();
            val = table.get(key);
            if(val == 1){
                ans = key;
                break;
            }
        }

        /*
        * 也可以用foreach循环来做，但是需要针对table.keySet(),
        * 也就是键集做循环操作；
        * */
        for(int k : table.keySet()){
            if(table.get(k) == 1){
                ans = k;
                break;
            }
        }


        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{43,16,45,89,45,-2147483648,45,2147483646,
                -2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,
                89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,
                16,16,2147483646,43};
        LeetCode137SongleNumber2 text = new LeetCode137SongleNumber2();
        int res = text.singleNumber(nums);
        System.out.println(res);
    }
}
