/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticevolutionmk2;

/**
 *
 * @author Isaac
 */
public class Rule {
    String condition;
    String result;
    
    public Rule(String rule){
        
        String ss[] = rule.split("\\s+");
        setCondition(ss[0]); //sets condition from first part of read in data
        setResult(ss[1]); //sets result from second part of read in data
    }
    public void setCondition(String newcondition){
        //System.out.println("The condition is " + newcondition);
        condition = newcondition;
    }
    
    public void setResult(String newResult){
        //System.out.println("The result is " + newResult);
        result = newResult;
    }
    
    public String getCondition(){
        return condition;
    }
    
    public String getResult(){
        return result;
    }
    
}
