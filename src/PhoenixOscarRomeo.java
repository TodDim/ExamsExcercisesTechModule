import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class PhoenixOscarRomeo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ;
        String input = "";
        LinkedHashMap<String, List<String>> creatures = new LinkedHashMap<>();
        while (!(input = reader.readLine()).equals("Blaze it!")) {
            String[] tokens = input.split(" -> ");

            creatures.putIfAbsent(tokens[0], new LinkedList<>());
            if (creatures.get(tokens[0]).contains(tokens[1])) {
                continue;
            } else if (!tokens[0].equals(tokens[1])) {
                creatures.get(tokens[0]).add(tokens[1]);
            }

            for (String s : creatures.get(tokens[0])) {
                if (creatures.keySet().contains(s)&&creatures.get(s).contains(tokens[0])) {
                    creatures.get(tokens[0]).remove(s);
                    creatures.get(s).remove(tokens[0]);
                }
            }
        }

        creatures.entrySet().stream().sorted((d1,d2)->{
            int n=Integer.compare(d2.getValue().size(),d1.getValue().size());
            return n;
        }).forEach(x-> System.out.println(x.getKey()+" : "+ x.getValue().size()));
    }
}
