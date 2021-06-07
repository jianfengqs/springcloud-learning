package com.qs.demo.classloader;

/**
 * 我的类装入器测试
 *
 * @author feishi
 * @date 2021/05/31
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}
