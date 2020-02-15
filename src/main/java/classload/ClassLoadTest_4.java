package classload;

import java.util.UUID;

/**
 * 当一个常量的值并非编译器间可以确定的，那么其值就不会被放到调用类的常量池中
 * 这是在程序运行时，会导致主动使用这个常量所在的类（Parent4），所以（Parent4会被初始化）
 *
 * @Author bowen.cui
 * @Date 2020/2/15 14:31
 **/
public class ClassLoadTest_4 {

    public static void main(String[] args) {
        System.out.println(Parent4.str);
    }

}

class Parent4 {

    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("this is Parent4 code block");
    }
}
