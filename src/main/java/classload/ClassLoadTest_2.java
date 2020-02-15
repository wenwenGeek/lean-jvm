package classload;

/**
 * 这种情况会输出子类的：this Children static
 *
 * 虽然main方法调用的是父类的静态变量：a
 * 子类没有被主动使用，所以子类不会初始化
 *
 * <P>-XX:+TraceClassLoading，用于追踪类的加载信息并打印出来</p>
 * <h2>jvm参数设置</h2>
 * <P> -XX:+<option>，表示开启option选项</p>
 * <P>-XX:-<option>，表示关闭option选项</p>
 * <P>-XX:<option>=value，表示将option的值设置为value</p>
 *
 * @Author bowen.cui
 * @Date 2020/2/14 22:57
 **/
public class ClassLoadTest_2 {

    public static void main(String[] args) {
        System.out.println(Children_2.a);
    }

}

class Parent_2 {

    public static String a = "this parent";

    static {
        System.out.println("this Parent static");
    }
}

class Children_2 extends Parent_2 {

    public static String b = "this Children";

    static {
        System.out.println("this Children static");
    }
}