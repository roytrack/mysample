package com.roytrack.jvm;
import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;
/**
 * Created by ruanchangming on 2015/8/13.
 */
public class InvokeDynamicDemo {
    public static void testMethod(String s){
        System.out.println("hello string :"+s);
    }
    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup,String name,MethodType mt) throws NoSuchMethodException, IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicDemo.class,name,mt));
    }
    private static MethodType MT_BootstrapMethod(){
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)" +
                "Ljava/lang/invoke/CallSite",null);
    }
    private static MethodHandle MH_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException {
        return lookup().findStatic(InvokeDynamicDemo.class,"BootstrapMethod",MT_BootstrapMethod());
    }
    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs=(CallSite)MH_BootstrapMethod().invokeWithArguments(lookup(),"testMethod",MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",null));
        return cs.dynamicInvoker();
    }

    public static void main(String[] args) throws Throwable{
        INDY_BootstrapMethod().invokeExact("roytrack");
    }

}
