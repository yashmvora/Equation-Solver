public class Term {
    
    private double coefficient;
    private char var;
    private int power;

    public Term(String term){
        String c = "";
        for(int i =0;i<term.length();i++){
            char x=term.charAt(i);
            if(!((x>='a' && x<='z')||(x>='A'&&x<='Z'))){
                c+=x;
            }
            else{
                if(c=="")
                    c="1";
                var = x;
                String a = term.substring(i);
                if(a.length()==1)
                    power = 1;
                else
                    power = Integer.parseInt(a.substring(a.length()-1));
                coefficient = Double.parseDouble(c);
            }
        }

    }

    public void changeCoefficient(double c){
        this.coefficient = c;
    }

    public void changePower(int p){
        this.power = p;
    }

    public double getCoefficient(){
        return this.coefficient;
    }

    public int getPower(){
        return this.power;
    }

    public char getVar(){
        return this.var;
    }

    public String toString(){
        String term = this.coefficient+this.var+"^"+this.power;
        return term;
    }

}
