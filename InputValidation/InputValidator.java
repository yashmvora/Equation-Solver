package InputValidation;

import java.util.ArrayList;
import java.util.Stack;

public class InputValidator{

    public boolean validate(String[] exps) {
        for (String e : exps) {

            String[] exp = e.split("");
            if (!bracketsValid(exp)) {
                return false;
            }
            if(!operatorsValid(exp)){
                return false;
            }
        }
        return true;
    }

    private boolean operatorsValid(String[] exp) {
        if(exp[0].matches("[*/^]+")||exp[exp.length-1].matches("[+\\-*/^]+")){
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

    public boolean bracketsValid(String[] exp) {
        Stack<String> stack = new Stack<>() ; 
        for (String e : exp) {
            if (e.matches("[({\\[]+")) {
                stack.push(e);
            } else if (e.equals(")")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
                if(stack.peek().equals("(")) {
                	stack.pop();
                }else {
                	return false;
                }
                	
            }else if(e.equals("}")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
            	if(stack.peek().equals("{")) {
                	stack.pop();
                }else {
                	return false;
                }
            	
            }else if(e.equals("]")) {
            	if(stack.isEmpty()) {
            		return false;
            	}
            	if(stack.peek().equals("[")) {
                	stack.pop();
                }else {
                	return false;
                }
            }
        }
        if (!stack.empty()) {
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

