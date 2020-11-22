

package equation;

import java.util.ArrayList;

public class CubicEquation extends PolynomialEquation {
	 ArrayList<Term> eq;
	 int sizeOfEq=0;
	 int[] index=new int[4];
	public CubicEquation(ArrayList<Term> terms) {
		super(terms);
		// TODO Auto-generated constructor stub
	}
	
	    

	public void solve() {
		ConstantTerm cc = getConstant();
		double cCo = cc.getCoefficient();
		
		ArrayList<VariableTerm> VTerms = getVTerms(); 
		sizeOfEq=VTerms.size();
		for(int i=0;i<sizeOfEq;i++)
		{
			int power = VTerms.get(i).getPower();
			if(power==3)
				index[0]=i;
			if(power==2)
				index[1]=i;
			if(power==1)
				index[2]=i;
				
		}
		double m=VTerms.get(index[0]).getCoefficient();
		double n=VTerms.get(index[1]).getCoefficient();
		double t=VTerms.get(index[2]).getCoefficient();
		double s=cCo;
		
		
		double a=n/m;
		double b=t/m;
		double c=s/m;
		double q=(a*a-3*b)/9;
		double r=(2*a*a*a-9*a*b+27*c)/54;
		if(r*r<q*q*q)
		{
		System.out.println("There are three solutions:");
		t=Math.acos(r/Math.sqrt(q*q*q));
		double x1=-2*Math.sqrt(q)*Math.cos(t/3)-a/3;
		double x2=-2*Math.sqrt(q)*Math.cos((t+2*Math.PI)/3)-a/3;
		double x3=-2*Math.sqrt(q)*Math.cos((t-2*Math.PI)/3)-a/3;
		System.out.println("x1="+x1+","+"x2="+x2+","+"x3="+x3);
		}
		else
		{
		System.out.println("There is only one solution:");
		int sgn=(r>=0)?1:-1;
		double u=-sgn*Math.pow((Math.abs(r)+Math.sqrt(r*r-q*q*q)),1./3);
		double v=(u!=0)?q/u:0;
		double x1=u+v-a/3;
		System.out.println("x="+x1);
		}

		//double coef = VTerms.get(2).getCoefficient();
		//int power = VTerms.get(1).getPower();
		//char v = VTerms.get(3).getVar();
		
			
	}

}
