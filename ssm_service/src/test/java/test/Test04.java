package test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test04 {

	@org.junit.Test
	public void test01() {
//		Stream<String> words = Stream.generate(()->"aa");
//		System.out.println(words.findFirst());
//		String a = "sdfsdfdsf";
		Object[] obj = Stream.iterate(1.0, p -> p * 2).peek(p -> System.out.println(p)).limit(20).toArray();
//		Optional<Object[]> of = Optional.of(Stream.iterate(1.0, p->p*2).peek(p->System.out.println(p)).limit(20).toArray());

//		Optional<String> op = Optional.empty();
//		System.out.println(op);
		// 字符串比较排序
		Locale locale = Locale.CHINESE;
		Collator collator = Collator.getInstance(locale);
		List<String> list = new ArrayList<>();
		Collections.sort(list, collator);

		// 信息格式化
//		MessageFormat mf = new MessageFormat(pattern, locale);

//		ResourceBundle rb = ResourceBundle.getBundle(baseName,locale);
	}

	@org.junit.Test
	public void test02() {
		try {
			List<String> list = Stream.of("aa", "22", "dd", "ff", "cc", "zz", "yy", "ii", "oo", "hh")
					.collect(Collectors.toList());
			int j = 0;
			int k = 5;
			for (int i = 0; i <= list.size() / 5; i++) {
				if (k > list.size()) {
					k = list.size();
				}
				if (j == k) {
					break;
				}
				System.out.println(list.subList(j, k));
				j = j + 5;
				k = k + 5;
			}
//		System.out.println(10.1-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		
//		Map<String, long[]> LOGIN_COUNTER = new HashMap<String, long[]>();
//		java.util.concurrent.ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(1);
//		for(int i = 0 ; i < 10 ; i++) {
//			LOGIN_COUNTER.put(i+"", new long[] {i,(long) (System.currentTimeMillis()+Math.random()*1000)});
//		}
//		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				e.printStackTrace();
//			}
//		});
//		try {
//			EXECUTOR.scheduleAtFixedRate(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("运行开始");
//					for (Entry set : LOGIN_COUNTER.entrySet()) {
//						long[] arr = (long[]) set.getValue();
//						if (arr[1] < System.currentTimeMillis()) {
//							LOGIN_COUNTER.remove(set.getKey());
//						}
//					}
//					System.out.println("结束运行"+LOGIN_COUNTER.toString());
//				}
//			}, 10, 10, TimeUnit.MILLISECONDS);
//			System.out.println("运行");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
