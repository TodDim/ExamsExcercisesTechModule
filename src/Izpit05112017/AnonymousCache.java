package Izpit05112017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tosha on 5.11.2017 г..
 */
public class AnonymousCache {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,List<String>> dataset=new HashMap<>();
        List<String> cache=new ArrayList<>();
        String input=reader.readLine();
        while (!input.equals("thetinggoesskrra")){
            String[] tokens=input.split("\\s\\|\\s");
            if (tokens.length>1){
                if (!dataset.containsKey(tokens[1])){
                    cache.add(input);
                    input=reader.readLine();
                    continue;
                }
                dataset.get(tokens[1]).add(tokens[0]);

            }
            if (tokens.length==1){
                dataset.putIfAbsent(input,new ArrayList<>());
                for (int i = 0; i <cache.size() ; i++) {
                    if (cache.get(i).contains(input)){

                        for (int j = 0; j <cache.size() ; j++) {
                            String[] cacheTokens=cache.get(j).split("\\s\\|\\s");
                            dataset.get(cacheTokens[1]).add(cacheTokens[0]);
                        }
                        break;
                    }
                }

            }

            input=reader.readLine();
        }

List<Integer> max=new ArrayList<>();
        List<String> names=new ArrayList<>();
dataset.entrySet().stream().forEach(x->{

    int sum=0;
    for (String v:x.getValue()
         ) {
        sum+=Integer.parseInt(v.split(" -> ")[1]);


    }
    max.add(sum);

});

        int maxx = Collections.max(max);
        int index=max.indexOf(maxx);
        System.out.println(index);
        System.out.print("Data Set:"+dataset.get( dataset.get(index))+", ");
        System.out.println("Total Size: "+maxx);
        for (String s :  dataset.get(dataset.get(index))) {
            System.out.println("$."+s);
        }


//
//        pokemons.entrySet().stream().forEach(x->{
//            System.out.println("# "+x.getKey());
//            x.getValue().stream().sorted((d1,d2)->{
//                int m= Integer.compare( Integer.parseInt(d2.split(" <-> ")[1]),Integer.parseInt(d1.split(" <-> ")[1]));
//                return m;
//            }).forEach(System.out::println);
//
//        });
    }
}