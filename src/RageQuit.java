import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RageQuit {
    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input=reader.readLine();
        List<String> inputTokens= Arrays.stream(input.split("[0-9]")).filter(x->x.length()>0).collect(Collectors.toList());
        List<String> repets= Arrays.stream(input.split("[^0-9]+")).filter(x->x.length()>0).collect(Collectors.toList());
        List<Character> chars=new ArrayList<>();
StringBuilder sb=new StringBuilder();
        for (int i = 0; i <inputTokens.size() ; i++) {
            for (Character x:inputTokens.get(i).toUpperCase().toCharArray()
                    ) {
                if (!chars.contains(x)){
                    chars.add(x);
                }

            }
            sb.append((repeat(inputTokens.get(i).toUpperCase(), Integer.parseInt(repets.get(i)))));
        }
        System.out.println("Unique symbols used: "+chars.size()+System.lineSeparator()+sb);
    }
}