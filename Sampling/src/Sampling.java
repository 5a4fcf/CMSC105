import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * ang invalid inputs ug 20% default wa gipangimplement 
 * wa pa sad ang type sa arraylist if ever character ra sya or number ang type chuchu
 * LIMPYUHANAN PAAAAA!!!!
 */

public class Sampling {
	
	/*
	 * Simple Random Sampling
	 */
	public static void srs(int N){
		
		ArrayList sframe = frame(N);
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input sample size:");
		
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
	
	
	/*
	 * Systematic Sampling
	 */
	public static void ss(int N){
		
		ArrayList sframe = frame(N);
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input sample size:");
		
		int n = s.nextInt();
		
		if(n>=N && n<=1){
			
			System.out.println("Invalid input");
			
		}else{
			
			int k = N/n;
			Random r = new Random();
			int sp = r.nextInt(k);	//starting point
			System.out.println("Random Sample(Systematic Sampling)");
			
			while(n!=0){
				
				System.out.println(sframe.get(sp));
				sp+=k;
				if(sp>N) {sp -= N;}
				n--;
				
			}
		}
		
	}
	
	
	/*
	 * Stratified Sampling
	 */
	public static void sts(int N){
		
		ArrayList sframe = frame(N);
		ArrayList<ArrayList> strata = new ArrayList<ArrayList>();
		Random r = new Random();
		
		Scanner s = new Scanner(System.in);
		Collections.sort(sframe);

		
		System.out.println("Strata:");
		for (int i = 0; i < N; i++) {
	        int first = (int) sframe.get(i);
	        int total = 1;
	        ArrayList tmp = new ArrayList();
	        tmp.add(sframe.get(i));
	        while (i + 1 < sframe.size() && first == ((int)(sframe.get(i + 1)))) {
	        	tmp.add(sframe.get(i));
	            total++;
	            i++;
	        }
	        strata.add(tmp);
	        System.out.println("(" + first + total + ")"); 
	        System.out.println(strata.size() + " " + tmp.size() + " " + tmp.get(0));
	    }
		
		System.out.println("Please specify percentage of the items for each strata to be sampled randomly:");
		int p;
		do{
			p = s.nextInt();
		}while(p>=100 && p<=0);
		
		for(int cnt = 0 ; cnt < strata.size() ; cnt++){
			//System.out.println(strata.get(cnt).size() + "  " + p);
			int rss = (int) Math.ceil((float)( (strata.get(cnt)).size() * p ) / 100) ; //random sample size
			System.out.println("Strata " + (cnt+1) + " (n = " + strata.get(cnt).size() + " )");
			for(int ctr = 0 ; ctr < rss ; ctr++){
				System.out.println("\t" + strata.get(cnt).get(r.nextInt(strata.get(cnt).size())));
			}
			
		}
		
		
	}
	
	
	/*
	 * Population input / Sampling Frame
	 */
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
				ss(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter population size:");
				sts(sc.nextInt());
				break;
			case 4:
				break;
			default:
				break;
			
		}
		
	}
}
