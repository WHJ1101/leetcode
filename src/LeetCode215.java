import java.util.Random;

public class LeetCode215 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        //将确定元素的索引和目标索引比较
        //相等返回
        //目标索引大，递归右半边
        //目标索引小，递归左半边
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        //随机选一个数i，将nums[i]与末尾元素交换（以交换后的末尾数为基准数）
        //实现了随机性
        swap(a, i, r);
//        swap(a, i, l);

        return partition(a, l, r);
    }
    /*
    以末尾元素为基准数，将所有小于它的置换到左侧（从索引0开始依次插入）
    然后把末尾元素与最后一个比它小的元素的后一位交换位置
    （这就是该元素再排序队列内的最终正确位置）
    返回最终索引
     */
    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;

//        int temp = a[l], i = l, j = r;
//        while(j > i){
//            while(a[j] <= temp){
//                j--;
//            }
//            while(a[i] >= temp){
//                i++;
//            }
//
//            if(i < j){
//                swap(a, i, j);
//            }
//            swap(a, l, i);
//        }
//        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode215 lt = new LeetCode215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int ans = lt.findKthLargest(nums, k);
        System.out.println(ans);
    }
}
