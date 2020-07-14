import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_InterView16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[0];
        }
        if(shorter == longer){
            return new int[]{shorter * k};
        }

        int[] ans = new int[k + 1];

        for(int i = 0; i <= k; ++i){
            ans[i] = shorter * (k - i) + longer * i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shorter = sc.nextInt();
        int longer = sc.nextInt();
        int k = sc.nextInt();

        LeetCode_InterView16_11 lt = new LeetCode_InterView16_11();
        int[] ans = lt.divingBoard(shorter, longer, k);
        System.out.println(Arrays.toString(ans));
    }


}
