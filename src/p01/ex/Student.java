package p01.ex;

import java.util.Scanner;

public class Student {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String name= scanner.next();
        int age= scanner.nextInt();
        double h=scanner.nextDouble();
        char gender=scanner.next().charAt(0);
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("身高："+h);
        System.out.println("性别："+gender);
    }
}
