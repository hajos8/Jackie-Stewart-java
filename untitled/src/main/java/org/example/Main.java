package org.example;

public class Main {
    public static void main(String[] args) {
        Jackie handler = new Jackie();

        //2. feladat
        handler.readStats("jackie.txt");

//        for(Integer[] stats : handler.getStats()){
//            for(Integer stat : stats){
//                System.out.print(stat + " ");
//            }
//            System.out.println();
//        }

        //year	races	wins	podiums	poles	fastests

        //3. feladat

        System.out.println("3. feladat: " + handler.getStats().size());

        //4. feladat

        System.out.println("4. feladat: " + handler.legtobbVerseny());


    }
}