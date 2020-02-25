package classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 实现自定义类加载器2
 *
 * 当我们把需要加载的类放置到非classPath中
 * 并且classPath不能包含这个类
 * 类加载器会采用自定义类加载器
 *
 *
 * @Author bowen.cui
 * @Date 2020/2/20 18:28
 **/
public class ClassLoadTest_14 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    protected ClassLoadTest_14(ClassLoader parent, String classLoaderName) {
        // 指定父类加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    protected ClassLoadTest_14(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("这是我的类加载器类名称"+className);
        System.out.println("这是我的类加载器名称"+this.classLoaderName);
        byte[] bytes = loadClassData(className);
        return this.defineClass(className, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String className) {
        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            className = className.replace(".", "\\");
            inputStream = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = inputStream.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
                assert baos != null;
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoadTest_14 classLoadTest_14 = new ClassLoadTest_14("cui1");
        classLoadTest_14.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz = classLoadTest_14.loadClass("classload.ClassLoadTest_1");
        Object object = clazz.newInstance();
        System.out.println(clazz.hashCode());
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        System.out.println("---------------------------------------");
        /**
         * 由于两个类加载器的命名空间不一样，所以可以存在同样的类
         */
        ClassLoadTest_14 classLoadTest_15 = new ClassLoadTest_14("cui2");
        classLoadTest_15.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz1 = classLoadTest_15.loadClass("classload.ClassLoadTest_1");
        Object object1 = clazz1.newInstance();
        System.out.println(clazz1.hashCode());
        System.out.println(object1);
        System.out.println(object1.getClass().getClassLoader());

        System.out.println("---------------------------------------");
        /**
         * 将 上面的例子的 类加载器，当做这个类的父类加载器，
         * 当再次加载这个类的时候，由于双亲委托机制，会先看一下 父类加载器中是否已经贾在过，如果已经加载过，自己不再加载了，可以看出object2的类加载器依然是 [cui2]
         */
        ClassLoadTest_14 classLoadTest_16 = new ClassLoadTest_14(classLoadTest_15,"cui3");
        classLoadTest_16.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz2 = classLoadTest_16.loadClass("classload.ClassLoadTest_1");
        Object object2 = clazz2.newInstance();
        System.out.println(clazz2.hashCode());
        System.out.println(object2);
        System.out.println(object2.getClass().getClassLoader());

    }
}
