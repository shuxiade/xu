package test;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Student extends Person {

	private Integer age;
	
	private LocalDate birthDate = LocalDate.now();
	
	public Student() {
	}
	
	public Student(Integer id,String name,Integer age) {
		System.out.println("子类初始化开始");
		this.age = age;
		System.out.println(this.age);
		super.setAge(2);
	}

	public void test() {
		System.out.println(getClass());
	}
}
