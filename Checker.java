public class Checker {

    public boolean check(String[] exps) {
        for (String e : exps) {
            char[] exp = e.toCharArray();
            if (!checkBrackets(exp)) {
                return false;
            }
            if(!checkOperators(exp)){

            }
        }
    }

    private boolean checkOperators(char[] exp) {
        if(exp[0]=='+'||exp[0]=='-'||exp[0]=='*'||exp[0]=='/')
        for(int i = 0 ; i<exp.length; i++){
            if(exp[i]=='+'||exp[i]=='-'){
                if(){

                }
            }
        }
    }

    public boolean checkBrackets(char[] exp) {
        int counter = 0;
        for (char e : exp) {
            if (e == '(') {
                counter++;
            } else if (e == ')') {
                counter--;
            }
        }
        if (counter != 0) {
            return false;
        }
        return true;
    }
}
