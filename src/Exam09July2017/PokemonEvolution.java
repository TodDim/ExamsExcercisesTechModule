package Exam09July2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        LinkedHashMap<String,List<String>> pokemons=new LinkedHashMap<>();
        while (!input.equals("wubbalubbadubdub")) {
            String[] inputTokens = input.split(" -> ");
            if (pokemons.containsKey(input)) {
                System.out.println("# " + input);
                for (int i = 0; i < pokemons.get(input).size(); i++) {
                    System.out.println(pokemons.get(input).get(i));
                }
            } else {
                pokemons.putIfAbsent(inputTokens[0], new ArrayList<>());
                pokemons.get(inputTokens[0]).add(inputTokens[1]+" <-> "+inputTokens[2]);
            }
            input = reader.readLine();
        }
        pokemons.entrySet().stream().forEach(x->{
            System.out.println("# "+x.getKey());
            x.getValue().stream().sorted((d1,d2)->{
                int m= Integer.compare( Integer.parseInt(d2.split(" <-> ")[1]),Integer.parseInt(d1.split(" <-> ")[1]));
                return m;
            }).forEach(System.out::println);

        });

    }
}