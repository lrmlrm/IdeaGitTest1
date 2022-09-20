public class 父子类继承测试 {


    public static class A{
        static {
            printStr("父类静态代码块");
        }
        public static String a = printStr("父类的静态变量");

        public String s = printStr("父类成员变量");

        {
            printStr("父类非静态代码块");
        }
        public A(){
            printStr("父类构造方法");
        }
        public static String printStr(String str){
            System.out.println(str);
            return str;
        }

    }

    public static class B extends A {

        public static String b=printStr("子类的静态变量");
        public String st = printStr("子类的非静态变量");

        static {
            printStr("子类的静态块");
        }
        {
            printStr("子类的非静态块");
        }
        public B(){
            printStr("子类的构造方法");
        }

    }


    public static void main(String[] args) {
        new B();
    }


    public static String printStr(String s) {
        System.out.println(s);
        return s;
    }


}
