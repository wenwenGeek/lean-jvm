package classload;

import sun.misc.Launcher;

/**
 * 输出各种加载器所加载的路径
 *
 * @Author bowen.cui
 * @Date 2020/2/22 17:31
 **/
public class ClassLoadTest_17 {

    public static void main(String[] args) {
        System.out.println("根类加载器所在路径" + System.getProperty("sun.boot.class.path"));
        System.out.println("扩展类加载器所在路径" + System.getProperty("java.ext.dirs"));
        System.out.println("系统类加载器所在路径" + System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        // 扩展类加载器与系统类加载器也是由启动类加载器所加载的
        System.out.println(Launcher.class.getClassLoader());
        System.out.println("-----------------------------");
    }


}
