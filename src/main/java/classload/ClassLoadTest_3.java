package classload;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
 * PS：即parent3的str会存入到ClassLoadTest3的常量池中，ClassLoadTest_3的main在输出Parent3.str时，实际上是从自己的常量池中获取的，所以不会初始化Parent3
 * 编译好后，就算删除Parent3的class文件，都可以执行main方法
 *
 * <p>助记符 ldc：表示将int、float或者String类型的常量值从常量池中推送至栈顶</p>
 * <p>助记符 bipush：表示将单字节（-128-127）的常量值推送到栈顶</p>
 * <p>助记符 sipush：表示将一个短整型值（-32768-32369）推送至栈顶</p>
 * <p>助记符 iconst_1：表示将int型的1推送至栈顶（iconst_m1到iconst_5）</p>
 * @Author bowen.cui
 * @Date 2020/2/15 14:31
 **/
public class ClassLoadTest_3 {

    public static void main(String[] args) {
        System.out.println(Parent3.s);
    }

}

class Parent3 {

    public static final String str = "this is str";
    static final short n = 127;
    static final int s = 128;
    static final int m = 6; //如果1-5  是 iconst_1-5 ,大于5 就是 其他的了
    static {
        System.out.println("this is Parent3 code block");
    }
}
