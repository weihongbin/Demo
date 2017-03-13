package whb.cn.com.annotation;

import whb.cn.com.annotation.utils.Test;

/**
/* * =============================================
 * *//**
 * @Retention；
 * 指定被修饰的Annotation可以保留多长时间；
 * 只有一个参数，参数类型RetentionPolicy value();
 * 可以@Retention(RetentionPolicy.XXX)或者@Retention(value=RetentionPolicy.XXX)
 * 两种用法；参数的值有三个：
 * RetentionPolicy.SOURCE Annotation只保留在源码中
 * RetentionPolicy.CLASS  Annotation保留在源码和class文件中
 * RetentionPolicy.RUNTIME Annotation记录在class中，当java程序运行时也会保留在JVM中
 *//*
@Retention(RetentionPolicy.RUNTIME)
*//**
 * @Target
 * 指定被修饰的Annotation能用于修饰哪些程序单元
 * 只有一个参数，参数类型ElementType[] value();
 * 只需要修饰一个target时可以@Target({ElementType.METHOD})或@Target(ElementType.METHOD)
 * 当修饰的target有多个时，则@Target({ElementType.METHOD,ElementType.FIELD})，target不能重复
 * 参数值如下：
 * ElementType TYPE; 类、接口、枚举
 * ElementType FIELD; 成员变量
 * ElementType METHOD; 方法
 * ElementType PARAMETER; 参数
 * ElementType CONSTRUCTOR; 构造函数
 * ElementType LOCAL_VARIABLE; 局部变量
 * ElementType ANNOTATION_TYPE; 只能修饰Annotation
 * ElementType PACKAGE; 修饰包
 *//*
@Target({ElementType.METHOD,ElementType.FIELD})
*//**
 * 修饰后，Annotation将具有继承性，也就是对被Annotation修饰的类的子类也有效
 * 但是！annotations on implemented interfaces have no effect.
 * 也就是这个修饰对于接口interface无效
 *//*
@Inherited
*//**
 * 修饰后Annotation能被javadoc提取为文档
 *//*
@Documented
*//**
 * 定义一个Annotation
 * 用@interface修饰，和定义interface很像
 *//*
public @interface Song {
    *//**
     * 1、
     * 定义成员变量：
     * 以无参的方法形式声明，其方法名和返回值定义了该成员变量的名字和类型，如：
     * String name();成员变量名为name，类型为String如果要设默认值的话可以加default valu
     * String name() default "songlin";
     *//*

    *//**
     * 2、
     * 没有定义成员变量的Annotation类型成为标记，如@Override
     *//*

    *//**
     * 3、
     * 如果只有一个成员变量时，变量名取名value,如：
     * String value();
     *//*

    *//**
     * 4、多个成员变量时：
     *//*

    String name();
    int age();
    String desc() default "desc";
    *//**-------------------Annotation定义完成！！！-----------------*//*
}*/
/**
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.annotation.Person.java
 * @author: 魏红彬
 * @date: 2017-03-13 10:19
 */


public class Person {

    public String id;

    public String desc;

    public int age;

    @Test(id = "21", desc = "whb", age = 12)
    public String getId() {
        return id;
    }
    @Test(id = "21", desc = "whb", age = 12)
    public void setId(String id) {
        this.id = id;
    }
    @Test(id = "21", desc = "whb", age = 12)
    public String getDesc() {
        return desc;
    }
    @Test(id = "21", desc = "whb", age = 12)
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Test(id = "21", desc = "whb", age = 12)
    public int getAge() {
        return age;
    }
    @Test(id = "21", desc = "whb", age = 12)
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    @Test(id = "21", desc = "whb", age = 12)
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                '}';
    }
}