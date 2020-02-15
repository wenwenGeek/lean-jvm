package classload;

/**
 * 这种情况不会输出，子类的：this Children static
 * 因为子类Children没有被主动使用
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
    public static String a = "this parent";
    static {
        System.out.println("this Parent static");
    }
}
class Children extends Parent {
    static {
        System.out.println("this Children static");
    }
}