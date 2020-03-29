package bytecode;


/**
 * 栈帧 （stack frame）
 *
 * 栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构
 *
 * 栈帧本身是一种数据结构，封装了方法的局部变量表、动态连接信息、方法的返回地址及操作数栈等信息
 *
 * 符号引用，直接引用
 *  有些符号应用是在类加载阶段伙食第一次使用时就会转为直接引用，这种转换叫静态解析，
 *  另外一些符号引用则是在每次运行期转换为直接引用，这种转换叫做动态链接，这体现为java的多态性
 *
 *  1：invokeinterface:调用接口中的方法，具体调用哪个实现类的方法，实际上是在运行期间决定的，
 *  2：invokestatic：调用静态方法
 *  3：invokespecial：掉欧阳自己的私有方法，构造方法（<init>）以及父类的方法
 *  4：invokevirtual：调用虚方法，运行期动态查找过程
 *  5：invokedynamic：动态调用方法。
 *
 *  静态解析的四种情况
 *
 *  1：静态方法
 *  2：父类方法
 *  3：构造方法
 *  4：私有方法（无法被从写）
 *
 *  以上4类方法称作非虚方法，他们是在类加载阶段就可以将符号引用直接转为直接引用。
 */
public class ByteCodeTest4 {

    public static void main(String[] args) {

        test();

    }

    public static void test() {
        System.out.println("test 123");
    }

}
