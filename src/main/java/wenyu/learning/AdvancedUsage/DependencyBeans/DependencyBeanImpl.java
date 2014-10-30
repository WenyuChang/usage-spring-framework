package wenyu.learning.AdvancedUsage.DependencyBeans;

public class DependencyBeanImpl implements IDependencyBean {
	public String returnValue() {
		return this.getClass().getName() + " (" + this.hashCode() + ")";
	}
	
	@Override
	public String toString() {
		return "DBImpl:" + Integer.toString(this.hashCode());
	}
	

	public static IDependencyBean getInstance() {
		return new DependencyBeanImpl() {
			public String returnValue() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
			
			@Override
			public String toString() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
		};
	}
}
