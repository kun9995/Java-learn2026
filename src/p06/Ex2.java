package p06;

public class Ex2 {
    public static void main(String[] args) {
        int s = getSum(10);
        System.out.println(10+"以内的整数和为"+s);
        s=getSum(13);
        System.out.println(13+"以内的整数和为"+s);
    }
    public static int getSum(int n) {
        return n*(n+1)/2;
    }
}
