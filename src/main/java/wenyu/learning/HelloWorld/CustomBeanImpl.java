package wenyu.learning.HelloWorld;

public class CustomBeanImpl implements ICustomBean {
	private String value;
	private IDependencyBean depBean;

	public void setDepBean(IDependencyBean depBean) {
		this.depBean = depBean;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CustomBeanImpl() {
		value = "Default";
	}
	
	public CustomBeanImpl(String value, IDependencyBean depBean) {
		this.value = value;
		this.depBean = depBean;
	}
	
	public void printValue() {
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + value);
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + depBean.returnValue());
	}

}
