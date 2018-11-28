/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticevolutionmk2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author i2-rickwood
 */
public class Individual {
    int geneticLength = 60; //sets genetic length
    int gene;
    int[] genes = new int[geneticLength];
    public int fitness = 0;
    
    public Individual(){
        int position = 0;
        for (int i = 0; i < geneticLength; i++){ //creates the individuals
            if (position != 5){
                gene = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                genes[i] = gene;
                position++;
            } else {
                gene = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                genes[i] = gene;
                position = 0; 
            }
        }
    }
    
    public void setFitness(RuleBase ruleBase){ //sets fitness of individuals
        ArrayList<String> geneRules = new ArrayList<>();
        int newFitness = 0;
        String Gene = "";
        int stringMax = 0;
        int setsAdded = 0;
        
        for (int i = 0; i < geneticLength; i++){ //for all genes of the individual
            String Sgene = Integer.toString(getSingleGene(i)); //set single gene to string
            Gene = Gene + Sgene; //add gene to existing string
            stringMax++;
            if (stringMax == (ruleBase.getRule(0).getCondition().length() + 1)){ //if string length is now equal to condition length + result
                geneRules.add(setsAdded, Gene); //add string to arrayList
                setsAdded++;
                stringMax = 0; //reset string count
                Gene = ""; //reset string of genes
            }
        }
        for (int j = 0; j < ruleBase.getListSize(); j++){ //gets data set rule
            //System.out.println("Testing for ruleBase rule " + j);
            String Con = ruleBase.getRule(j).getCondition();
            String Res = ruleBase.getRule(j).getResult();
            boolean flag = false;
            for (int k = 0; !flag && k < geneRules.size(); k++){ //compares to all local rules
                boolean conMatch = false;
                boolean resMatch = false;
                String localRule = geneRules.get(k);
                //System.out.println("The condition is " + Con + " the result is " + Res + " the local rule is " + localRule);
                conMatch = matchCon(Con, localRule, ruleBase.getRule(k).getCondition().length());
                if (conMatch){ //checks if conditions match
                    resMatch = matchRes(Res, localRule, ruleBase.getRule(k).getCondition().length());
                    if (resMatch){
                        newFitness++; //if results match then fitness is increased + it breaks
                        //System.out.println("increasing fitness");
                        flag = true;
                    } else {
                        //System.out.println("result didn't match");
                        flag = true; //breaks even if results don't match
                    }
                }
            }
        }
        fitness = newFitness;
    }
    
    public boolean matchCon(String Con, String localRule, int conLength){ //basically compares each 'bit' in the condition to the local rule's condition and if all match returns true
        boolean matched = false;
        int matches = 0;
        boolean subFlag = false;
        for (int o = 0; !subFlag && o < conLength; o++){
            char localChar = localRule.charAt(o);
            char conChar = Con.charAt(o);
            if (localChar == conChar){
                matches++;
                //System.out.println("Sucessful match");
            } else if (localChar == '2'){
                matches++;
                //System.out.println("Sucessful match");
            } else {
                matches = 0;
                //System.out.println("Failed match");
                subFlag = true;
            }
        }
        if (matches == conLength){
            matched = true;
        }
        return matched;
    }
    
    public boolean matchRes(String Res, String localRule, int conLength){ //checks if result of data sets matches the local rule's result
        boolean matched = false;
        char result = Res.charAt(0);
        char localResult = localRule.charAt(conLength);
        if (result == localResult){
            matched = true;
        }
        return matched;
    }
    
    public int returnFitness(){
        return fitness;
    }
    
    public void changeFitness(RuleBase ruleBase){
        setFitness(ruleBase);
    }
    
    
    public int getSingleGene(int gene){
        return genes[gene];
    }
    
    public void changeSingleGene(int gene, int newgene){
        genes[gene] = newgene;
    }
}
