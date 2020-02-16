package classload;

/**
 * <p>如果是接口初始化时，并不要求其父接口都完成了初始化 </p>
 * <p>只有在真正使用父接口的时候（如引用接口中的锁定义的常量时。或有不确定内容例如random）才会执行</p>
 */
public class ClassLoadTest_6 {

    public static void main(String[] args) {
        System.out.println(Children6.b);
    }

}

interface Parent6 {

    public static Thread thead = new Thread() {
        {
            System.out.println("如果我被输出代表Parent6被初始化");
        }
    };
}

interface Children6 extends Parent6 {

    public static int b = 6;
}