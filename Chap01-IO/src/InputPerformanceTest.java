import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 입출력 속도 비교: 입력 비교 (Scanner vs. BufferedReader)
 * 문자열 split의 경우: split(" ") vs. split("\\s") 
 * - 전자를 사용해야 더 빠름. 후자는 모든 공백문자를 이용하기 때문
 * 프로그래밍 경시대회 문제를 자바로 해결할 때 createRandomData에
 * 있는 출력방법과 test03~test05에 있는 입력방법을 활용하면
 * 입출력 속도를 향상시킬 수 있음
 * 1장에서 이해해야 하는 내용은 아님 
 */
public class InputPerformanceTest {

	public static long createRandomData01() {
		long startTime = 0, stopTime = 0;
		try(
			PrintWriter outfile = new PrintWriter("test.txt");
		){
			outfile.println(10000);
			int[] outData = new int[10000];
			for(int i=0; i<10000; ++i)
				outData[i] = ThreadLocalRandom.current().nextInt(100);
			startTime = System.nanoTime();
			outfile.println(outData[0]);
			for(int i=1; i<10000; ++i)
				outfile.print(" "+outData[i]);
			outfile.println();
			stopTime = System.nanoTime();			
		}
		catch(Exception e) {}
		return stopTime-startTime;
	}
	public static long createRandomData02() {
		long startTime = 0, stopTime = 0;
		try(
			PrintWriter outfile = new PrintWriter("test.txt");
		){
			outfile.println(10000);
			int[] outData = new int[10000];
			for(int i=0; i<10000; ++i)
				outData[i] = ThreadLocalRandom.current().nextInt(100);
			startTime = System.nanoTime();
			String[] data = IntStream.of(outData).boxed().map(x->x.toString()).toArray(String[]::new);
			outfile.println(String.join(" ", data));		
			stopTime = System.nanoTime();
		}
		catch(Exception e) {}
		return stopTime-startTime;
	}
	public static long createRandomData03() {
		long startTime = 0, stopTime = 0;
		try(
			PrintWriter outfile = new PrintWriter("test.txt");
		){
			outfile.println(10000);
			int[] outData = new int[10000];
			for(int i=0; i<10000; ++i)
				outData[i] = ThreadLocalRandom.current().nextInt(100);
			startTime = System.nanoTime();
			outfile.println(IntStream.of(outData).boxed()
				.map(x->x.toString()).collect(Collectors.joining(" ")));
			stopTime = System.nanoTime();		
		}
		catch(Exception e) {}
		return stopTime-startTime;
	}
	public static long createRandomData04() {
		long startTime = 0, stopTime = 0;
		try(
			BufferedWriter outfile = new BufferedWriter(new FileWriter("test.txt"));
		){
			outfile.write(String.valueOf(10000));
			outfile.newLine();
			int[] outData = new int[10000];
			for(int i=0; i<10000; ++i)
				outData[i] = ThreadLocalRandom.current().nextInt(100);
			startTime = System.nanoTime();
			outfile.write(IntStream.of(outData).boxed()
				.map(x->x.toString()).collect(Collectors.joining(" ")));
			outfile.newLine();
			stopTime = System.nanoTime();		
		}
		catch(Exception e) {}
		return stopTime-startTime;
	}
	// System.out.println("Using Scanner: call nextInt N times");
	public static long test01() {
		long startTime = 0, stopTime = 0;
		try(
			Scanner infile = new Scanner(new File("test.txt"));
		){
			startTime = System.nanoTime();
			int N = infile.nextInt();
			int[] nums = new int[N];
			for(int i=0; i<N; ++i) {
				nums[i] = infile.nextInt();
			}
			stopTime = System.nanoTime();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stopTime - startTime;
	}
	// System.out.println("Using Scanner: using nextLine + split");
	public static long test02() {
		long startTime = 0, stopTime = 0;
		try(
			Scanner infile = new Scanner(new File("test.txt"));
		){
			startTime = System.nanoTime();
			int N = infile.nextInt();
			infile.nextLine();
			int[] nums = new int[N];
			String[] tmp = infile.nextLine().split(" "); 
			for(int i=0; i<N; ++i) {
				nums[i] = Integer.parseInt(tmp[i]);
			}
			stopTime = System.nanoTime();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stopTime - startTime;
	}
	// System.out.println("Using BufferedReader: using readLine + split");
	public static long test03() {
		long startTime = 0, stopTime = 0;
		try(
			BufferedReader infile = new BufferedReader(new FileReader("test.txt"));
		){
			startTime = System.nanoTime();
			int N = Integer.parseInt(infile.readLine());
			int[] nums = new int[N];
			String[] tmp = infile.readLine().split(" "); 
			for(int i=0; i<N; ++i) {
				nums[i] = Integer.parseInt(tmp[i]);
			}
			stopTime = System.nanoTime();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stopTime - startTime;
	}
	// System.out.println("Using BufferedReader: using readLine + StringTokenizer");
	public static long test04() {
		long startTime = 0, stopTime = 0;
		try(
			BufferedReader infile = new BufferedReader(new FileReader("test.txt"));
		){
			startTime = System.nanoTime();
			int N = Integer.parseInt(infile.readLine());
			int[] nums = new int[N];
			StringTokenizer tokenizer = new StringTokenizer(infile.readLine()); 
			for(int i=0; i<N; ++i) {
				nums[i] = Integer.parseInt(tokenizer.nextToken());
			}
			stopTime = System.nanoTime();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stopTime - startTime;
	}
	// System.out.println("Using BufferedReader: using readLine + stream");
	public static long test05() {
		long startTime = 0, stopTime = 0;
		try(
			BufferedReader infile = new BufferedReader(new FileReader("test.txt"));
		){
			startTime = System.nanoTime();
			infile.readLine();
			int[] nums = Arrays.stream(infile.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			stopTime = System.nanoTime();
			nums[0] = nums[0]; // warning 제거용
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stopTime - startTime;
	}
	
	public static void main(String[] args) {
		long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
		for(int i=0; i<100; ++i) {
			sum1 += createRandomData01();
			sum2 += createRandomData02();
			sum3 += createRandomData03();
			sum4 += createRandomData03();
		}
		System.out.println("Using PrintWriter: call print N times");
		System.out.printf("평균: %.2f%n", sum1/100.0);
		System.out.println("Using PrintWriter: using stream + String join");
		System.out.printf("평균: %.2f%n", sum2/100.0);
		System.out.println("Using PrintWriter: using stream + collect joining");
		System.out.printf("평균: %.2f%n", sum3/100.0);
		System.out.println("Using BufferedWriter: using stream + collect joining");
		System.out.printf("평균: %.2f%n", sum3/100.0);
		sum1 = sum2 = sum3 = sum4 = sum5 = 0;
		for(int i=0; i<100; ++i) {
			sum1 += test01();
			sum2 += test02();
			sum3 += test03();
			sum4 += test04();
			sum5 += test05();
		}
		System.out.println("Using Scanner: call nextInt N times");
		System.out.printf("평균: %.2f%n", sum1/100.0);
		System.out.println("Using Scanner: using nextLine + split");
		System.out.printf("평균: %.2f%n", sum2/100.0);
		System.out.println("Using BufferedReader: using readLine + split");
		System.out.printf("평균: %.2f%n", sum3/100.0);
		System.out.println("Using BufferedReader: using readLine + StringTokenizer");
		System.out.printf("평균: %.2f%n", sum4/100.0);
		System.out.println("Using BufferedReader: using readLine + stream");
		System.out.printf("평균: %.2f%n", sum5/100.0);
	}

}
