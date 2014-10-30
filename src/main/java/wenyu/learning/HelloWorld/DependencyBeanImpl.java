package wenyu.learning.HelloWorld;

public class DependencyBeanImpl implements IDependencyBean {
	public String returnValue() {
		return this.getClass().getName() + " (" + this.hashCode() + "): ";
	}
}
