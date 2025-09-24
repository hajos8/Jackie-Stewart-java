package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public void createHTML(String path) {
        try {
            FileWriter writer = new FileWriter(path);

            StringBuilder content = new StringBuilder();
            
            content.append("<!DOCTYPE html>\n");
            content.append("<html lang=\"en\">\n");
            content.append("<head></head>\n");
            content.append("<style>td{border:1px solid black}</style>\n");

            content.append("<body>\n");

            content.append("<h1>Jackie Stewart</h1>\n");

            content.append("<table>\n");

            for (Integer[] stat : stats) {
                content.append("<tr>");
                content.append("<td>");
                content.append(stat[0]);
                content.append("</td>");
                content.append("<td>");
                content.append(stat[1]);
                content.append("</td>");
                content.append("<td>");
                content.append(stat[2]);
                content.append("</td>");
                content.append("</tr>\n");
            }
            
            content.append("</table>\n");

            content.append("</body>\n");
            content.append("</html>\n");

            writer.write(String.valueOf(content));
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
