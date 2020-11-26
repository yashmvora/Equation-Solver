package input;

import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

public class InputValidator{
private static InputValidator instance = new InputValidator();

	
	public static InputValidator getInstance() {
		return instance;
		
    }
    
    public boolean isValid(String e) {
            String[] exp = e.split("");

            if (!bracketsValid(exp)) {
                return false;
            }
            if(!operatorsValid(exp)){
                return false;
            }
            if(!checkInvalidChars(exp)){
                return false;
            }
            if (!checkDecimal(exp)) {
                return false;
            }
            if(!checkAfterBrackets(exp)){
                return false;
            }
            if(!checkAfterVariable(exp)){
                return false;
            }
            if (!checkConstantPowers(exp)) {
                return false;
            }
            if(!checkPowers(exp)){
                return false;
            }
        return true;
    }

    public boolean operatorsValid(String[] exp) {
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

    public boolean checkInvalidChars(String[] exp){
        for (int i=0;i<exp.length;i++){
        if (exp[i].matches("[A-Za-z0-9*^+/()-]")){
           continue; 
        } else{ 
            return false;
        }
    }
        return true;
    }


    public boolean checkDecimal(String[] exp){
    	for(int i=0;i<exp.length;i++){
            if (exp[i]=="." && i+1<exp.length && exp[i+1].matches("[+/*^*-]")){
            	return false;
            }
            }
    	
        for(int i=0;i<exp.length;i++){
            if (exp[i]=="." && i+1<exp.length){
               for (int j=i+1;j<exp.length;j++){
                    if(exp[j].matches("[A-Za-z]")){
                        return false;
                    } else if(exp[j].matches("[+/*^*-]")){
                        break;
                    }
               } 
            }
        }
        return true;
    }

    public boolean checkConstantPowers(String[] exp){
        for (int i=1;i<exp.length;i++){
            if(exp[i]=="^"){
                if(exp[i-1].matches("[0-9]")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkAfterVariable(String[] exp){
        for(int i=0;i<(exp.length-1);i++){
            if(exp[i].matches("[A-Za-z]")){
                if (exp[i+1].matches("[0-9]")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkAfterBrackets(String[] exp) {
    	for(int i=0;i<exp.length;i++){
            if (exp[i]=="(" && exp[i+1]=="^"){
            	return false;
            } else if (exp[i]==")" && exp[i+1]=="^") {
            	return false;
            } 
    	}
    	return true;
    }
    
    public boolean checkPowers(String[] exp) {
    	for (int i=1;i<exp.length;i++){
            if(exp[i]=="^" && exp[i+1].matches("[A-Za-z]")){
            	return false;
            }
    	}
    	return true;
    }
}


