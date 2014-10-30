package wenyu.learning.AdvancedUsage.DependencyBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Scope("singleton")
@Scope("prototype")
@Component("dependencyBeanAnnotation")
public class DependencyBeanAnnotationImpl implements IDependencyBean {
	private IDependencyBean requiredValueAutowired;
	// If using required, means dependency-check (see bean15).
	// Autowired: when required is true, it will throw exception when no such type is found in the context
	// Qualifier: when there are several beans all has the same type, qualifier can set the specified bean
	@Required
	@Autowired(required=false) //Autowired is by-type
	@Qualifier("dependencyBean")
	public void setRequiredValueAutowired(IDependencyBean requiredValueAutowired) {
		this.requiredValueAutowired = requiredValueAutowired;
	}
	
	private IDependencyBean requiredValueResource;
	@Required
	@Resource(name="dependencyBean") //Resource is by-name
	public void setRequiredValueResource(IDependencyBean requiredValueResource) {
		this.requiredValueResource = requiredValueResource;
	}
	
	
	@Bean(name="requiredValueBeanAnnotated")
	public IDependencyBean getRequiredValueAnnotatedBean() {
		return new DependencyBeanImpl() {
			public String returnValue() {
				return this.getClass().getName() + " (" + this.hashCode() + ") - Annotated Bean";
			}
		};
	}
	
	public String returnValue() {
		return this.getClass().getName() + " (" + this.hashCode() + ") - Annotation (@Autowired:" + requiredValueAutowired + ", @Resource:" + requiredValueResource + ")";
	}
	
	@Override
	public String toString() {
		return "DBImpl:" + Integer.toString(this.hashCode());
	}
	
	@PostConstruct
	public void customInit() {
		System.out.println("********* Custom Initialize Method Invoked ("+ this.hashCode() + ") - Annotated Post Construct*********");
	}

	@PreDestroy
	public void customDestroy() {
		System.out.println("********* Custom Destory Method Invoked ("+ this.hashCode() + ") - Annotated Pre Destroy *********");
	}
}
