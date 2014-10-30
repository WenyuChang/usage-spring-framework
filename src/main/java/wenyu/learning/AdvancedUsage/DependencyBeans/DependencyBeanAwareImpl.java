package wenyu.learning.AdvancedUsage.DependencyBeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DependencyBeanAwareImpl implements IDependencyBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
	private String beanName;
	private ApplicationContext context;
	private BeanFactory beanfactory;
	
	public String returnValue() {
		return this.getClass().getName() + " (" + beanName + ") in the Context (" + context.getDisplayName() + ") and created by bean factory (" + beanfactory.hashCode() + ")";
	}
	
	@Override
	public String toString() {
		return "DBImpl:" + Integer.toString(this.hashCode());
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanfactory = beanFactory;
	}
}
