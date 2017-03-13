package whb.cn.com.customeview.RelacteUtils;

import java.io.Serializable;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.User.java
 * @author: 魏红彬
 * @date: 2017-03-10 13:58
 */
public class User implements Serializable {
    private static final String TAG = "User";

    private int  age;

    private  String name;

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private    User(){

 }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


     private void reflect1(){
        System.out.print("whb>>>>>>>>>>>>>>>>>>反射");
    }
     private void reflect2(int age,String name){
        System.out.print(age+">>>>>>>>>>>>>>>>>>name="+name);
    }
}