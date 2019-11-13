package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FindGene genes = new FindGene();
        Count count = new Count();
        Tests tests = new Tests();
        ArrayList<String> allGenes = new ArrayList<>();

        // DNA string to analyze
        String geneString = genes.GRch38dnapart.toLowerCase();

        // Get first Gene and startIndex
        String newGene = genes.searchString(geneString,0);
        int startIndex = geneString.indexOf(newGene) + newGene.length() + 1;

        // Loop through the hole DNA and add new genes to the allGenes array
        while(!newGene.equals("")){
            allGenes.add(newGene);
            newGene = genes.searchString(geneString,startIndex);
            startIndex = geneString.indexOf(newGene, startIndex) + newGene.length();
        }

        // Looping through the array to count variables
        int geneLongerThan60Characters = 0;
        int moreThan35CGrate = 0;
        int longestGene = 0;

        for(int i = 0; i < allGenes.size(); i++){
            if(allGenes.get(i).length() > 60){
                geneLongerThan60Characters++;
            }

            double cgRatio = count.cgRatio(allGenes.get(i));
            if(cgRatio > 0.35){
                moreThan35CGrate++;
            }

            int geneLength = allGenes.get(i).length();
            if(geneLength > longestGene){
                longestGene = geneLength;
            }
        }

        // Printing out a summary of the results to answer the Coursera quiz
        System.out.println("SUMMARY");
        System.out.println("Total gene count: " + allGenes.size());
        System.out.println("Genes longer than 60 characters: " + geneLongerThan60Characters);
        System.out.println("Genes with CG ratio above 0.35: " + moreThan35CGrate);
        System.out.println("CTG count: " + count.howMany("CTG", genes.GRch38dnapart));
        System.out.println("Longest gene is: " + longestGene + " characters.");
    }
}
