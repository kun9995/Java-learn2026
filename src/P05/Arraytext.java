package P05;

public class Arraytext {
    public static void main(String[] args) {
        // 创建一个长度54的数组存放成绩
        int[] s= new int[54];
        System.out.println(s[0]);
        //创建一个数组，存放性别男女
        char [] gender={'男','女'};
        System.out.println(gender[0]);
        //创建一个数组，存放星期一到星期日
        String[] week={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        System.out.println(week[1]);
        //创建一个boolean的数组，初始值都是ture,长度三
        boolean[] is={true,true,true};
        System.out.println(is[2]);
        System.out.println(is[3]); // This will throw an ArrayIndexOutOfBoundsException
    }
}
