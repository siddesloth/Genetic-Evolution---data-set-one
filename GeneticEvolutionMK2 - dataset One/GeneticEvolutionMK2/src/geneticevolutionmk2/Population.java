/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticevolutionmk2;

/**
 *
 * @author i2-rickwood
 */
import java.util.*;
        
public class Population {
    
    public List<Individual> individuals;
    
    public Population(int size, boolean createNew){ //generates a new population
        individuals = new ArrayList<>();
        
        if (createNew){ //if first population it will also generate all the individuals to fill it
            createPopulation(size);
        }
    }
    
    public void createPopulation(int size){
        for (int i = 0; i < size; i++){
            Individual newIndividual = new Individual(); //creates individuals up to population size
            individuals.add(i, newIndividual);
        }
    }
    
    public Individual getIndividual(int position){
        return individuals.get(position);
    }
    
    public void addIndividual(int i, Individual individual){
        individuals.add(i, individual);
    }
    
    public void setIndividualFitness(RuleBase ruleBase, int position){
        individuals.get(position).setFitness(ruleBase);
    }
}
