package classload;

/**
 * 当前类加载器 （current classloader）
 * 每个类都会使用自己的类加载器来去加载其他的所依赖的类
 *
 * 线程上下文类加载器 （Context classloader）
 *
 * 线程上下文加载器是从JDK 1.2开始引入的，类Threade中的getContextClassLoader()与setContextClassLoader(ClassLoader cl) 分别用来获取和设置上下文类加载器的
 *
 * 如果没有通过setContextClassLoader(ClassLoader cl) 来进行设置的话，线程将继承父线程的上下文类加载器
 * Java 应用运行时的初始线程的上下文加载器是系统类加载器。
 *
 * 线程上下文类加载器的重要性：
 *
 * 由于：父类不能使用子类的类加载器，但是子类可以使用父类的类加载器。如果想让一个类使用和自己不相干的类加载器， 这时候就需要用到了上下文类加载器
 *
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所制定的classloader加载的类
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载的类的情况，及时改变了双亲委托模型。
 *
 * @Author bowen.cui
 * @Date 2020/2/29 18:37
 **/
public class ClassLoadTest_20 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }

}
