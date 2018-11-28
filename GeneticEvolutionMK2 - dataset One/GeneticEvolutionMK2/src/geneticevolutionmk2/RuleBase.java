/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticevolutionmk2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Isaac
 */
public class RuleBase {
    
    public List<Rule> rules;
    
    public RuleBase(){
        rules = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
          fr = new FileReader("dataOne.txt");
          br = new BufferedReader(fr);

          String rule;

          while ((rule = br.readLine()) != null){ //reads in rules a line at a time and makes them their own rule objects
              //System.out.println("The rule is " + rule);
              Rule newRule = new Rule(rule);
              rules.add(newRule);
          }


        } catch (IOException e){
           e.printStackTrace();
        }
    }
    
    public Rule getRule(int position){
        return rules.get(position);
    }
    
    public int getListSize(){
        int size = rules.size();
        return size;
    }
    
}
