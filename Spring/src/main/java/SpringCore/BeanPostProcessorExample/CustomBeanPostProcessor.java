package SpringCore.BeanPostProcessorExample;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean,String beanName){
     System.out.println("called postProcessBeforeInitialization() for"
                            +":"+beanName);
     return bean;
    }
    public Object postProcessAfterInitialization(Object bean,String beanName){
        System.out.println("called postProcessAfterInitialization() for"
                +":"+beanName);
        return bean;
    }
}
