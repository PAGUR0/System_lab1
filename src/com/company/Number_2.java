package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Number_2 {
    public static void main(String[] args) {
        String line;
        int skip = 0;
        boolean first = true;
        ArrayList<String[]> PID = new ArrayList<>();
        try {
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\tasklist.exe");
            BufferedReader input =  new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null){
                if(!line.trim().isEmpty()){
                    String[] parts = line.trim().split("\\s+");
                    if(parts.length >= 2 && skip++>2){
                        PID.add(parts);
                        String pid = parts[1];
                        if(first){
                            System.out.println("PID:" + pid);
                            first = false;
                            continue;
                        }
                        System.out.println("PID: " + pid);
                    }
                }
            }
            for(int i = 0; i < PID.size(); i++){
                System.out.println("Имя: " + PID.get(i)[0] + " Приоритет: " + PID.get(i)[3]);
            }
            input.close();
        } catch (Exception x) { x.printStackTrace(); }
    }
}
