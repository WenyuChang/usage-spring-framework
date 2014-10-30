package wenyu.learning.AdvancedUsage.DependencyBeans.MethodReplacers;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class ReturnValueReplacer implements MethodReplacer {

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		return obj.getClass().getName() + " (" + this.hashCode() + ") (Method replaced)";
	}

}
