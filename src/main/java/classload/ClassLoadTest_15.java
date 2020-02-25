package classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 实现自定义类卸载
 *
 * 为了明显的看到效果，需要在加上JVM 启动参数 ：-XX:+TraceClassUnloading
 *
 * 自定义类加载器在没有引用的时候可以被卸载的原理，我们赋空值，然后手动执行System.go(),可以看到控制台输出如下
 * [Unloading class classload.ClassLoadTest_1 0x00000007c0061028]
 *
 * @Author bowen.cui
 * @Date 2020/2/20 18:28
 **/
public class ClassLoadTest_15 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    protected ClassLoadTest_15(ClassLoader parent, String classLoaderName) {
        // 指定父类加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    protected ClassLoadTest_15(String classLoaderName) {
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
        ClassLoadTest_15 classLoadTest_14 = new ClassLoadTest_15("cui1");
        classLoadTest_14.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz = classLoadTest_14.loadClass("classload.ClassLoadTest_1");
        Object object = clazz.newInstance();
        System.out.println(clazz.hashCode());
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        System.out.println("---------------------------------------");
        clazz = null;
        object = null;
        classLoadTest_14 = null;
        System.gc();

        classLoadTest_14 = new ClassLoadTest_15("cui1");
        classLoadTest_14.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        clazz = classLoadTest_14.loadClass("classload.ClassLoadTest_1");
        object = clazz.newInstance();
        System.out.println(clazz.hashCode());
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }
}
