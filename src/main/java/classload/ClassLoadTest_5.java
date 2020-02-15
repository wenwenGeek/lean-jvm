package classload;

/**
 * 对于数组实例来说，器类型是有JVM在运行期动态生成的，表示为[Lclassload.Parent5;
 * 这种形式，动态生成的类型，其父类型就是Object
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 * anewarry：表示创建一个引用类型的（如：类、接口、数组）数组，并将其引用类型压入栈顶
 * newarry：表示创建一个指定的原始类型（如：int，flot，char），并将其引用值压入栈顶
 *
 * @Author bowen.cui
 * @Date 2020/2/15 14:31
 **/
public class ClassLoadTest_5 {

    public static void main(String[] args) {
        // Parent5 parent5 = new Parent5();                         // 主动使用，会创建实例
        Parent5[] parent5 = new Parent5[1];                         // 不是主动使用
        System.out.println(parent5.getClass());                     // 输出   class [Lclassload.Parent5;
        System.out.println(parent5.getClass().getSuperclass());     // 输出   class java.lang.Object

        Parent5[][] parent5_1 = new Parent5[1][1];
        System.out.println(parent5_1.getClass());                   // 输出   class [[Lclassload.Parent5;     字节码助记符为anewarray
        System.out.println(parent5_1.getClass().getSuperclass());

        int[] inta = new int[1];
        System.out.println(inta.getClass());                        // 输出   class class [I     字节码助记符为newarray
        System.out.println(inta.getClass().getSuperclass());
    }

}

class Parent5 {

    static {
        System.out.println("this is Parent5 code block");
    }
}
