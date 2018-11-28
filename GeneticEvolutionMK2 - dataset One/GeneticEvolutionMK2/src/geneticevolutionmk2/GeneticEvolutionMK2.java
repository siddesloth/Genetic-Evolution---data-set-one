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
public class GeneticEvolutionMK2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        runAlgorithm evolve = new runAlgorithm();
        if (evolve.runNewAlgorithm()){
            System.out.println("Done");
        }
    }
    
}
