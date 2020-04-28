package test;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {

	private static Logger LOGGER = LoggerFactory.getLogger(Test.class);
	@org.junit.Test
	public void test01() throws ParseException{
		Date now = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(now.getTime());
		System.out.println(sdf.format(new Date(now.getTime()-1000*60*60*7)));
		
	}
	
	@org.junit.Test
	public void test02() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String in = scanner.next();
			System.out.println(in);
			if(in.equals("exit")) {
				break;
			}
		}
	}
	
	/**
	 * 必须命令行操作
	 */
	@org.junit.Test
	public void test03() {
		Console console = System.console();
		String username = console.readLine("username:");
		char[] passwd = console.readPassword("Password:");
		System.out.println("username:"+username);
		System.out.println("Password:"+passwd.toString());
	}
	
	@org.junit.Test
	public void test04() {
		System.out.printf("%1$s %2$tB %2$te, %2$tY \n", "Due date:", new Date());
		System.out.printf("%s %tB %<te, %<tY", "Due date:", new Date());
	}
	
	@org.junit.Test
	public void test05() {
		try {
//			Scanner sc = new Scanner(Paths.get("F:\\test.txt"),"UTF-8");
			Scanner sc = new Scanner(Paths.get("系统用户(1).xls"),"UTF-8");
			List<String> strList = new ArrayList<>();
			while(sc.hasNextLine()) {
				strList.add(sc.nextLine());
			}
			System.out.println(strList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void test06() {
		try {
//			Scanner sc = new Scanner(Paths.get("F:\\test.txt"),"UTF-8");
			PrintWriter pr = new PrintWriter("F:\\test.txt","UTF-8");
//			List<String> strList = new ArrayList<>();
//			while(sc.hasNextLine()) {
//				strList.add(sc.nextLine());
//			}
//			System.out.println(strList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void test07() {
		Person person = new Student(1, "w", 1);
		System.out.println(person.getClass().getName());
		Field[] a = person.getClass().getDeclaredFields();
		
	/*	for(int i = 0 ; i < a.length; i ++) {
			System.out.println(a[i].getName());
		}*/
		Student[] students = new Student[100];
		System.out.println(students.getClass().getName());
		Person[] persons = students;
		persons[0] = new Person(1, "asd");
		System.out.println(students.getClass().getName());
		
	}
	
	@org.junit.Test
	public void test08() {
		System.out.println(System.currentTimeMillis());
		Person t = new Student();
		t.setAge(14);
		System.out.println(t.toString()+"++"+t.getClass());
	}
	
	
	@org.junit.Test
	public void test09() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size=" + size);
		System.out.println("abbreviation=" + size.getAbbreviation() + " male\n" + size.getMale());
		if (size == Size.EXTRA_LARGE)
			System.out.println("Good job you paid attention to the");
	}
	
	@org.junit.Test
	public void test10() {
		int[] a = {1,2,3};
		a = (int[])goodCopyOf(a,10);
		System.out.println(Arrays.toString(a));
		String[] b = {"Tom","Dick","Harry"};
		b = (String[])goodCopyOf(b,10);
		System.out.println(Arrays.toString(b));
		System.out.println("The following call will generate an exception .");
		b = (String[])badCopyOf(b,10);
	}
	
	private Object[] badCopyOf(Object[] a, int newLength) {
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}
	
	private Object goodCopyOf(Object a,int newLength) {
		Class cl = a.getClass();
		if(!cl.isArray()) {
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray,0, Math.min(length, newLength));
		return newArray;
	}
	
	/*@org.junit.Test
	public void test11() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Person p = new Person();
		p.setSalary(20.0);
		Method m1 = Person.class.getMethod("rise", Double.class);
		System.out.println(m1);
		try {
			String n = (String) m1.invoke(p,null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@org.junit.Test
	public void test12() {
//		Any any = new Human();
//		Method[] m = any.getClass().getDeclaredMethods();
		Method[] m = Any.class.getDeclaredMethods();
		for(int i = 0 ; i < m.length ; i ++) {
			System.out.println(Modifier.isAbstract(m[i].getModifiers()));
		}
	}
	
	@org.junit.Test
	public void test13() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(1000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program");
	}
	
	class TimePrinter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("At the tone , the time is " + new Date());
			Toolkit.getDefaultToolkit().beep();
		}
		
	}
	
	@org.junit.Test
	public void test14() {
		List<Integer> strList = new ArrayList<>();
		for(int i = 0 ; i < 10 ; i++) {
			Integer tem = (int) (Math.random()*100);
			strList.add(tem);
		}
		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
		
	}
}
