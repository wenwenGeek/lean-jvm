package classload;

import java.lang.reflect.Method;

/**
  - 双亲委托模型的好处
  - 可以确保Java和辛苦的类型安全：所有的Java应用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个类会被加载到Java虚拟机中，如果这个加载过程是由Java应用自定义加载器来完成，那么很有可能在JVM中存在多个版本的Object类，而且这些类之间还是不兼容的，相互不可见的。（命名空间不同，所以不可见）
  - 可以确保Java核心类库所提供的的类不会被自定义的类所替代。
  - 不同的类加载器可以为相同名称的类创建额外的命名空间，相同名称类可以并存在Java虚拟机中，只要用不同的类加载器加载他们即可。不同类加载器所加载的类之间是不就兼容的，这就相当于在Java虚拟机内部创建了一个有一个相互格力的Java类空间，这类技术在很多框架中得到了实际的应用。
 *
 * @Author bowen.cui
 * @Date 2020/2/22 17:57
 **/
public class ClassLoadTest_19_1 {

    public static void main(String[] args) throws Exception {
        // 每个类加载器都有自己的命名空间
        ClassLoadTest_15 loader1 = new ClassLoadTest_15("load1");
        ClassLoadTest_15 loader2 = new ClassLoadTest_15("load2");
        loader1.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        loader2.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz1 = loader1.loadClass("classload.Person_1");
        Class<?> clazz2 = loader2.loadClass("classload.Person_1");

        //由于loader1 和loader2 不存在任何双亲的关系，所以这两个不是相同的命名空间,显然是不同的对象
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1);
        System.out.println(clazz2);
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", Object.class);
        method.invoke(object1, object2);
    }

}

class Person_1 {

    private Person_1 person;

    public void setPerson(Object object) {
        this.person = (Person_1) object;
    }
}
