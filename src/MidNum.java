import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidNum {
    int cnt = 0;
    public int[] findMidNum(int[] nums){
        int len = nums.length;
        int[] ans = new  int[len];
        int[] rightMin = new int[len];
        int[] leftMax = new  int[len];

        rightMin[len - 1] = nums[len - 1];
        for(int i = len - 2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }


        leftMax[0] = nums[0];
        for(int i = 1; i < len; ++i){
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }


        for(int i = 0; i < len; i++){
            if(leftMax[i] == rightMin[i]){
                ans[cnt++] = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] input = s.split(",");

        int[] nums = new int[input.length];

        for(int i = 0; i < nums.length; ++i){
            int temp = 0;
            for(int j = 0; j < input[i].length(); j++){
                temp = temp * 10;
                temp += input[i].charAt(j) - '0';
            }
            nums[i] = temp;
        }

        MidNum mn = new MidNum();

        int[] ans = mn.findMidNum(nums);
        int cnt = mn.cnt;

        if(cnt == 0){
            System.out.println("None");
        }else {
            for (int i = 0; i < cnt - 1; ++i) {
                System.out.print(ans[i] + ",");
            }
            System.out.println(ans[cnt - 1]);
        }

    }
}
