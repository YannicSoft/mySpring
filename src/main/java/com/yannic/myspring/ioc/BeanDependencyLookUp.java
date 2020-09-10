package com.yannic.myspring.ioc;

import com.yannic.myspring.ioc.annotation.Super;
import com.yannic.myspring.ioc.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 */
public class BeanDependencyLookUp {
    public static void main(String[] args) {
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/beanLookUp.xml");
        lookUpByType(beanFactory);
        lookUpLazy(beanFactory);
        lookUpCollectionType(beanFactory);
        lookUpWithAnnotation(beanFactory);
    }

    /**
     * 延迟查找
     *
     * @param beanFactory
     */
    private static void lookUpLazy(BeanFactory beanFactory) {
        ObjectFactory objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = (User) objectFactory.getObject();
        System.out.println("延迟查找" + user.toString());
    }

    /**
     * 按类型查找
     *
     * @param beanFactory
     */
    public static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user.toString());
    }


    /**
     * bean集合
     *
     * @param beanFactory
     */
    private static void lookUpCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合查找" + userMap);
        }
    }

    /**
     * 注解查找
     * @param beanFactory
     */
    private static void lookUpWithAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Super> superMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("注解查找" + superMap);
        }
    }
}
