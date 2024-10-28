package com.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过java的反射，
 * 可以访问私有构造函数
 * 可以访问私有属性
 * 可以访问私有方法
 */
public class ReflectTest {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Person newP = null;
        Class pClass = Person.class;
        Constructor[] constructors = pClass.getDeclaredConstructors();      //通过反射，使用私有构造函数，生成实例
        for (Constructor con : constructors){
            con.setAccessible(true);
            newP = (Person) con.newInstance("xinren");
        }

        System.out.println("反射构造:  " + "newP: name = " + newP.getName() + ", address = " + newP.getAddress());

        Field[] fields = pClass.getDeclaredFields();      //通过反射，使用私有属性，并赋值；
        for (Field field : fields){
            field.setAccessible(true);
            field.set(newP, "xin_shuju");
        }

        System.out.println("反射属性:  " + "newP: name = " + newP.getName() + ", address = " + newP.getAddress());

        Method[] methods = pClass.getDeclaredMethods();      //通过反射，使用私有方法，并赋值；
        for(Method method : methods){

            method.setAccessible(true);
            if(method.getName().equals("setName")){
                method.invoke(newP, "xin_fangfa");
            }
        }

        System.out.println("反射方法:  " + "newP: name = " + newP.getName() + ", address = " + newP.getAddress());

    }
}
