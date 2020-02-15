package classload;

/**
 * ClassLoadTest_7
 *
 * @Author bowen.cui
 * @Date 2020/2/15 16:39
 **/
public class ClassLoadTest_7 {

    public static void main(String[] args) {
        System.out.println(Singleton.count1);
        System.out.println(Singleton.count2);// 初始化的顺序是从上向下，count2在静态方法快的时候已经=2，后来又重新初始化为0
    }


}

class Singleton {

    public static int count1 = 1;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        count1++;
        count2++;
    }

    public static int count2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
