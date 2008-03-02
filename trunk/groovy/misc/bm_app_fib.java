// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   bm_app_fib.groovy

import groovy.lang.*;
import java.io.File;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;

public class bm_app_fib extends Script
{

    public bm_app_fib()
    {
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
    }

    public bm_app_fib(Binding context)
    {
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
        ScriptBytecodeAdapter.invokeMethodOnSuperN(groovy.lang.Script.class, this, "setBinding", new Object[] {
            context
        });
    }

    public static void main(String args[])
    {
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
        ScriptBytecodeAdapter.invokeMethodN(class1, org.codehaus.groovy.runtime.InvokerHelper.class, "runScript", new Object[] {
            class1, args
        });
    }

    public Object run()
    {
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(class1, (GroovyObject)ScriptBytecodeAdapter.castToType(this, groovy.lang.GroovyObject.class), "println", new Object[] {
            ScriptBytecodeAdapter.invokeMethodOnCurrentN(class1, (GroovyObject)ScriptBytecodeAdapter.castToType(this, groovy.lang.GroovyObject.class), "fib", new Object[] {
                new Integer(34)
            })
        });
    }

    public Object fib(Object n)
    {
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
        if(ScriptBytecodeAdapter.compareLessThan(n, new Integer(3)))
            return new Integer(1);
        else
            return ScriptBytecodeAdapter.invokeMethodN(class1, 
              ScriptBytecodeAdapter.invokeMethodOnCurrentN(class1, 
                (GroovyObject)ScriptBytecodeAdapter.castToType(this, groovy.lang.GroovyObject.class), 
                "fib", 
                new Object[] {
                  ScriptBytecodeAdapter.invokeMethodN(class1, n, "minus", new Object[] {new Integer(1)})
                }), 
              "plus", 
              new Object[] {
                ScriptBytecodeAdapter.invokeMethodOnCurrentN(class1, 
                  (GroovyObject)ScriptBytecodeAdapter.castToType(this, groovy.lang.GroovyObject.class), 
                  "fib", 
                  new Object[] {
                    ScriptBytecodeAdapter.invokeMethodN(class1, n, "minus", new Object[] {new Integer(2)
                  })
              })
            });
    }

    Object super$3$getProperty(String s)
    {
        return super.getProperty(s);
    }

    String super$1$toString()
    {
        return super.toString();
    }

    void super$3$setProperty(String s, Object obj)
    {
        super.setProperty(s, obj);
    }

    void super$1$notify()
    {
        super.notify();
    }

    void super$3$println()
    {
        super.println();
    }

    void super$1$notifyAll()
    {
        super.notifyAll();
    }

    void super$3$print(Object obj)
    {
        super.print(obj);
    }

    Object super$1$clone()
    {
        return super.clone();
    }

    Object super$3$evaluate(String s)
    {
        return super.evaluate(s);
    }

    void super$1$wait()
    {
        super.wait();
    }

    MetaClass super$2$getMetaClass()
    {
        return super.getMetaClass();
    }

    void super$1$wait(long l, int i)
    {
        super.wait(l, i);
    }

    void super$2$setMetaClass(MetaClass metaclass)
    {
        super.setMetaClass(metaclass);
    }

    Class super$1$getClass()
    {
        return super.getClass();
    }

    Binding super$3$getBinding()
    {
        return super.getBinding();
    }

    void super$1$finalize()
    {
        super.finalize();
    }

    void super$3$setBinding(Binding binding)
    {
        super.setBinding(binding);
    }

    void super$1$wait(long l)
    {
        super.wait(l);
    }

    void super$3$run(File file, String as[])
    {
        super.run(file, as);
    }

    void super$3$println(Object obj)
    {
        super.println(obj);
    }

    boolean super$1$equals(Object obj)
    {
        return super.equals(obj);
    }

    Object super$3$invokeMethod(String s, Object obj)
    {
        return super.invokeMethod(s, obj);
    }

    int super$1$hashCode()
    {
        return super.hashCode();
    }

    public static Long __timeStamp;

    static 
    {
        Long long1;
        Long long2;
        Class class1 = bm_app_fib.class;
        Class class2 = groovy.lang.MetaClass.class;
        long1 = new Long(0x1151a7c9b1dL);
        Long _tmp = long1;
        __timeStamp = (Long)long1;
        long2 = new Long(0x1151a7c9b1dL);
        Long _tmp1 = long2;
        __timeStamp = (Long)long2;
    }
}
