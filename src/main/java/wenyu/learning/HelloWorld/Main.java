package wenyu.learning.HelloWorld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class Main {
	private static final String configPath = "src/main/java/wenyu/learning/HelloWorld/SpringConfiguration.xml";
	
	private static void usingBeanFactory() {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(configPath));
		
		ICustomBean bean1 = (ICustomBean) factory.getBean("HelloWorld1");
		bean1.printValue();
		
		ICustomBean bean2 = (ICustomBean) factory.getBean("HelloWorld2");
		bean2.printValue();
	}
	
	/**
	 * Why ApplicationContexts is perferred over BeanFactory
	 * 
	 * ■ Application contexts provide a means for resolving text messages, including
	 *   support for internationalization (I18N) of those messages.
	 * ■ Application contexts provide a generic way to load file resources, such as images.
	 * ■ Application contexts can publish events to beans that are registered as listeners.
	 */
	private static void usingApplicationContext() {
		ApplicationContext context = new FileSystemXmlApplicationContext(configPath);
		
		ICustomBean bean1 = (ICustomBean) context.getBean("HelloWorld1");
		bean1.printValue();
		
		ICustomBean bean2 = (ICustomBean) context.getBean("HelloWorld2");
		bean2.printValue();
		
		if(context instanceof FileSystemXmlApplicationContext) {
			((FileSystemXmlApplicationContext) context).close();
		}
	}
	
	private static void demoEntry() {
		usingBeanFactory();
		
		usingApplicationContext();
	}
	
	public static void main(String[] args) {
		demoEntry();
	}

}
