package wenyu.learning.AdvancedUsage.DependencyBeans;


public class DependencyBeanCustomInitAndDestroyImpl implements IDependencyBean {
	public String returnValue() {
		return this.getClass().getName() + " (" + this.hashCode() + ")";
	}
	
	@Override
	public String toString() {
		return "DBImpl:" + Integer.toString(this.hashCode());
	}
	

	public static IDependencyBean getInstance() {
		return new DependencyBeanCustomInitAndDestroyImpl() {
			public String returnValue() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
			
			@Override
			public String toString() {
				return "DBImpl from getInstance:" + Integer.toString(this.hashCode());
			}
		};
	}

	public void customInit() {
		System.out.println("********* Custom Initialize Method Invoked ("+ this.hashCode() + ") *********");
	}

	public void customDestroy() {
		System.out.println("********* Custom Destory Method Invoked ("+ this.hashCode() + ") *********");
	}
}
