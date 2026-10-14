package p02;

public class T {
    public static void main(String[] args) {
        int chinese = 85;   // 语文
        int math = 92;      // 数学
        int a=math>chinese?1:0;//三目运算符
        System.out.println(a);
        boolean is=math>90?true:false;//三目运算符
        System.out.println(is);
        String a2=chinese>90?"优秀":"不是优秀";//三目运算符
        System.out.println(a2);
    }
}
