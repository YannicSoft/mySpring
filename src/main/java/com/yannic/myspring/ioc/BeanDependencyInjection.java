package com.yannic.myspring.ioc;

import com.yannic.myspring.ioc.annotation.Super;
import com.yannic.myspring.ioc.model.User;
import com.yannic.myspring.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 */
public class BeanDependencyInjection {
    public static void main(String[] args) {
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/beanInjection.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository.getUsers());
    }


}
