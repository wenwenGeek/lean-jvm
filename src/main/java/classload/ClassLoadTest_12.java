package classload;

/**
 * ClassLoadTest_11
 *
 * @Author bowen.cui
 * @Date 2020/2/17 15:44
 **/
public class ClassLoadTest_12 {

    public static void main(String[] args) {

        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());// 数组类加载器，为类型本身的类加载器，String的加载器为根类加载器，输入位null

        ClassLoadTest_12[] classLoadTest_12s = new ClassLoadTest_12[2];
        System.out.println(classLoadTest_12s.getClass().getClassLoader());//ClassLoadTest 是应用类加载器，所以输出的是AppClassLoader

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());// 如果元素类型为原生类型，数组是没有类加载器的。

        //ps: 注意第一个和第三个的null 不是一回事
        //第一个null：根类加载器
        //第三个null：没有类加载器
    }

}
