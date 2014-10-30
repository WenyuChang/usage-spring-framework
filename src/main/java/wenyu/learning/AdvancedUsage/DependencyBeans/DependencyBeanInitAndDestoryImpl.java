package wenyu.learning.AdvancedUsage.DependencyBeans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DependencyBeanInitAndDestoryImpl implements IDependencyBean, InitializingBean, DisposableBean {
	public String returnValue() {
		return this.getClass().getName() + " (" + this.hashCode() + ")";
	}
	
	@Override
	public String toString() {
		return "DBImpl:" + Integer.toString(this.hashCode());
	}
	

	public static IDependencyBean getInstance() {
		return new DependencyBeanInitAndDestoryImpl() {
			public String returnValue() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
			
			@Override
			public String toString() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
		};
	}

	// From InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println("********* afterPropertiesSet Method from InitializingBean Invoked ("+ this.hashCode() + ") *********");
	}
	
	// From DisposableBean
	public void destroy() throws Exception {
		System.out.println("********* destroy Method from DisposableBean Invoked ("+ this.hashCode() + ") *********");
	}


}
