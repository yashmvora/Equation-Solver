import java.util.*;
public class App {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		double a = 0;
		double b=0;
		double c=0;
		double d=0;
		sc.close();
		String [] num=s.split(" ");
		String inputS=new String();
		char[] chars=inputS.toCharArray();
		for(int i=0;i<chars.length;i++)
		{
			 if(chars[i]=='x'&&chars[i+2]=='3')
				 a=(double)chars[i-1];
			 if(chars[i]=='x'&&chars[i+2]=='2')
				 b=(double)chars[i-1];
			 if(chars[i]=='x'&&chars[i+2]=='1')
				 c=(double)chars[i-1];
			 
				 
		}
		
		for (double i = -1000.00; i <=1000.00; i+=0.01) {
			  double x1=i-0.005,x2=i+0.005;
	            if((x1*x1*x1+b/a*x1*x1+c/a*x1+d/a)*(x2*x2*x2+b/a*x2*x2+c/a*x2+d/a)<0)
	                System.out.printf("%.2f ",i);
		}
	}

	
}
