import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HornetArmada {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> legionAndActivity = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String,Integer>> legionAndSoldierAndCount = new LinkedHashMap<>();
        int n=Integer.parseInt(reader.readLine());

        for (int i = 0; i <n ; i++) {
            List<String> inputTokens = Arrays.stream(reader.readLine().split("( = )|( -> )|:")).collect(Collectors.toList());
            if (legionAndActivity.containsKey(inputTokens.get(1))){
                if (legionAndActivity.get(inputTokens.get(1))<Integer.parseInt(inputTokens.get(0))){
                    legionAndActivity.put(inputTokens.get(1),Integer.parseInt(inputTokens.get(0)));
                }
            }
            legionAndActivity.putIfAbsent(inputTokens.get(1),Integer.parseInt(inputTokens.get(0)));



            legionAndSoldierAndCount.putIfAbsent(inputTokens.get(1),new LinkedHashMap<>());
            if (legionAndSoldierAndCount.get(inputTokens.get(1)).containsKey(inputTokens.get(2))){

                legionAndSoldierAndCount.get(inputTokens.get(1)).put(inputTokens.get(2),legionAndSoldierAndCount.get(inputTokens.get(1)).get(inputTokens.get(2))+Integer.parseInt(inputTokens.get(3)));
            }

            legionAndSoldierAndCount.get(inputTokens.get(1)).putIfAbsent(inputTokens.get(2),Integer.parseInt(inputTokens.get(3)));
        }
        String[] out=reader.readLine().split("\\\\");

        if (out.length>1){

            LinkedHashMap<String, Integer> filterdlegionAndActivity = new LinkedHashMap<>();
            for (Map.Entry<String, LinkedHashMap<String, Integer>> e : legionAndSoldierAndCount.entrySet()) {
                if (e.getValue().keySet().contains(out[1])&&legionAndActivity.get(e.getKey())<Integer.parseInt(out[0])){
                    filterdlegionAndActivity.putIfAbsent(e.getKey(),e.getValue().get(out[1]));
                }
            }

            filterdlegionAndActivity.entrySet().stream().sorted((d1,d2)->{
                int m=Integer.compare(d2.getValue(),d1.getValue());
                return m;
            }).forEach(x-> System.out.println(x.getKey()+" -> "+ x.getValue()));
        }
        else{
            legionAndActivity.entrySet().stream().sorted((d1,d2)->{
                int m=Integer.compare(d2.getValue(),d1.getValue());
                return m;
            }).forEach(x-> System.out.println(x.getValue()+" : "+ x.getKey()));
        }

    }
}