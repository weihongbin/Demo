package whb.cn.com.customeview.RelacteUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestReflect {
    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("whb.cn.com.customeview.User");
//        // 调用TestReflect类中的reflect1方法
//        Constructor constructor = clazz.getDeclaredConstructor(int.class,String.class);
//        constructor.setAccessible(true);
//        Object obj=constructor.newInstance(1,"2");
//        Field field=obj.getClass().getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(obj,"awsasa");
//        System.out.print(field.get(obj));
//        Method method=obj.getClass().getDeclaredMethod("reflect1");
//        method.setAccessible(true);
//        method.invoke(obj);
//        Method method2=obj.getClass().getDeclaredMethod("reflect2",int.class,String.class);
//        method2.setAccessible(true);
//        method2.invoke(obj,23,"魏红彬");
        Class<?> clazz2 = Class.forName("whb.cn.com.customeview.User");
        Class<?> clazz=User.class;
//        Class<?> clazz3 =new User().getClass();
        // 调用TestReflect类中的reflect1方法
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);//反射获取构造对象
        Object obj=constructor.newInstance();
        Field field=obj.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"awsasa");//反射修改属性值
        System.out.print(field.get(obj));
        Method method=obj.getClass().getDeclaredMethod("reflect1");
        method.setAccessible(true);
        method.invoke(obj);
        Method method2=obj.getClass().getDeclaredMethod("reflect2",int.class,String.class);
        method2.setAccessible(true);
        method2.invoke(obj,23,"魏红彬");//反射调用方法
        // Java 反射机制 - 调用某个类的方法2.
        // age -> 20. name -> 张三

//
//        Class<?> cla =Class.forName("whb.cn.com.customeview.User");
//        Object obj = cla.newInstance();
//
//        // 可以直接对 private 的属性赋值
////        Field field = cla.getDeclaredField("name");
////        field.setAccessible(true);
////        field.set(obj, "Java反射机制");
//        Field field = cla.getDeclaredField("name");//属性
//        field.setAccessible(true);
//        field.set(obj,"魏红彬");
//        System.out.println(field.get(obj));

        ArrayList<Integer> list = new ArrayList<>();
//        Method method3 = list.getClass().getMethod("add", Object.class);
//
//        method.invoke(list, 123);//方法
//        method.invoke(list, 345);
//        method.invoke(list, 456);
//        method.invoke(list, 98);
//        System.out.println(list.get(3)+"\n"+list.size());
//        Method method2 = list.getClass().getMethod("remove",int.class);
//        method2.invoke(list,3);
//        System.out.println(list.get(2)+"\n"+list.size());
    }
//        System.out.println("Java 反射机制 - 调用某个类的方法2.");
//        System.out.println("age -> " + age + ". name -> " + name);
//    }


}