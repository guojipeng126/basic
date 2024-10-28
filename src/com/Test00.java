package com;

public class Test00 {

    public static void main(String[] args) {

        //对象传递测试
        User user1 = new Test00() .new User();
        user1.name = "name";
        change(user1);
        System.out.println(user1.name + ":::" + user1.value);
        change2(user1);
        System.out.println(user1.name + ":::" + user1.value);

        //String传递测试
        String s1 = "test00";
        changeString(s1);
        System.out.println(s1);
    }

    static void changeString(String s2){
        s2 += "abc";
    }

    static void change(User user2){
        user2.value = "value";
    }
    static void change2(User user3){
        user3 = new Test00().new User();
    }

    class User{
        String name;
        String value;
        User(){

        }
        User(String name, String value){
            this.name = name;
            this.value = value;
        }
    }


//    public static void main(String[] args) {
//
//        System.out.println(solution(286));
//    }

//    public static int solution(int param){
//        if(param <= 0){
//            return 0;
//        }
//
//        for(int i = 0; i < param; i++){
//            if(i * i <= param && (i + 1) * (i + 1) > param){
//                return i;
//            }
//        }
//        return 0;
//    }


}
