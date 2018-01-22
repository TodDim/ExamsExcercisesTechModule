package Izpit05112017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {


            List<String> tokens = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
            String command = reader.readLine();
            while (!command.equals("3:1")) {
                String[] commandTokens = command.split(" ");
                switch (commandTokens[0]) {
                    case "merge":
                        Merge(Integer.parseInt(commandTokens[1]), Integer.parseInt(commandTokens[2]), tokens);
                        break;
                    case "divide":
                        Divide(Integer.parseInt(commandTokens[1]), Integer.parseInt(commandTokens[2]), tokens);
                        break;
                    default:
                        break;
                }
                command = reader.readLine();
            }
            for (String s : tokens
                    ) {
                System.out.print(s + " ");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static List<String> Divide(int index, int partitions, List<String> list) {
        if (index<0&&partitions<0){
            return list;
        }
        int count=list.get(index).length()/partitions;
        String text=list.get(index);
        list.set(index,list.get(index).substring(0,count));
        for (int i = 1; i <partitions ; i++) {
            if (i==partitions-1){
                list.add(index+i,text.substring(i*count));
                break;
            }
            list.add(index+i,text.substring(i*count,i*count+count));
        }

        return  list;
    }

    private static List<String> Merge(int start,int end, List<String> list) {
        if (end>list.size()-1){
            end=list.size()-1;
        }
        if (end<start){
            return list;
        }
        for (int i = start; i <end ; i++) {
          list.set(start,list.get(start).concat(list.get(start+1)));
          list.remove(start+1);
        }
        return list;
    }
}
