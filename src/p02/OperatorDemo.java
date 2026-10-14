package p02;

public class OperatorDemo {
    public static void main(String[] args) {
        // ===== 数据集：某学生三门课成绩 =====
        int chinese = 85;   // 语文
        int math = 92;      // 数学
        int english = 79;   // 英语

        // 后续步骤会用到的变量，先声明
        int total = 0;          // 总分
        double average = 0.0;   // 平均分
        int passCount = 0;      // 及格科目计数器

        //完成项目下面开始
        total = chinese + math + english;
        System.out.println("总分是：" + total);
        System.out.println("数学比语文高：" + (math - chinese) + "分");
        System.out.println("奖学金参考：" + (total * 1.1) + "分");
        average = total / 3.0;//整数参与除法运算，结果还是整数。
        System.out.println("平均分：" + (average) + "分");
        System.out.println("是否为偶数分：" + (average % 2 == 0));
        System.out.println("是否能被三整除：" + (average % 3 == 0));
        //2
        math += 5;
        System.out.println("数学加5分后：" + math);
        total = chinese + math + english;
        System.out.println("新总分:" + total);
        //3
        System.out.println("数学是否满分：" + (math == 100));
        System.out.println("数学是否不是满分：" + (math != 100));
        System.out.println("数学是否及格：" + (math >= 60));
        System.out.println("数学是否不及格：" + (math < 60));
        System.out.println("三科是否全部及格：" + (math >= 60 && chinese >= 60 && english >= 60));
        //4
        System.out.println("数学且英语是否及格：" + (math >= 60 && english >= 60));
        System.out.println("任意门满分：" + (math == 100 || english == 100 || chinese == 100));
        System.out.println("数学是否不满分" + !(math == 100));
        //5
        average = total / 3.0;
        String grade = average>=90 ? "A" :(average>=80?"B":"C");
        System.out.println("平均分等级：" + grade);
        double scholarship=280;
        scholarship=total*1.1;
        System.out.println("是否达到奖学金线:" + (scholarship >= 280));
    }
}
