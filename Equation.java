import java.util.*;
public class Equation {
    // class for breaking down the equation

    private ArrayList<Term> terms=new ArrayList<Term>();
    private ArrayList<Double> constants = new ArrayList<Double>();

    public Equation(String s){
        
    }
    

    public String toString(){
        
    }

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
            //System.out.println(oBracketPos+" "+cBracketPos);
        }
    }

    public String calc(String s){
        ArrayList<String>[] terms = termify(s);
        double sum = 0;
        String fin="";
        for(int i=0;i<terms[0].size();i++){
            sum+=Integer.parseInt(terms[0].get(i));
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

    public ArrayList<String>[] termify(String s){
       
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
    
}