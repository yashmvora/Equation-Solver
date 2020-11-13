package equation;
public class VariableTerm extends Term {
    
    
    private char var;
    private int power;

    public VariableTerm(String term){
        String coef = "";
        for(int i =0;i<term.length();i++){
            char x=term.charAt(i);
            if(!((x>='a' && x<='z')||(x>='A'&&x<='Z'))){
                coef+=x;
            }
            else{
                if(coef=="")
                    coef="1";
                var = x;
                String exp = term.substring(i);
                if(exp.length()==1)
                    power = 1;
                else
                    power = Integer.parseInt(exp.substring(exp.length()-1));
                setCoefficient(Double.parseDouble(coef));
            }
        }

    }

    

    public void setPower(int p){
        this.power = p;
    }

    public int getPower(){
        return this.power;
    }

    public char getVar(){
        return this.var;
    }

    public String toString(){
        String term = this.getCoefficient()+this.var+"^"+this.power;
        return term;
    }

}
