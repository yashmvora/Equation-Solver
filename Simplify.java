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

        ArrayList<Integer> cons = new ArrayList<Integer>(); //+x-1
        ArrayList<String> vars = new ArrayList<String>();
        
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
                    int term = Integer.parseInt(sign+temp); //-1
                    sign=newsign; //-
                    temp="";
                    cons.add(term);
                    
                }catch(NumberFormatException e){
                    vars.add(sign+temp);
                    temp="";
                }
            }
        }

        int sum = 0;
        String fin="";
        for(int i=0;i<cons.size();i++){
            sum+=cons.get(i);
        }
        
        for(int i = 0;i<vars.size();i++){
            fin+=vars.get(i);
        }
        if(sum<0)
            fin += sum;
        else
            fin+='+'+sum;
        return fin;

    }

    public static void main(String args[]){
        simplify("((x-2)(x+2) + 3)");
    }
}