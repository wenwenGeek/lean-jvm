package classload;

import com.sun.org.apache.xalan.internal.utils.ObjectFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 实现自定义类加载器
 *
 * @Author bowen.cui
 * @Date 2020/2/20 18:28
 **/
public class ClassLoadTest_13 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    protected ClassLoadTest_13(ClassLoader parent, String classLoaderName) {
        // 指定父类加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    protected ClassLoadTest_13(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] bytes = loadClassData(className);
        return this.defineClass(className, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String className) {
        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(".", "\\");
            inputStream = new FileInputStream(new File(className + this.fileExtension));
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
        Class<?> clazz = classLoader.loadClass("classload.ClassLoadTest_1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoadTest_13 classLoadTest_13 = new ClassLoadTest_13("cui");
        test(classLoadTest_13);

    }
}
