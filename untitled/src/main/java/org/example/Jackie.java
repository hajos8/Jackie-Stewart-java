package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jackie {
    ArrayList<Integer[]> stats = new ArrayList<>();

    public ArrayList<Integer[]> getStats() {
        return stats;
    }
    public void setStats(ArrayList<Integer[]> stats) {
        this.stats = stats;
    }

    public void readStats(String path) {
        try{
            Scanner scanner = new Scanner(new File(path));

            scanner.nextLine(); // skip header

            ArrayList<Integer[]> tempStats = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split("\t");
                Integer[] intParts = new Integer[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    intParts[i] = Integer.parseInt(parts[i]);
                }

                tempStats = getStats();
                tempStats.add(intParts);
                setStats(tempStats);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    public int legtobbVerseny(){
        int max = 0;
        int index = 0;

        for(int i = 0; i < stats.size(); i++){
            if(stats.get(i)[1] > max){
                max = stats.get(i)[1];
                index = i;
            }
        }

        return stats.get(index)[0];
    }

    public HashMap<Integer, Integer> evtizedek(){
        HashMap<Integer, Integer> evtized = new HashMap<>();

        for(Integer[] stat : stats){
            int decade = (stat[0] / 10) * 10;
            if(evtized.containsKey(decade)){
                evtized.put(decade, evtized.get(decade) + stat[2]);
            }
            else{
                evtized.put(decade, stat[2]);
            }
        }

        return evtized;
    }
}
