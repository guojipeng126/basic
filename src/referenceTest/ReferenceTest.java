package referenceTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ReferenceTest {

    public static void main(String[] args) {
        testPhtoanReference();
    }

    public static void testPhtoanReference() {
        // 创建一个字符串对象
        String str = new String("Java的4大引用");
        // 创建一个引用队列
        ReferenceQueue rq = new ReferenceQueue();
        // 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
        PhantomReference pr = new PhantomReference(str, rq);
        // 切断str引用和"Java的4大引用"字符串之间的引用
        str = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null
        System.out.println(pr.get());
        // 强制垃圾回收
//        System.gc();
//        System.runFinalization();
        // 垃圾回收之后，虚引用将被放入引用队列中
        // 取出引用队列中最先进入队列中的引用与pr进行比较
        System.out.println(rq.poll() == pr);
        System.out.println("end");
    }
}
