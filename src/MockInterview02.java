public class MockInterview02 {
    public boolean searchMatrix(int[][] matrix, int target){
        boolean flag = false;
        for(int i = 0; i < matrix.length; ++i){
            flag = flag || searchHelper(matrix[i], 0 , matrix[i].length -1, target);
            if (flag == true){
                return flag;
            }
        }
        return flag;
    }
    /*zhi neng cha zhao dui jian xian de yuan su ,bu neng cha zhao zheng ge jv zhen de yuan su . suan fa you wen ti */
//    public boolean searchHelper(int[][] matrix, int leftM, int rightM, int leftN,int rightN,int target){
//        int midM = (leftM + rightM) / 2;
//        int midN = (leftN + rightN) / 2;
//        if(leftM == rightM || leftN == rightN){
//            return false;
//        }
//
//        if(matrix[midM][midN] == target){
//            return true;
//        }else if (matrix[midM][midN] > target){
//            return searchHelper(matrix, leftM, midM-1, leftN, midN-1, target);
//        }else{
//            return searchHelper(matrix,midM+1,rightM,midN+1,rightN,target);
//        }
//    }

    public boolean searchHelper (int[] temp, int left, int right, int target){

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(temp[left] > target){
                break;
            }
            if(temp[right] < target){
                break;
            }

            if(temp[mid] < target){
                left = mid + 1;
            }else if(temp[mid] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   4,  7, 11, 15},
                                     {2,   5,  8, 12, 19},
                                     {3,   6,  9, 16, 22},
                                     {10, 13, 14, 17, 24},
                                     {18, 21, 23, 26, 30},
                                    };
        //int[][] matrix = new int[][]{{1,1}};
        int target = 3;
        MockInterview02 text = new MockInterview02();
        boolean flag = text.searchMatrix(matrix,target);
        System.out.println(text.searchMatrix(matrix,target));
    }
}
