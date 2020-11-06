import java.util.ArrayList;

public class Simplify{

    public static void simplify(String s){
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

    public String calc(ArrayList<String>[] terms){
        double sum = 0;
        String fin="";
        for(int i=0;i<terms[0].size();i++){
            sum+=Double.parseDouble(terms[0].get(i));
        }
        
        for(int i = 0;i<terms[1].size();i++){
            fin+=terms[1].get(i);
        }
        if(sum<0)
            fin += sum;
        else
            fin+='+'+sum;

        return fin;
    }

    public String calc(ArrayList<String> terms){
        int c;
        double sum=0;
        for(int i=0;i<=3;i++){
            for(int j=0;j<terms.size();j++){
                c=0;
                sum=0;
                //if()
                if(getPower(terms.get(j))== i){
                    c++;
                    sum+=getCoefficient(terms.get(j));
                }

            }
        }

    }


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

    public String multiplyTerm(Double a, String b){ //2*23x, x*3, 5*56x^2
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
            if(x>='0' && x<='9'){
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
            if(x>='0' && x<='9'){
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
            if(s.charAt(i)!='+'||s.charAt(i)!='-'||s.charAt(i)!='*'||s.charAt(i)!='/'){
                temp+=s.charAt(i); //temp=1
            }
            else{
                try{
                    newsign=s.charAt(i); //+
                    if(i==0){
                        continue;
                    }
                    int term = Integer.parseInt(temp);
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