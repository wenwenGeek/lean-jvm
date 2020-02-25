package classload;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 扩展类加载器的应用
 *
 * @Author bowen.cui
 * @Date 2020/2/22 17:31
 **/
public class ClassLoadTest_18 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(ClassLoadTest_18.class.getClassLoader());
    }


}
