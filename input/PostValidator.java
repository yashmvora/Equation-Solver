package input;
public class PostValidator{

    private static PostValidator instance = new PostValidator();

	public static PostValidator getInstance() {
		return instance;
    }
    public int checkDegree(String eq){
        char[] exp = eq.toCharArray();
        int degree=0;
        boolean lessthan2=true;
        
        for(int i=0;i<exp.length;i++){
            if(exp[i]=='^'){
                lessthan2=false;
            }
        }
        
        if(lessthan2) {
        	for(int i=0;i<exp.length;i++) {
        		if(Character.toString(exp[i]).matches("[A-Za-z]")){
        			degree=1;
        		}
        	}
        }
        
        if(!lessthan2) {
        	for(int i=0;i<exp.length-1;i++) {
        		if(exp[i]=='^') {
        			degree=Math.max(degree,Character.getNumericValue(exp[i+1]));
        		}
        	}
        }
        
        return degree;
    }
}