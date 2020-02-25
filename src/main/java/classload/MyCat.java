package classload;

/**
 * MyCat
 *
 * @Author bowen.cui
 * @Date 2020/2/22 16:41
 **/
class MyCat {

    public MyCat() {
        System.out.println("A16的类加载器 = " + this.getClass().getClassLoader());
    }
}
