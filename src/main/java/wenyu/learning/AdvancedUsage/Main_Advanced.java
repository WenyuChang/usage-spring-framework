package wenyu.learning.AdvancedUsage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import wenyu.learning.AdvancedUsage.DependencyBeans.IDependencyBean;

public class Main_Advanced {
	private static final String configPath = "src/main/java/wenyu/learning/AdvancedUsage/SpringConfiguration.xml";

	private static void usingApplicationContext() {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(configPath);
		
		// value set function
		ICustomBean bean1 = (ICustomBean) context.getBean("advancedBean1");
		bean1.printValue();
		
		// constructor arguments
		ICustomBean bean2 = (ICustomBean) context.getBean("advancedBean2");
		bean2.printValue();
		
		// Inner Bean
		ICustomBean bean3 = (ICustomBean) context.getBean("advancedBean3");
		bean3.printValue();
		
		// Wiring Collection
		ICustomBean bean4 = (ICustomBean) context.getBean("advancedBean4");
		bean4.printValue();
		
		// Auto Wiring
		ICustomBean bean5 = (ICustomBean) context.getBean("advancedBean5");
		bean5.printValue();
		
		// Bean Scoping
		ICustomBean bean6 = (ICustomBean) context.getBean("advancedBean6");
		bean6.printValue();
		
		// Static Factory Method
		ICustomBean bean7 = (ICustomBean) context.getBean("advancedBean7");
		bean7.printValue();
		
		// Custom Method Initialize and Destroy Methods
		ICustomBean bean8 = (ICustomBean) context.getBean("advancedBean8");
		bean8.printValue();
		
		// Method Initialize and Destroy Methods through implements common interface
		ICustomBean bean9 = (ICustomBean) context.getBean("advancedBean9");
		bean9.printValue();
		
		// Advanced - Declaring parent and child beans (Override Value)
		ICustomBean bean10 = (ICustomBean) context.getBean("advancedBean10");
		bean10.printValue();
		
		// Advanced - Method Replacer
		ICustomBean bean11 = (ICustomBean) context.getBean("advancedBean11");
		bean11.printValue();
		
		// Advanced - Externalizing configuration properties
		ICustomBean bean12 = (ICustomBean) context.getBean("advancedBean12");
		bean12.printValue();
		
		// Advanced - Advanced - Making beans aware
		ICustomBean bean13 = (ICustomBean) context.getBean("advancedBean13");
		bean13.printValue();
		
		// Advanced - Dependency Check
		ICustomBean bean15 = (ICustomBean) context.getBean("advancedBean15");
		bean15.printValue();
		
		// Advanced - Advanced - Annotation
		ICustomBean bean16 = (ICustomBean) context.getBean("advancedBean16");
		bean16.printValue();
		IDependencyBean bean17 = (IDependencyBean) context.getBean("requiredValueBeanAnnotated");
		System.out.println(bean17.returnValue());
	}
	
	private static void demoEntry() {
		usingApplicationContext();
	}
	
	public static void main(String[] args) {
		demoEntry();
	}

}
