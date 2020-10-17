public class Checker {

    public boolean check(String[] exps) {

        
        for (String e : exps) {

            String[] exp = e.split("");
            if (!checkBrackets(exp)) {
                return false;
            }
            if(!checkOperators(exp)){

            }
        }
    }

    private boolean checkOperators(String[] exp) {
        if(exp[0].matches("[+\\-*/^]+")||exp[exp.length-1].matches("[+\\-*/^]+")){
            return false;
        }
        for(int i = 1 ; i<exp.length-1; i++){
            if(exp[i].equals("+")||exp[i].equals("-")){
                if(exp[i+1].matches("[*/^]+")){
                    return false;
                }
                if(!exp[i-1].matches("[A-Za-z0-9]+")&&!exp[i+1].matches("[A-Za-z0-9]+")){  
                    return false;
                }  
            }
        }
        return true;
    }

    public boolean checkBrackets(String[] exp) {
        int counter = 0;
        for (String e : exp) {
            if (e.equals("(")) {
                counter++;
            } else if (e.equals(")")) {
                counter--;
            }
        }
        if (counter != 0) {
            return false;
        }
        return true;
    }
    public int checkDegree(char[] exp){
        int degree=0;
        for(int i=0;i<exp.length-1;i++){
            if(exp[i]=='^'){
                degree=Math.max(degree, exp[i+1]);
            }
        }
        return degree;
    }

    public boolean checkInvalidChars(String exp){
        if (exp.matches("[A-Za-z0-9+\\-/(){}\\[\\]*^]")){
           return true; 
        }
        return false;
    }
}
}
