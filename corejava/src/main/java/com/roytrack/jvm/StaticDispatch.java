package com.roytrack.jvm;

/**
 * 关于java的多态中的静态分派 Method Overload Resolution
 * <p>
 * Created by roytrack on 2015/8/12.
 */
public class StaticDispatch {

  public static void main(String[] args) {
    HuMan a = new Woman();
    HuMan b = new Man();
    StaticDispatch sd = new StaticDispatch();
    sd.sayHello(a);
    sd.sayHello(b);
  }

  public void sayHello(HuMan man) {
    System.out.println("hello human");
  }

  public void sayHello(Woman man) {
    System.out.println("hello woman");
  }

  public void sayHello(Man man) {
    System.out.println("hello man");
  }

  static abstract class HuMan {

  }

  static class Woman extends HuMan {

  }

  static class Man extends HuMan {

  }


}

//外部类也是输出human
//abstract class HuMan{
//
//}
//
//class Woman extends HuMan{
//
//}
//
//class  Man extends HuMan{
//
//}
