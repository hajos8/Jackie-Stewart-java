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

        //5. feladat

        System.out.println("5. feladat: ");
        for(Integer evtized : handler.evtizedek().keySet()){
            System.out.println(evtized + "-es évek: " + handler.evtizedek().get(evtized) + " megnyert verseny");
        }

        //6. feladat

        String filename = "Jackie.html";

        System.out.println("6. feladat: " + filename);
        handler.createHTML(filename);


    }
}