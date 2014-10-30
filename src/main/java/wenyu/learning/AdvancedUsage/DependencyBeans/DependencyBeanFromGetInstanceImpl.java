package wenyu.learning.AdvancedUsage.DependencyBeans;

public class DependencyBeanFromGetInstanceImpl implements IDependencyBean {
	public String returnValue() {
		return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
	}
	
	@Override
	public String toString() {
		return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
	}
	

	public static IDependencyBean getInstance() {
		return new DependencyBeanFromGetInstanceImpl();
	}
}
