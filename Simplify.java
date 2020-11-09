import java.util.ArrayList;

public class Simplify{

    public void simplify(String s){
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

                s = s.substring(0,oBracketPos)+calc(temp)+s.substring
            }
            //System.out.println(oBracketPos+" "+ cBracketPos);
        }
    }

    public String calc(String s){
        ArrayList<String>[] terms = split(s);

        return calc(terms);
    }

    //MERGE CALC AND CALCULATE
    //IMPORTANT: PASS terms[1] in calculate, correctPower and simplifyTerms
    public String calc(ArrayList<String>[] terms){

        double sum = 0;
        String fin="";
        for(int i=0;i<terms[0].size();i++){
            sum+=Double.parseDouble(terms[0].get(i));
        }
        
        
        if(sum<0)
            fin += sum;
        else
            fin+='+'+sum;

        return calculate(terms[1])+fin;
    }
    
    //for addition of terms with variables
    public String calculate(ArrayList<String> terms){ //pass terms[1]
        correctPower(terms);
        simplifyTerms(terms);

        String result="";
        int i=0;
        while(!terms.isEmpty()){
            double sum=0;
            String temp = terms.get(i);
            terms.remove(i);
            sum+=getCoefficient(temp);
            for(int j =terms.size()-1; j<=0;j--){
                if(getVar(temp).equals(getVar(terms.get(j)))){
                    sum+=getCoefficient(terms.get(j));
                    terms.remove(j);
                }
            }
            result+=(Double.toString(sum)+getVar(temp));
        }
        return result;
    }


    
    public void correctPower(ArrayList<String> terms){//for taking care of ^0 & ^1
        for(int l=0;l<terms.size();l++){
            String term = terms.get(l);
            String[] subterms = term.split("*");
            for(int i = 0;i<subterms.length;i++){
                for(int j=0;j<subterms[i].length();j++){
                    if(subterms[i].charAt(j)=='^'&&subterms[i].charAt(j+1)=='0'){
                        
                        if((subterms[i].charAt(0)>='0'&&subterms[i].charAt(0)<='9'&&subterms[i].length()==3)){
                            subterms[i]="1";
                        }

                        else if(subterms[i].length()>3){
                            subterms[i]=subterms[i].substring(0,subterms[i].length()-3);
                        }
                    }

                    else if(subterms[i].charAt(j)=='^'&&subterms[i].charAt(j+1)=='1'){
                        subterms[i]=subterms[i].substring(0,subterms[i].length()-2);
                    }
                }
            }

            String newTerm = "";
            for(int i=0;i<subterms.length;i++){
                newTerm+=subterms[i]+'*';
            }
            newTerm=newTerm.substring(0, newTerm.length()-1);
            terms.set(l,newTerm);
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

        for(int i=0;i<terms.size();i++){
            String term=terms.get(i);
            String[] subterms = term.split("*");

            String temp = "1.0";
            for(int j=0;j<subterms.length-1;j++){
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
        if(term.matches("[a-zA-Z]+")){
            return false;
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
        
        ArrayList<String>[] termsa = split(a);
        ArrayList<String>[] termsb = split(b);

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
                termsfin[1].add(multiplyTerm(termsa[1].get(i),termsb[1].get(i)));
            }
        }

        return calc(termsfin);

    }

    public String multiplyTerm(String a, String b){ //x*x^2, 2x*23x, x^1*x^2
        double coeffa = getCoefficient(a);
        double coeffb = getCoefficient(b);

        String vara = getVar(a);
        String varb = getVar(b);

        return (coeffa*coeffb)+(vara.charAt(0))+"^"+(getPower(vara)+getPower(varb));
        
    }

    public String multiplyTerm(double a, String b){ //2*23x, x*3, 5*56x^2
        double coeff = getCoefficient(b);
        return (a*coeff)+getVar(b);
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
            if(x>='0'&& x=='.' && x<='9'){
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
            if(x>='0' &&x!='.'&& x<='9'){
                var=a.substring(i+1);
            }
            else{
                return var;
            }
        }
        return var;
    }

    public ArrayList<String>[] split(String s){
        ArrayList<String>[] terms = new ArrayList[2]; //+x-1
        terms[0]=new ArrayList<String>(); //constants
        terms[1] = new ArrayList<String>(); //variables
        //x-1+2
        String temp = "";
        char sign='+';

        if(s.charAt(0)!='-'&&s.charAt(0)!='+')
            s='+'+s;
        sign=s.charAt(0); 
        char newsign;
        for(int i=0;i<s.length();i++){ //+
            if(s.charAt(i)!='+'||s.charAt(i)!='-'){
                temp+=s.charAt(i); //temp=1
            }
            else{
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
                    temp="";
                }
            }
        }
        return terms;
    }


    public static void main(String args[]){
        simplify("((x-2)(x+2) + 3)");
    }
}