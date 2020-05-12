public class LeetCode050 {
    public double myPow(double x, int n){
        long N = n;
        /*N的范围是整个整数int 的范围，所以当n位-2的31次方时，在进行n = - n的操作时会出现整数溢出，所以要将n转换成long的类型；
        *响应的，也要写一个 helper函数来支持正确的参数调用。
        *  */
        return powHelper(x, N);

    }

    public double powHelper(double x, long N){
        double ans;
        if(N == 0){
            return 1.0;
        }
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        /*
        * 下面这段注释掉的代码的问题在于 ans = p (x, n/2 ) * p(x, n/2)；这一条语句就执行了两次递归调用，在时间上和空间上都double了。
        * 相应的在LeetCode中也超时了；
        * 改为 用一个变量把递归结果保存之后，在对这个变量进行操作就省时省力了。
        * */
//        if(N % 2 == 0){
//            ans = powHelper(x, (N / 2)) * powHelper(x, (N / 2));
//        }else{
//            ans = x * powHelper(x, (N / 2)) * powHelper(x, (N / 2));
//        }
        double y = powHelper(x, N / 2);
        if(N % 2 == 0){
            ans = y * y;
        }else{
            ans = x * y * y;
        }


        return ans;
    }

    public static void main(String[] args) {
        LeetCode050 text = new LeetCode050();
        double x = 2;
        int n = 3;
        double ans = text.myPow(x, n);
        System.out.println(ans);
    }
}
