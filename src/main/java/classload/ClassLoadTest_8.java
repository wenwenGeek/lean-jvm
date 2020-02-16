package classload;

/**
 * 查看某个类的类加载器
 *
 * @Author bowen.cui
 * @Date 2020/2/15 16:39
 **/
public class ClassLoadTest_8 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());//null 由于String是由根加载器加载，在rt.jar包下
        System.out.println(C.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@73d16e93
    }


}

class C {

}