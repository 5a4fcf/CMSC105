import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * ang invalid inputs ug 20% default wa gipangimplement 
 * wa pa sad ang type sa arraylist if ever character ra sya or number ang type chuchu
 */

public class Sampling {
	

	public static void srs(int N){
		ArrayList sframe = frame(N);
		System.out.println("Input sample size:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if(n>=N && n<=1){
			System.out.println("Invalid input");
		}else{
			Random r = new Random();
			System.out.println("Result:");
			while(n!=0){
				System.out.println(sframe.get(r.nextInt(sframe.size())));
				n--;
			}
		}
	}
//	public static void ss(int N){
//		System.out.println("srs");
//		ArrayList sframe = frame(N);
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		if(n>=N && n<=1){
//			System.out.println("Invalid input");
//		}else{
//			int k = N/n;
//			Random r = new Random();
//			int sp = (int)(sframe.get(r.nextInt(sframe.size())));		//int pani akong pag accept
//		}
//		
//	}
	public static void sts(){
		System.out.println("srs");
	}
	
	public static ArrayList frame(int N){
		ArrayList frame = new ArrayList();
		Scanner sn = new Scanner(System.in);
		for(int i = 0 ; i!= N ; i ++){
			System.out.println("Index " + (i+1));
			frame.add(sn.nextInt());
		}
		return frame;
	}
	public static void main(String[] args){
		
		System.out.println("Basic Sampling Methods:");
		System.out.println("1. Simple Random Sampling\n2. Systematic Sampling\n3. Stratified Sampling\n4. Quit");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch(ch){
			case 1:
				System.out.println("Enter population size:");
				srs(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter population size:");
				//ss(sc.nextInt());
				break;
			case 3:
				sts();
				break;
			case 4:
				break;
			default:
				break;
			
		}
		
	}
}