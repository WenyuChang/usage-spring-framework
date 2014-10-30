package wenyu.learning.AdvancedUsage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.springframework.beans.factory.annotation.Required;

import wenyu.learning.AdvancedUsage.DependencyBeans.IDependencyBean;

public class CustomBeanImpl implements ICustomBean {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	private String getName() {
		return name;
	}
	
	
	private int intValue;
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	private String getIntValue() {
		return Integer.toString(intValue);
	}
	
	//@Autowired
	private IDependencyBean depBean;
	public void setDepBean(IDependencyBean depBean) {
		this.depBean = depBean;
	}
	private String getDepBean() {
		if(depBean != null) {
			return depBean.returnValue();
		} else {
			return IDependencyBean.class.getName() + " (Null)";
		}
	}
	
	
	private List<String> stringList;
	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
	private String getStringList() {
		if(stringList == null) {
			return "List - Null";
		}
		String returnStr = "List - [";
		for(int i=0;i<stringList.size();i++) {
			returnStr += stringList.get(i) + ",";
		}
		returnStr = returnStr.substring(0, returnStr.length()-1) + "]"; 
		return returnStr;
	}
	
	
	private Set<IDependencyBean> depBeanSet;
	public void setDepBeanSet(Set<IDependencyBean> depBeanSet) {
		this.depBeanSet = depBeanSet;
	}
	private String getDepBeanSet() {
		if(depBeanSet == null) {
			return "Set - Null";
		}
		
		Iterator<?> iterator = depBeanSet.iterator();
		String returnStr = "Set - (";
		while(iterator.hasNext()) {
			returnStr += iterator.next() + ",";
		}
		returnStr = returnStr.substring(0, returnStr.length()-1) + ")"; 
		return returnStr;
	}
	
	private Map<Object, Object> map;
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}
	private String getMap() {
		if(map == null) {
			return "Map - Null";
		}
		
		Set<Entry<Object,Object>> entries = map.entrySet();
		String returnStr = "Map - {";
		for(Entry<Object, Object> entry : entries) {
			returnStr += "(" + entry.getKey() + "/" + entry.getValue() + "),";
		}
		returnStr = returnStr.substring(0, returnStr.length()-1) + "}"; 
		return returnStr;
	}
	
	// Properties in spring can only have <String,Sting> set in configuration file
	private Properties prop;
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	private String getProp() {
		if(prop == null) {
			return "Properties - Null";
		}
		
		Set<Entry<Object, Object>> entries = prop.entrySet();
		String returnStr = "Properties - {";
		for(Entry<Object, Object> entry : entries) {
			returnStr += "(" + entry.getKey() + "/" + entry.getValue() + "),";
		}
		returnStr = returnStr.substring(0, returnStr.length()-1) + "}"; 
		return returnStr;
	}
	
	// Autowiring by name
	private IDependencyBean autowiringBean;
	public void setDependencyBean(IDependencyBean autowiringBean) {
		this.autowiringBean = autowiringBean;
	}
	private String getDependencyBean() {
		if(autowiringBean != null) {
			return autowiringBean.returnValue();
		} else {
			return IDependencyBean.class.getName() + " (Null)";
		}
	}
	
	
	
	
	
	public CustomBeanImpl() {
		name = "Meaningless Test";
		intValue = Integer.MIN_VALUE;
		depBean = null;
	}
	
	public CustomBeanImpl(String name, int intValue, IDependencyBean depBean) {
		this.name = name;
		this.intValue = intValue;
		this.depBean = depBean;
	}
	
	public void printValue() {
		System.out.println("======================================================================");
		System.out.println(getName());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getIntValue());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getDepBean());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getStringList());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getDepBeanSet());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getMap());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getProp());
		System.out.println(this.getClass().getName() + " (" + this.hashCode() + "): " + getDependencyBean());
		System.out.println("======================================================================");
	}

}
