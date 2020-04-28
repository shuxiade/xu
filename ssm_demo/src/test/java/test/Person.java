package test;

import lombok.Data;

@Data
public class Person{

	private Integer id;
	private String name;
	private Integer age;

	private Double salary;
	
	public Person() {
		
	}
	
	public Person(Integer id,String name) {
		this.id = id;
		this.name = name;
	}
	/*public Person(Integer id,String name,Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}*/
	
	public Double rise(Double d) {
		this.salary = this.salary+d;
		return this.salary;
	}
}
