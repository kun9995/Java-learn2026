package p02.eve;

import java.util.Scanner;

/**
 * Java 输入输出知识汇总 —— 课堂笔记 + 示例代码
 *
 * 一、输出（System.out）
 * 二、格式化输出（printf）
 * 三、输入（Scanner）
 * 四、常见问题与注意事项
 */
public class knowledeg {

    public static void main(String[] args) {

        // ============================================================
        // 一、输出方式总结（三种常用方法）
        // ============================================================

        System.out.println("===== 1. 输出 =====");

        // ---------- 1.1 print()：输出内容后【不换行】 ----------
        System.out.print("我是print，");
        System.out.print("输出完不会换行，下一次输出接在后面\n");
        // \n 是转义字符，表示手动换行

        // ---------- 1.2 println()：输出内容后【自动换行】 ----------
        System.out.println("我是println，");
        System.out.println("输出完自动换行");
        // println = print line，输出后自带一个换行符

        // ---------- 1.3 printf()：格式化输出（可控对齐、精度等） ----------
        // 语法：System.out.printf("格式说明符", 变量1, 变量2, ...);
        // 注意：printf 不会自动换行，需要手动加 \n

        int age = 20;
        double score = 92.345678;
        char grade = 'A';
        String name = "李坤洋";

        // 常用格式说明符：
        // %d   → 整数        %f   → 浮点数（默认6位小数）
        // %.nf → 保留n位小数  %s   → 字符串
        // %c   → 字符        %b   → 布尔值
        // %10d → 占10位宽度右对齐   %-10s → 占10位左对齐

        System.out.printf("姓名：%s，年龄：%d，成绩：%.2f，等级：%c%n", name, age, score, grade);
        // %n 是 printf 中的换行符（跨平台，比 \n 更安全）

        System.out.printf("浮点数默认精度：%f%n", score);     // 输出 92.345678（默认6位小数）
        System.out.printf("保留2位小数：%.2f%n", score);       // 输出 92.35（四舍五入）
        System.out.printf("保留4位小数：%.4f%n", score);       // 输出 92.3457
        System.out.printf("整数占10位宽度：|%10d|%n", age);     // 输出 |        20|（右对齐）
        System.out.printf("左对齐占10位：|%-10s|结尾%n", name); // 输出 |李坤洋        |结尾

        // ---------- 1.4 字符串拼接输出（用 + 号连接） ----------
        int x = 3, y = 5;
        System.out.println("x + y = " + (x + y));
        // ⚠️ 注意：拼接表达式中如果混合了 +运算 和 +拼接，需要用括号
        // "x+y=" + x + y  →  会输出 "x+y=35"（字符串拼接）
        // "x+y=" + (x + y) →  会输出 "x+y=8"（先算再拼）

        // 反例（编译错误，仅作演示，已注释）："x * y=" 是String，不能和int做乘法
        // System.out.println("x * y = " + x * y);
        System.out.println("x * y = " + (x * y)); // ✅ 正确写法，加括号

        // ---------- 1.5 转义字符一览 ----------
        System.out.println("===== 2. 转义字符 =====");
        System.out.println("换行符 \\n ：第一行\n第二行");
        System.out.println("制表符 \\t ：姓名\t学号\t班级");    // 类似Tab对齐
        System.out.println("反斜杠 \\\\ ：打印一个\\");
        System.out.println("双引号 \\\" ：他说\"你好\"");

        // ============================================================
        // 二、输入方式总结（Scanner 类）
        // ============================================================

        System.out.println("===== 3. Scanner 输入 =====");

        // ---------- 3.1 创建Scanner对象（固定写法） ----------
        Scanner scanner = new Scanner(System.in);
        // System.in 表示标准输入（键盘），固定写法

        // ---------- 3.2 读取整数：nextInt() ----------
        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();
        System.out.println("你输入的整数是：" + num);

        // ---------- 3.3 读取小数：nextDouble() ----------
        System.out.print("请输入一个小数：");
        double d = scanner.nextDouble();
        System.out.printf("你输入的小数是：%.2f%n", d);

        // ---------- 3.4 读取一个单词（不含空格）：next() ----------
        System.out.print("请输入一个单词：");
        String word = scanner.next();       // 遇到空格/回车就停止读取
        System.out.println("你输入的单词是：" + word);

        // ---------- 3.5 读取一整行（含空格）：nextLine() ----------
        // ⚠️ nextDouble()后接nextLine()要先消费残留换行符
        scanner.nextLine();
        System.out.print("请输入一整句话：");
        String line = scanner.nextLine();   // 读取直到回车换行的全部内容
        System.out.println("你输入的句子是：" + line);

        // ---------- 3.6 读取单个字符 ----------
        // Java的Scanner没有nextChar()方法，通常读字符串再取第一个字符
        System.out.print("请输入一个字符：");
        String temp = scanner.next();
        char ch = temp.charAt(0);          // 取字符串的第0个字符
        System.out.println("你输入的字符是：" + ch);

        // ⚠️ 用完Scanner建议关闭（释放资源）
        scanner.close();

        // ============================================================
        // 三、输入输出的常见陷阱
        // ============================================================

        System.out.println("===== 4. 常见陷阱 =====");

        // ---------- 陷阱1：nextInt() 和 nextLine() 混用 ----------
        /*
         * 问题：nextInt() 读完数字后，换行符 \n 还留在缓冲区
         *       紧接着调用 nextLine() 会读到一个空字符串
         * 解决：在 nextLine() 前加一次 scanner.nextLine() 吃掉残留换行符
         *
         * 示例：
         *   int n = scanner.nextInt();      // 输入 5 后按回车
         *   scanner.nextLine();             // ← 加这一行，吃掉多余的换行符
         *   String s = scanner.nextLine();  // 这样才能正常读到下一行
         */
        System.out.println("陷阱1：nextInt()后接nextLine()要额外消费换行符");

        // ---------- 陷阱2：next() vs nextLine() ----------
        /*
         * next()：只读到空格为止，不能读取带空格的完整句子
         *   输入 "hello world"  →  只读到 "hello"
         * nextLine()：读到回车为止，可以包含空格
         *   输入 "hello world"  →  读到 "hello world"
         */

        // ---------- 陷阱3：printf 的分隔符 ----------
        /*
         * printf 的参数之间用【逗号 ,】分隔，不是分号
         * System.out.printf("%d,%d", a, b);    ✅
         * System.out.printf("%d;%d"; a; b);    ❌ 语法错误
         */

        // ---------- 陷阱4：整数除法 ----------
        /*
         * int / int = int（小数部分被截断）
         * 想要精确结果，至少有一个操作数是浮点数
         *   5 / 2     → 2   （截断）
         *   5.0 / 2   → 2.5 （正确）
         *   5 / 2.0   → 2.5 （正确）
         */
        int a = 5, b = 2;
        System.out.println("整数除法 5/2 = " + (a / b));       // 输出 2
        System.out.println("浮点除法 5.0/2 = " + (a * 1.0 / b)); // 输出 2.5

        // ---------- 陷阱5：中文标点 ----------
        /*
         * Java代码中所有符号必须是【英文半角】
         * System.out.println（"你好");  ❌ 中文括号和分号
         * System.out.println("你好");   ✅
         */

        // ============================================================
        // 四、综合示例：输入学生成绩并格式化输出
        // ============================================================

        System.out.println("===== 5. 综合示例 =====");

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你的姓名：");
        String studentName = sc.next();

        System.out.print("请输入高等数学成绩：");
        double mathScore = sc.nextDouble();

        System.out.print("请输入大学英语成绩：");
        double englishScore = sc.nextDouble();

        double avg = (mathScore + englishScore) / 2.0;

        System.out.println("-------- 成绩单 --------");
        System.out.printf("姓名：%s%n", studentName);
        System.out.printf("数学：%.1f  英语：%.1f  平均：%.2f%n", mathScore, englishScore, avg);
        System.out.printf("等级：%s%n", avg >= 90 ? "优秀" : (avg >= 60 ? "及格" : "不及格"));
    }
}
