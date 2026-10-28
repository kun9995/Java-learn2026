import java.util.Scanner;

/**
 * Java 输入输出知识汇总 —— 课堂笔记 + 示例代码
 *
 * 一、输出（System.out）
 * 二、格式化输出（printf）
 * 三、输入（Scanner）
 * 四、常见问题与注意事项
 * 五、选择结构（if / else if / else）
 * 六、循环结构（while / do-while / for）
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

        // ============================================================
        // 五、选择结构：if / else if / else
        // ============================================================

        System.out.println("===== 6. if 选择结构 =====");

        // ---------- 6.1 基本语法 ----------
        /*
         * if (条件1) {
         *     条件1成立时执行
         * } else if (条件2) {
         *     条件1不成立、条件2成立时执行
         * } else {
         *     以上条件都不成立时执行
         * }
         *
         * ★ 条件必须是 boolean 类型（true / false）
         * ★ 从上往下依次判断，一旦某个条件成立，执行完就跳出整个结构
         * ★ else if 可以有 0 个或多个；else 最多 1 个，必须放在最后，也可以省略
         */

        // ---------- 6.2 单分支 if：条件成立才执行 ----------
        int checkNum = 7;
        if (checkNum % 2 == 0) {
            System.out.println(checkNum + " 是偶数");
        }

        // ---------- 6.3 双分支 if-else：非此即彼 ----------
        if (checkNum % 2 == 0) {
            System.out.println(checkNum + " 是偶数");
        } else {
            System.out.println(checkNum + " 是奇数");
        }

        // ---------- 6.4 多分支 if-else if-else：多选一（成绩等级） ----------
        int javaScore = 86;
        String level;
        if (javaScore >= 90) {
            level = "优秀";
        } else if (javaScore >= 80) {
            level = "良好";
        } else if (javaScore >= 70) {
            level = "中等";
        } else if (javaScore >= 60) {
            level = "及格";
        } else {
            level = "不及格";
        }
        System.out.println("成绩 " + javaScore + " 的等级是：" + level);

        // ---------- 6.5 嵌套 if：判断闰年 ----------
        // 闰年规则：能被 4 整除且不能被 100 整除，或者能被 400 整除
        int year = 2024;
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println(year + " 是闰年（普通闰年）");
            } else if (year % 400 == 0) {
                System.out.println(year + " 是闰年（世纪闰年）");
            } else {
                System.out.println(year + " 不是闰年");
            }
        } else {
            System.out.println(year + " 不是闰年");
        }

        // 上面这段用逻辑运算符可以压缩成一个条件：
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " 是闰年（逻辑运算符写法）");
        }

        // ---------- 6.6 三目运算符：简单二选一写一行 ----------
        // 语法：条件 ? 条件成立时的值 : 条件不成立时的值
        String pass = javaScore >= 60 ? "及格" : "不及格";
        System.out.println("三目运算符判断：" + pass);

        // ---------- 6.7 if 的常见陷阱 ----------
        /*
         * 陷阱1：if 后面多写了一个分号
         *   if (x > 0);           ❌ 分号是"空语句"，下面的代码块会无条件执行
         *   if (x > 0) { ... }    ✅
         *
         * 陷阱2：把 == 写成 =
         *   if (x = 1) { }        ❌ 编译错误（= 是赋值，结果不是 boolean）
         *   if (x == 1) { }       ✅
         *
         * 陷阱3：Java 里不能写 if (x)
         *   C 语言中 0 为假、非 0 为真；Java 的条件只能是 boolean，必须写 if (x != 0)
         *
         * 陷阱4：浮点数不要直接用 == 比较
         *   if (0.1 + 0.2 == 0.3)                        ❌ 结果为 false（精度问题）
         *   if (Math.abs(0.1 + 0.2 - 0.3) < 1e-6)        ✅ 差值足够小即认为相等
         *
         * 陷阱5：省略大括号
         *   if (x > 0) System.out.println("正数"); System.out.println("结束");
         *   → 只有第一句受 if 控制，第二句永远会执行
         *
         * 陷阱6：else 永远配对【最近】的那个 if（悬挂 else），建议一律加大括号
         */

        // ============================================================
        // 六、循环结构：while / do-while / for
        // ============================================================

        System.out.println("===== 7. 循环结构 =====");

        // 循环三要素：① 循环变量初始化  ② 循环条件  ③ 循环变量更新（缺一不可）

        // ---------- 7.1 while：先判断，后执行（可能一次都不执行） ----------
        int i = 1;
        int sum = 0;
        while (i <= 100) {
            sum += i;          // 累加
            i++;               // ⚠️ 忘了这行就是死循环
        }
        System.out.println("1+2+...+100 = " + sum);

        // ---------- 7.2 do-while：先执行一次，再判断（至少执行一次） ----------
        int j = 1;
        do {
            System.out.println("do-while 第 " + j + " 次执行");
            j++;
        } while (j <= 3);      // ⚠️ 结尾必须有英文分号
        // 即使一开始条件就不成立，循环体也会执行 1 次

        // ---------- 7.3 for：循环次数已知时最常用 ----------
        /*
         * 语法：for (初始化; 条件; 更新) { 循环体 }
         * 执行顺序：初始化 → 判断条件 → 循环体 → 更新 → 判断条件 → …… → 条件为 false 结束
         */
        for (int k = 1; k <= 5; k++) {
            System.out.print(k + " ");
        }
        System.out.println();

        // 用 for 求 1~100 的和（和上面 while 结果相同）
        sum = 0;
        for (int k = 1; k <= 100; k++) {
            sum += k;
        }
        System.out.println("for 求 1+...+100 = " + sum);

        // 用 for 求 5 的阶乘：5! = 1×2×3×4×5
        int factorial = 1;
        for (int k = 1; k <= 5; k++) {
            factorial *= k;
        }
        System.out.println("5! = " + factorial);

        // 用 for 输出 1~20 中的所有奇数
        System.out.print("1~20 中的奇数：");
        for (int k = 1; k <= 20; k++) {
            if (k % 2 != 0) {
                System.out.print(k + " ");
            }
        }
        System.out.println();

        // ---------- 7.4 break 与 continue ----------
        // break：立刻结束【整个】循环
        // continue：跳过本次循环剩余语句，直接进入下一次循环
        System.out.print("用 break 找 10~100 中第一个能被 7 整除的数：");
        for (int k = 10; k <= 100; k++) {
            if (k % 7 == 0) {
                System.out.println(k);
                break;
            }
        }

        System.out.print("用 continue 输出 1~10 中不是 3 的倍数的数：");
        for (int k = 1; k <= 10; k++) {
            if (k % 3 == 0) {
                continue;
            }
            System.out.print(k + " ");
        }
        System.out.println();

        // ---------- 7.5 嵌套循环：外层控制行，内层控制列 ----------
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();   // 换行必须写在内层循环【外面】
        }

        // 九九乘法表（下三角）
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d×%d=%-3d", col, row, col * row);
            }
            System.out.println();
        }

        // ---------- 7.6 死循环 ----------
        // while (true) { ... } 和 for (;;) { ... } 都是死循环写法，通常配合 break 使用
        // 最常见错误：while 里忘了把循环变量 +1，程序卡死不结束
        // 真卡住了，在 IDEA 控制台点红色方块（Stop）结束程序

        // ---------- 7.7 三种循环怎么选 ----------
        /*
         * 循环次数已知（1~100、数组遍历……）           → for
         * 次数未知、先判断再执行（"输入0结束"）        → while
         * 次数未知、至少执行一次（菜单、验证输入）      → do-while
         */

        // ---------- 7.8 循环读输入的典型写法（仅说明，不执行，避免卡住） ----------
        /*
         * 需求：不断输入整数，输入 0 时结束，并统计总和
         *
         *   int total = 0;
         *   while (true) {
         *       System.out.print("请输入一个整数（输入0结束）：");
         *       int n = sc.nextInt();
         *       if (n == 0) {
         *           break;
         *       }
         *       total += n;
         *   }
         *   System.out.println("总和 = " + total);
         *
         * 注意：这里的 sc 就是第 5 节综合示例里创建的那个 Scanner 对象
         */
    }
}
