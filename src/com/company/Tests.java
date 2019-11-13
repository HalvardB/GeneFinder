package com.company;

public class Tests {
    // Test cases to make sure everything works as it should
    // Will only give error message if they fail
    Tests() {
        Count count = new Count();
        FindGene gene = new FindGene();

        int testFindStopCodon = gene.findStopCodon("acaagttatgataacaaaaagtaaaatgcagaagggtaa", 9,"taa");
        if(testFindStopCodon != 21){
            System.out.println("testFindStopCodon failed");
        }

        String testEmptyString = gene.searchString("12234578hgfx gsdweirh23oj23o4ij234",0);
        if(! testEmptyString.equals("")){
            System.out.println("testEmptyString failed");
        }

        String testSearchFunction = gene.searchString("12345atg1231tga23tag1234taa12taa123123",0);
        if(! testSearchFunction.equals("atg1231tga23tag")){
            System.out.println("testSearchFunction failed");
        }

        String testSearchWithMultipleStops = gene.searchString("12312atg1231taa23123taa12tga3123tga123123",0);
        if(! testSearchWithMultipleStops.equals("atg1231taa23123taa")){
            System.out.println("testSearchWithMultipleStops failed");
        }

        String testNoStopCodon = gene.searchString("12312atg1231123123123123asdfghjklø",0);
        if(! testNoStopCodon.equals("")){
            System.out.println("testNoStopCodon failed");
        }

        int testHowMany = count.howMany("GAA", "ATGAACGAATTGAATC");
        if(testHowMany != 3){
            System.out.println("testHowMany failed");
            System.out.println(testHowMany);
        }

        int testHowManyOverlap = count.howMany("AA", "ATAAAA");
        if(testHowManyOverlap != 2){
            System.out.println("testHowManyOverlap failed");
            System.out.println(testHowManyOverlap);
        }

        double testCGratio = count.cgRatio("ATGCCATAG");
        if(testCGratio != 0.4444444477558136){
            System.out.println("testCGRatio failed");
            System.out.println("Ratio = " + testCGratio);
        }
    }
}
