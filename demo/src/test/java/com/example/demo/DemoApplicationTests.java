package com.example.demo;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Dao.IUserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	IUserDao userDao;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void test01() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
	}

	@Test
	public void test02() {
		new Runnable() {
			public void run() {
				System.out.println("test02");
			}
		};
		Runnable r = () -> System.out.println("test01");
	}

	@Test
	public void test03() {
		List list2 = Arrays.asList("a", "b", "c", "d");
		list2.forEach(n -> System.out.println(n));
//		list2.forEach(System.out::println);
	}

	@Test
	public void test04() {
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		Stream d = cost.stream().map(x -> x + x * 0.05);
		System.out.println(d);
		cost.forEach(System.out::println);
	}

	@Test
	public void test05() {
		List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
		System.out.println("Language starts with J: ");
		filter(languages, x -> x.startsWith("J"));
		System.out.println("\nLanguage ends with a: ");
		filter(languages, x -> x.endsWith("a"));
		System.out.println("\nAll languages: ");
		filter(languages, x -> true);
		System.out.println("\nNo languages: ");
		filter(languages, x -> false);
		System.out.println("\nLanguage length bigger three: ");
		filter(languages, x -> x.length() > 4);
	}

	public void filter(List<String> languages, Predicate<String> condition) {
		languages.stream().filter(x -> condition.test(x)).collect(Collectors.toList());
	}

	public static void summingTest(List<String> list) {
		int i = list.stream().limit(3).collect(Collectors.summingInt(Integer::valueOf));
//		long l = 
		list.stream().filter(x -> (x.length() > 3)).forEach(System.out::println);
//				limit(3).
		double d = list.stream().limit(3).collect(Collectors.summingDouble(Double::valueOf));
//		System.out.println(i + "\n" + l + "\n" + d);
	}

	@Test
	public void test06() {
		List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
		summingTest(list);
	}

	@Test
	public void test07() {
		List<String> list = Arrays.asList("123", "456", "789", "1101", "212121121", "asdaa", "3e3e3e", "2321eew");
		Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(x -> x.length()));
//        System.out.println(collect.size());
		collect.forEach((Integer a, List<String> b) -> {
			System.out.println(a);
			b.forEach(c -> System.out.println(c));
			System.out.println("~~~~~~");
		});
	}

	@Test
	public void test08() {
		check(true, "test", "a", "c");
	}

	public void check(boolean b, String message, Object... args) {

		System.out.println(b + message);
		System.out.println(args == null || args.length == 0);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

	@Test
	public void test09() {
		List<Double> list = new ArrayList<Double>();
		list.add(1.1);
		list.add(5.1);
		list.add(3.1);
		list.add(7.1);
		list.add(1.1);
		list.add(null);

		Collections.sort(list, new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return 0;
				}
				return Double.compare(o1, o2);
			}
		});

		List<Double> list2 = new ArrayList<>(list);

		Collections.sort(list2, new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return 0;
				}
				return Double.compare(o2, o1);
			}
		});

		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(Arrays.toString(list2.toArray()));
	}

	/*@Test
	public void test10() {
		List<User> list = new ArrayList<User>();
		list.add(new User(null));
		list.add(new User(1.1));
		list.add(new User(5.1));
		list.add(new User(3.1));
		list.add(new User(7.1));
		list.add(new User(1.1));
		list.add(new User(null));

		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if (o1.getNumber() == null) {
					return (o2.getNumber() == null) ? 0 : -1;
				}
				if (o2.getNumber() == null) {
					return 1;
				}
				return Double.compare(o1.getNumber(), o2.getNumber());
			}
		});

		List<User> list2 = new ArrayList<>(list);

		Collections.sort(list2, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if (o1.getNumber() == null || o2.getNumber() == null) {
					return 1;
				}
//				if(o2.getNumber()==null) {
//					return 0;
//				}
				return Double.compare(o2.getNumber(), o1.getNumber());
			}
		});

		list.forEach(user -> {
			System.out.println(user.getNumber());
		});
//		list2.forEach(user->{
//			System.out.println(user.getNumber());
//		});
//		System.out.println(Arrays.toString(list.toArray()));
//		System.out.println(Arrays.toString(list2.toArray()));
	}*/
	
	@Test
	public void test11() {
		Double a = 1d;
		Double b = 1d;
		System.out.println(Double.compare(a, b));
		System.out.println(a == b);
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void test12() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		List<Integer> temp = list.size()>10?list.subList(0, 10):list;
		System.out.println(Arrays.toString(temp.toArray()));
	}
	
	@Test
	public void test13() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(1);
		list.add(9);
		list.add(2);
		list.add(8);
		list.add(5);
		list.add(null);
		
		Collections.sort(list,(a,b)->{
			if(a==null){
				return -1;
			}else if(a>b) {
				return 1;
			}else if(a<b) {
				return -1;
			}else{
				return 0;
			}
		});
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	
	@Test
	public void test14() {
		DecimalFormat thousand = new DecimalFormat("##,###,###,###.00");
		thousand.setNegativePrefix("0");
		System.out.println(thousand.format(0.55313));
	}
	
	@Test
	public void test15() {
		String reg = "\\\\.*\\.";
		Pattern patt = Pattern.compile(reg);
		
//		String line = "\\\"\\\r";
//		String line = "\\\\\\\"\\\\\\r";
		String line = "\\\\\\/";
		System.out.println(reg);
		Matcher m = patt.matcher(line);
		System.out.println(line);
		System.out.println(m.groupCount());
//		boolean f = Pattern.matches(reg, "\\\\.asdasdasd\bb\b\\");
//		System.out.println(f);
	}
	
	@Test
	public void test16() {
		String reg = ".+(\\\\)+";
		Pattern patt = Pattern.compile(reg);
		
		String line = "abc123\\\\\\\\\\\\\\\\\\\\\\\\";
		Matcher m = patt.matcher(line);
		System.out.println(reg);
		System.out.println(line);
		
		System.out.println(m.matches());
		System.out.println(m.group(1));
	}
}
