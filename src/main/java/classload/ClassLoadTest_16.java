package classload;

/**
 * @Author bowen.cui
 * @Date 2020/2/20 18:28
 **/
public class ClassLoadTest_16 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ClassLoadTest_15 classLoadTest_15 = new ClassLoadTest_15("ClassLoadTest_16");
        //classLoadTest_15.setPath("C:\\Users\\cuibowen3\\Desktop\\");
        Class<?> clazz = classLoadTest_15.loadClass("classload.MySample");
        System.out.println(clazz.hashCode());

        //如果注释掉该行，就并不会实例化MySample对象，不会加载MyCat（可能预先加载）
        Object instance = clazz.newInstance();//实列化Simple和MyCat
        //MyCat是由加载MySample的加载器去加载的：

        // 如果把 MyCat的class 删掉， 在输出，MySample 的 sout 后， 会报classnotfont的错
    }
}

