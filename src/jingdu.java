public class jingdu {
    public static void main(String[] args) {
        System.out.println("===== 字符类型 =====");
        System.out.println("char  范围: " + (int) Character.MIN_VALUE + " ~ " + (int) Character.MAX_VALUE + "，占 2 字节");

        System.out.println("===== 整数类型(精度升序) =====");
        System.out.println("byte  范围: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE + "，占 1 字节");
        System.out.println("short 范围: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE + "，占 2 字节");
        System.out.println("int   范围: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE + "，占 4 字节");
        System.out.println("long  范围: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE + "，占 8 字节");

        System.out.println("===== 浮点类型(精度升序) =====");
        System.out.println("float 范围: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE + "，占 4 字节");
        System.out.println("double 范围: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE + "，占 8 字节");

        System.out.println("===== 综合精度排序 =====");
        System.out.println("byte(1) < short(2) = char(2) < int(4) = float(4) < long(8) = double(8)");
    }
}
//byte(1字节) < short(2字节) < int(4字节) < long(8字节)
//float(4字节) < double(8字节)
//byte(1) < short(2) < char(2) < int(4) = float(4) < long(8) = double(8)