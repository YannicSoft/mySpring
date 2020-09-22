package com.yannic.myspring.ioc;

import com.yannic.myspring.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找
 * @author zongyy
 */
public class BeanDependencyInjection {
    public static void main(String[] args) {
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/beanInjection.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        System.out.println(userRepository.getUser());
    }


}
