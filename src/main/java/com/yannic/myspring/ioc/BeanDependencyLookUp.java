package com.yannic.myspring.ioc;

import com.yannic.myspring.ioc.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找
 */
public class BeanDependencyLookUp {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:beanLookUp.xml");
        lookUpByName(beanFactory);
    }
    public static void lookUpByName(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println(user.toString());

    }
}
