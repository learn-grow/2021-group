package com.geoup.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lisy
 * @version: ClassLoader , v0.1 2021年01月29日 16:05
 * @remark：ClassLoader
 */
@Slf4j
public class MyClassLoader {

    static final String CLASS_PATH = "**/*.class";

    static final String URL = "classpath*:";

    public static Class<?>[] getClazz(String basePackage, ApplicationContext applicationContext) {
        String locate = URL + basePackage.replaceAll("\\.", "/") + "/" + CLASS_PATH;
        List<Class<?>> result = new ArrayList<Class<?>>();
        try {
            Resource[] resources = applicationContext.getResources(locate);
            for (Resource resource : resources) {
                String path = resource.getURL().getPath().replaceAll("/", "\\.");
                String clazzPath = path.substring(path.indexOf(basePackage), path.length() - 6);
                Class<?> clazz = Class.forName(clazzPath);
                result.add(clazz);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result.toArray(new Class<?>[result.size()]);
    }
}
