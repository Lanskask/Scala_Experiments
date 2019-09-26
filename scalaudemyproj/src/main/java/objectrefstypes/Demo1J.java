package objectrefstypes;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Demo1J {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(Demo1.class.getMethod("f").getReturnType());
        System.out.println(Demo1.class.getMethod("g").getReturnType());
        System.out.println(Demo1.class.getMethod("h").getReturnType());

        System.out.println();

        System.out.println(new Demo1().g().getClass());
        System.out.println(new Demo1().h().getClass());
    }

}
