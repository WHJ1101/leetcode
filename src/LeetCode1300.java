import java.util.Arrays;
import java.util.Scanner;

public class LeetCode1300 {
    public int findBestValue(int[] arr, int target){

        Arrays.sort(arr);
        int len = arr.length;
        int ans = arr[len - 1];
        int curSum = 0;
        for(int i = 0; i < len; ++i){
            int curAvg = (target - curSum) / (len - i);
            if(curAvg < arr[i]){
                double curAvg1 = (target*1.0 - curSum) / (len - i);
                if(curAvg1 - curAvg > 0.5){
                    ans = curAvg + 1;
                }else{
                    ans = curAvg;
                }
                break;
            }
            curSum += arr[i];
        }

        return ans;




    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("please enter an array and number with ,:");
        String str = sc.next().toString();
        String[] sArr = str.split(",");
        int [] arr = new int[sArr.length];
        for(int i = 0; i < arr.length; ++i){
            arr[i] = Integer.parseInt(sArr[i]);
        }
        System.out.println("your array is :" + Arrays.toString(arr));

        //int[] arr = new int[]{60864,25176,27249,21296,20204};
        Scanner sc1 = new Scanner(System.in);
        System.out.println("please enter a number:");
        int target = sc1.nextInt();
        LeetCode1300 lt = new LeetCode1300();
        int ans = lt.findBestValue(arr, target);
        System.out.println(ans);
    }
}
