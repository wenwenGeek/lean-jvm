package classload;

/**
 * 当一个常量的值并非编译器间可以确定的，那么其值就不会被放到调用类的常量池中 这是在程序运行时，会导致主动使用这个常量所在的类（Parent4），所以（Parent4会被初始化）
 *
 * @Author bowen.cui
 * @Date 2020/2/15 14:31
 **/
public class ClassLoadTest_5 {

    public static void main(String[] args) {
        Parent5 parent5 = new Parent5();
    }

}

class Parent5 {

    static {
        System.out.println("this is Parent5 code block");
    }
}
