package p06;

public class ex {
    public static void main(String[] args) {
        sign(-15);
        sign(12);
    }
    public static void sign(int n) {
        System.out.println(n>0?n+"正数":n+"负数");
    }
}
