package classload;

/**
 * ClassLoadTest_11
 *
 * @Author bowen.cui
 * @Date 2020/2/17 15:44
 **/
public class ClassLoadTest_11 {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();// 如果没有设置classLoad 默认为 创建当前线程类的 ClassLoad，这里为应用类加载器，AppClassLoader
        System.out.println(classLoader);
        ClassLoader classLoader1 = ClassLoadTest_11.class.getClassLoader();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader2);
        ClassLoader classLoader3 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader3);
        System.out.println(String.class.getClassLoader()); // 输出null：因为String 用的是根类加载器，所以输出的是null

    }

}
