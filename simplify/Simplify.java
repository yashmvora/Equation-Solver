package simplify;
import java.util.ArrayList;

import factory.factoryQuadratic;

public class Simplify{
	
	private static Simplify instance = new Simplify();

	public static Simplify getInstance() {
		return instance;
	}

	private Simplify() {
	}


    public String simplify(String s){
        int cBracketPos=0, oBracketPos = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                cBracketPos = i;
                oBracketPos=i;
                while(s.charAt(oBracketPos)!='('){
                    oBracketPos--;
                }
                String temp = s.substring((oBracketPos+1),cBracketPos);
                //check if any operand is right outside the bracket
                if(s.charAt(oBracketPos)!='-'||s.charAt(oBracketPos)!='+' ){

                }

                s = s.substring(0,oBracketPos)+calc(temp);
            }
            //System.out.println(oBracketPos+" "+ cBracketPos);
        }
        return s;
    }

    public String calc(String s){//takes simplified terms, sends to calc(ArrayList[]......) after splitting into terms
        ArrayList<String>[] terms = splitIntoTerms(s);

        return calc(terms);
    }

    //IMPORTANT: PASS terms[1] in calculate, correctPower and simplifyTerms
    public String calc(ArrayList<String>[] terms){//handles the constant terms addition/subtraction and calls calculate(Array....), returns simplified string

        String abc = calculate(terms);
        
        double sum = 0;
        String fin="";
        for(int i=0;i<terms[0].size();i++){
            sum+=Double.parseDouble(terms[0].get(i));
        }
        
        
        if(sum<0)
            fin += sum;
        else
            fin+='+'+""+sum;

        return abc+fin;
        
    }

    //for addition of terms with variables
    public String calculate(ArrayList<String> terms[]){ //pass terms[1]
        correctPower(terms);
        rearrange(terms);
        simplifyTerms(terms[1]);

        String result="";
        int i=0;
        while(!terms[1].isEmpty()){
            double sum=0;
            String temp = terms[1].get(i);
            terms[1].remove(i);
            sum+=getCoefficient(temp);
            for(int j =terms[1].size()-1; j>=0;j--){
                if(getVar(temp).equals(getVar(terms[1].get(j)))){
                    sum+=getCoefficient(terms[1].get(j));
                    terms[1].remove(j);
                }
            }
            result+=(Double.toString(sum)+getVar(temp));
        }
        return result;
    }


    public void correctPower(ArrayList<String> terms[]){//for taking care of ^0 & ^1 in variables, is called in calc to make sure the terms are appropriate for addition
        for(int l=0;l<terms[1].size();l++){
            String term = terms[1].get(l);
            String[] subterms = term.split("\\*");
            
            for(int i = 0;i<subterms.length;i++){

                if(subterms[i].charAt(0)=='-'||subterms[i].charAt(0)=='+'){
                    for(int j=0;j<subterms[i].length();j++){
                        char x = subterms[i].charAt(j);
                        if(x=='^'&&subterms[i].charAt(j+1)=='0'){
                            if(subterms[i].length()==4)
                                subterms[i] = subterms[i].charAt(0)+"1";
                            else
                                subterms[i] = subterms[i].substring(0, j-1);
                        }
                        else if(x=='^'&& subterms[i].charAt(j+1)=='1'){
                            subterms[i] = subterms[i].substring(0,j);
                        }
                    }
                }
                else{
                    for(int j=0;j<subterms[i].length();j++){
                        char x = subterms[i].charAt(j);
                        if(x=='^'&&subterms[i].charAt(j+1)=='0'){
                            if(subterms[i].length()==3)
                                subterms[i] = "1";
                            else
                                subterms[i] = subterms[i].substring(0, j-1);
                        }
                        else if(x=='^'&& subterms[i].charAt(j+1)=='1'){
                            subterms[i] = subterms[i].substring(0,j);
                        }
                    }
                }
            }

            String newTerm = "";
            for(int i=0;i<subterms.length;i++){
                newTerm+=subterms[i]+'*';
            }
            newTerm=newTerm.substring(0, newTerm.length()-1);
            terms[1].set(l,newTerm);
        }
    }
    public void rearrange(ArrayList<String>[] terms){
        int c=0;
        ArrayList<Integer> indices= new ArrayList();
        for(int i=0;i<terms[1].size();i++){
            try{
                double temp = Double.parseDouble(terms[1].get(i));
                indices.add(i);
            }   catch(NumberFormatException e){
                continue;
            }
        }
        for(int i=0;i<indices.size();i++){
            
            terms[0].add(terms[1].get(indices.get(i)));
            terms[1].remove(terms[1].get(indices.get(i)));

            for(int j=i;j<indices.size();j++){
                //System.out.println(indices.get(j)+"  "+terms[1].get(indices.get(i)));
                indices.set(j,indices.get(j)-1);
            }
        }
    }

    //take care of constants with power
    public String removeConstantPower(String term){
        double a = 0.0;
        for(int i=0;i<term.length();i++){
            if(term.charAt(i)=='^'){
                if(isConstant(term.substring(0,i))){
                    a = Double.parseDouble(term.substring(0,i));
                    double b = Math.pow(a,Integer.parseInt(term.substring(i,i+1)));
                    return (term.substring(i).length()>2)?b+term.substring(i+2):b+"";
                }

            }
        }
        return term;
    }    

    public void simplifyTerms(ArrayList<String> terms){//for taking care of the multiply sign in the terms
    	//is called in calc to take care so that terms are appropriate for addition

        for(int i=0;i<terms.size();i++){
            String term=terms.get(i);
            String[] subterms = term.split("\\*");

            String temp = "1.0";
            for(int j=0;j<subterms.length;j++){
                if(isConstant(subterms[j])&&isConstant(temp)){
                    double a = Double.parseDouble(subterms[j]);
                    double b = Double.parseDouble(temp);
                    temp=Double.toString(a*b);
                }
                else if(isConstant(subterms[j])&&!isConstant(temp)){
                    double a = Double.parseDouble(subterms[j]);
                    temp = multiplyTerm(a,temp);
                }
                else if(!isConstant(subterms[j])&& isConstant(temp)){
                    double b = Double.parseDouble(temp);
                    temp = multiplyTerm(b, subterms[j]);
                }
                else{
                    temp = multiplyTerm(subterms[j],temp);
                }
            }
            terms.set(i, temp);
        }

    }

    public boolean isConstant(String term){
        for(int i =0;i<term.length();i++){
            char x = term.charAt(i);
            if((x>='a'&&x<='z')||(x>='A'&&x<='Z')){
                return false;
            }
        }
        return true;
    }


    /*public int varCount(ArrayList<String> terms, String var){
        int count =0;
        for(String term: terms){
            if(getVar(term).equals(var)){
                count ++;
            }
        }
        return count;
    }

    public boolean isSimplified(ArrayList<String> terms){
        for(String term: terms){
            if(varCount(terms, getVar(term))>1){
                return false;
            }
        }
        return true;
    }*/


    public String multiply(String a, String b){
        //takes two expressions, multiplies them, returns a string
        ArrayList<String>[] termsa = splitIntoTerms(a);
        ArrayList<String>[] termsb = splitIntoTerms(b);

        ArrayList<String>[] termsfin = new ArrayList[2];
        termsfin[0]=new ArrayList<String>();
        termsfin[1] = new ArrayList<String>();

        for(int i =0;i<termsa[0].size();i++){
            for(int j=0;j<termsb[0].size();j++){
                double product = (Double.parseDouble(termsa[0].get(i)))*(Double.parseDouble(termsb[0].get(j)));
                termsfin[0].add(product+"");
            }   
        }

        for(int i=0;i<termsa[0].size();i++){
            for(int j=0;j<termsb[1].size();j++){
                termsfin[1].add(multiplyTerm(Double.parseDouble(termsa[0].get(i)),termsb[1].get(j)));
            }
        }

        for(int i=0;i<termsa[1].size();i++){
            for(int j=0;j<termsb[0].size();j++){
                termsfin[1].add(multiplyTerm(Double.parseDouble(termsb[0].get(j)),termsa[1].get(i)));
            }
        }

        for(int i =0;i<termsa[1].size();i++){
            for(int j=0;j<termsb[1].size();j++){
                termsfin[1].add(multiplyTerm(termsa[1].get(i),termsb[1].get(j)));
            }
        }

        return calc(termsfin);

    }

    public String multiplyTerm(String a, String b){ //x*x^2, 2x*23x, x^1*x^2
    	//pass both terms separately in this, get the new term
        double coeffa = getCoefficient(a);
        double coeffb = getCoefficient(b);

        String vara = getVar(a);
        String varb = getVar(b);

        return (coeffa*coeffb)+((vara.charAt(0))+"^"+(getPower(vara)+getPower(varb)));
        
    }

    public String multiplyTerm(double a, String b){ //2*23x, x*3, 5*56x^2
    	//constant multiplied by variable term
        double coeff = getCoefficient(b);
        return (a*coeff)+""+getVar(b);
    }

    public int getPower(String a){
        if(a.length()==1)
            return 1;
        return Integer.parseInt(a.substring(a.length()-1));
    }

    public double getCoefficient(String a){

        String coefficient=""; double c=1;
        for(int i =0;i<a.length();i++){
            char x=a.charAt(i);
            if((x=='-'||x=='+')&&!isConstant(a.charAt(i+1))){
                return x=='-'?-1:+1;
            }
            if((x>='0' && x<='9')|| x=='.'||x=='+'||x=='-'){
                coefficient+=x;
            }
            else{
                if(coefficient=="")
                    return c;
                c = Double.parseDouble(coefficient);
                return c;
            }
        }
        return c;
    }

    public String getVar(String a){
        String var="";
        for(int i=0;i<a.length();i++){
            char x = a.charAt(i);
            if((x>='0'&& x<='9')|| x=='.'||x=='-'||x=='+'){
                var=a.substring(i+1);
            }
            else if(i==0&&((x>='a'&&x<='z')||x>='A'&&x<='Z')){
                return a;
            }
            else{
                return var;
            }
        }
        return var;
    }

    public boolean isConstant(char x){
        if(x>='0'&&x<='9'){
            return true;
        }
        return false;
    }

    public ArrayList<String>[] splitIntoTerms(String s){
        ArrayList<String>[] terms = new ArrayList[2]; //+x-1
        terms[0]=new ArrayList<String>(); //constants
        terms[1] = new ArrayList<String>(); //variables
        //x-1+2
        String temp = "";
        char sign='+';

        if(s.charAt(0)!='-'&&s.charAt(0)!='+')
            s='+'+s;
        sign=s.charAt(0); 
        char newsign = '+';
        for(int i=0;i<s.length();i++){ //+
            if(s.charAt(i)!='+'&&s.charAt(i)!='-'&&i!=s.length()-1){
                temp+=s.charAt(i); //temp=1
            }
            else {
                if(i==s.length()-1)
                    temp+=s.charAt(i);
                try{
                    temp = removeConstantPower(temp);
                    newsign=s.charAt(i); //+
                    if(i==0){
                        continue;
                    }
                    double term = Double.parseDouble(temp);
                    terms[0].add(sign+temp);
                    sign=newsign; //-
                    temp="";
                    
                }catch(NumberFormatException e){
                    terms[1].add(sign+temp);
                    sign=newsign;
                    temp="";
                }
            }
        }
        return terms;
    }

    public static void main(String args[]){
      //  simplify("((x-2)(x+2) + 3)");
      ArrayList<String> terms = new ArrayList<String>();
      terms.add("+x^2");
      terms.add("-x^0");
      terms.add("-x^1");
      instance.simplifyTerms(terms);

    }
}