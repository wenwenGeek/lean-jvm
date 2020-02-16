package classload;

/**
 * 这种情况不会输出，子类的：this Children static 因为子类Children没有被主动使用
 *
 * @Author bowen.cui
 * @Date 2020/2/14 22:57
 **/
public class ClassLoadTest_1 {

    public static void main(String[] args) {
        System.out.println(Children.a);
    }
}

class Parent {

    // public static final String a = "this parent";    // 加了final a就是常量，编译后会自动将A 放到常量池中，
    public static String a = "this parent";             // 不加final就不是常量了。

    static {
        System.out.println("this Parent static");
    }
}

class Children extends Parent {

    static {
        System.out.println("this Children static");
    }
}