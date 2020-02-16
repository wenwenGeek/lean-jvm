package classload;

/**
 * ClassLoadTest_10
 *
 * @Author bowen.cui
 * @Date 2020/2/16 20:18
 **/
public class ClassLoadTest_10 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz;
        clazz = loader.loadClass("classload.Cui");      // 调用ClassLoad类的loadClass方法加载一个类，并不会对类主动使用，不会导致初始化
        System.out.println(clazz);
        System.out.println("-----------------");
        clazz = Class.forName("classload.Cui");                 //反射：Class.forName 会实例化类
        System.out.println(clazz);
    }

}

class Cui {

    static {
        System.out.println("this Cui class");
    }
}
