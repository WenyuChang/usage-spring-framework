Spring Framework Detail Usage Demo (AOP not included)
===================

Implemented Feature from Spring Frameword: (SpringConfiguration.xml)
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	<bean id="dependencyBean" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" />
	<bean id="dependencyBeanPrototype" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" scope="prototype" />
	<bean id="dependencyBeanFromGetInstance" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanFromGetInstanceImpl" factory-method="getInstance"/>
	<bean id="dependencyBeanCustomInitAndDestory" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanCustomInitAndDestroyImpl" init-method="customInit" destroy-method="customDestroy" />
	<bean id="dependencyBeanInitAndDestory" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanInitAndDestoryImpl" />
	<bean id="dependencyBeanAware" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanAwareImpl" />
	<bean id="returnValueReplacer" class="wenyu.learning.AdvancedUsage.DependencyBeans.MethodReplacers.ReturnValueReplacer" /> 
	<bean id="dependencyBeanMethodReplacer" class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl">
		<replaced-method name="returnValue" replacer="returnValueReplacer" />
	</bean>
	
	
	<bean id="advancedBean1" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean1: value set function" />
		<property name="intValue" value="9" />
		<property name="depBean" ref="dependencyBean" />
	</bean>
	
	<bean id="advancedBean2" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<constructor-arg value="advancedBean2: constructor arguments" />
		<constructor-arg value="99" />
		<constructor-arg ref="dependencyBean" />
	</bean>
	
	<bean id="advancedBean3" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean3: Inner Bean" />
		<property name="depBean" >
			<bean class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" />
		</property>
	</bean>
	
	<bean id="advancedBean4" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean3: Wiring Collection" />
		<property name="stringList">
			<list>
				<value>string1</value>
				<value>string2</value>
				<value>string3</value>
			</list>
		</property>
		<property name="depBeanSet">
			<set>
				<ref bean="dependencyBean" />
				<ref bean="dependencyBean" /> <!-- set cannot have same item, so this item will not be added -->
				<bean class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" />
			</set>
		</property>
		<property name="map">
			<map>
				<entry key="key1" value="value1" />
				<entry key="key2" value-ref="dependencyBean" />
				<entry key-ref="dependencyBean" value="value2" />
				<entry>
					<key><bean class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" /></key>
					<value>value3</value>
				</entry>
				<entry>
					<key><ref bean="dependencyBean" /></key>
					<bean class="wenyu.learning.AdvancedUsage.DependencyBeans.DependencyBeanImpl" />
				</entry>
				<entry>
					<key><null /></key>
					<null />
				</entry>
			</map>
		</property>
		<property name="prop">
			<props>
				<prop key="prop-key1">value1</prop>
				<prop key="prop-key2">value2</prop>
				<prop key="prop-key3">value3</prop>
			</props>
		</property>
	</bean>
	
	<bean id="advancedBean5" class="wenyu.learning.AdvancedUsage.CustomBeanImpl" autowire="byName">
		<property name="name" value="advancedBean5: Autowiring" />
	</bean>
	
	<bean id="advancedBean6" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean6: Bean Scoping" />
		<property name="depBean" ref="dependencyBeanPrototype" />
		<property name="depBeanSet">
			<set>
				<ref bean="dependencyBeanPrototype" />
			</set>
		</property>
	</bean>
	
	<bean id="advancedBean7" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean7: Static Factory Method" />
		<property name="depBean" ref="dependencyBeanFromGetInstance" />
	</bean>
	
	<bean id="advancedBean8" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean8: Custom Method Initialize and Destroy Methods" />
		<property name="depBean" ref="dependencyBeanCustomInitAndDestory" />
	</bean>
	
	<bean id="advancedBean9" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean9: Method Initialize and Destroy Methods" />
		<property name="depBean" ref="dependencyBeanInitAndDestory" />
	</bean>
	
	<bean id="advancedBean" class="wenyu.learning.AdvancedUsage.CustomBeanImpl" abstract="true">
		<property name="name" value="advancedBean10: Advanced - Declaring parent and child beans" />
		<property name="intValue" value="99" />
		<property name="depBean" ref="dependencyBean" />
	</bean>
	
	<bean id="advancedBean10" parent="advancedBean">
		<property name="name" value="advancedBean10: Advanced - Declaring parent and child beans (Override)" />
	</bean>
	
	<bean id="advancedBean11" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean11: Advanced - Method Replacer" />
		<property name="depBean" ref="dependencyBeanMethodReplacer" />
	</bean>
	
	<bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<!-- <property name="location" value="src/main/java/wenyu/learning/AdvancedUsage/customs.properties" /> -->
		<property name="locations">
			<list>
				<value>src/main/java/wenyu/learning/AdvancedUsage/externalPropFiles/customs.properties</value>
				<value>src/main/java/wenyu/learning/AdvancedUsage/externalPropFiles/customs.aux.properties</value>
			</list>
		</property>
	</bean>
	<bean id="advancedBean12" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="${customs.name}" />
		<property name="intValue" value="${customs.intvalue}" />
	</bean>
	
	<bean id="advancedBean13" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean13: Advanced - Making beans aware" />
		<property name="depBean" ref="dependencyBeanAware" />
	</bean>
	
	<bean id="advancedBean15" class="wenyu.learning.AdvancedUsage.CustomBeanImpl" dependency-check="simple">
		<!-- Dependency-check type: none, simple, object, all -->
		<property name="name" value="advancedBean15: Advanced - Dependency Check" />
		<property name="intValue" value="99" />
	</bean>
	
	<context:annotation-config />
	<context:component-scan base-package="wenyu.learning.AdvancedUsage.DependencyBeans" />
	<bean id="advancedBean16" class="wenyu.learning.AdvancedUsage.CustomBeanImpl">
		<property name="name" value="advancedBean16: Advanced - Annotation" />
		<property name="depBean" ref="dependencyBeanAnnotation" />
		<property name="depBeanSet">
			<set>
				<ref bean="dependencyBeanAnnotation" />
			</set>
		</property>
	</bean>
</beans>
```

