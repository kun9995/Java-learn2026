package P03;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        System.out.println("请输入需要查询的月份");
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        switch(m){
            case 1:
                System.out.println("31");break;
            case 2:
                System.out.println("28");break;
            case 3:
                System.out.println("31");break;
            case 4:
                System.out.println("30");break;
            case 5:
                System.out.println("31");break;
            case 6:
                System.out.println("30");break;
            case 7:
                System.out.println("31");break;
            case 8:
                System.out.println("31");break;
            case 9:
                System.out.println("30");break;
            case 10:
                System.out.println("31");break;
            case 11:
                System.out.println("30");break;
            case 12:
                System.out.println("31");break;
            default:
                System.out.println(m+"月份");
        }
    }
}
// switch (m){
// case 2: day=28; break;
//case 4:case 6: ...
//case 11 day=30;break;
// default:
//day=31;