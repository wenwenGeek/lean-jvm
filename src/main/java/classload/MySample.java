package classload;

/**
 * MySample
 *
 * @Author bowen.cui
 * @Date 2020/2/22 16:41
 **/
class MySample {

    public MySample() {
        System.out.println("B16的类加载器 = " + this.getClass().getClassLoader());
        new MyCat();
    }
}
