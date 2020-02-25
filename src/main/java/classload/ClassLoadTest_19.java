package classload;

import java.lang.reflect.Method;

/**
 * ClassLoadTest_19
 *
 * @Author bowen.cui
 * @Date 2020/2/22 17:57
 **/
public class ClassLoadTest_19 {

    public static void main(String[] args) throws Exception {
        ClassLoadTest_15 loader1 = new ClassLoadTest_15("load1");
        ClassLoadTest_15 loader2 = new ClassLoadTest_15("load2");
        Class<?> clazz1 = loader1.loadClass("classload.Person");
        Class<?> clazz2 = loader2.loadClass("classload.Person");

        //clazz1和clazz均由应用类加载器加载的，第二次不会重新加载，结果为true
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setPerson", Object.class);
        method.invoke(object1, object2);
    }

}
class Person {

    private Person person;

    public void setPerson(Object object) {
        this.person = (Person) object;
    }
}