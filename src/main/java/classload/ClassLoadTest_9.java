package classload;

/**
 * 输出结果如下：
 * ClassLoadTest_9 code static          //先输出主类的静态方法快
 * ------------------
 * parent_9 code static                 //由于new Parent_9() 导致对Parent_9的主动使用，所以初始化Parent_9的静态代码块
 * Parent_9 的{}                         //静态代码执行完毕后是构造代码块
 * Parent_9 的()                        //构造方法最后执行
 * ------------------
 * 1
 * ------------------
 * Child_9 code static                  //由于主动引用子类的静态变量，所以导致Child_9刚被初始化
 * 2
 *
 * @Author bowen.cui
 * @Date 2020/2/16 17:50
 **/
public class ClassLoadTest_9 {

    static {
        System.out.println("ClassLoadTest_9 code static");
    }

    public static void main(String[] args) {
        Parent_9 parent_9;
        System.out.println("------------------");
        parent_9 = new Parent_9();
        System.out.println("------------------");
        System.out.println(Child_9.a);
        System.out.println("------------------");
        System.out.println(Child_9.b);

    }
}

class Parent_9 {

    static int a = 1;

    Parent_9(){
        System.out.println("Parent_9 的()");
    }

    {
        System.out.println("Parent_9 的{}");
    }

    static {
        System.out.println("parent_9 code static");
    }
}

class Child_9 extends Parent_9 {

    static int b = 2;

    static {
        System.out.println("Child_9 code static");
    }
}
