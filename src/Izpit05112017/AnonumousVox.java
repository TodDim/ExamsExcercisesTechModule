package Izpit05112017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class AnonumousVox {
    public static String[] removeEmptyEntries (String[] collection){
        ArrayList<String> nonEmpty = new ArrayList<String>();
        for (String o : collection) {
            if (o.length() > 0) {
                nonEmpty.add(o);
            }
        }
        String[] results=new String[nonEmpty.size()];
        for (int i = 0; i < results.length; i++) {
            results[i]=nonEmpty.get(i);
        }
        return results;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([a-zA-Z]+)([ -~]+)\\1";
        String string = reader.readLine();
        List<String> placeholders= Arrays.stream(removeEmptyEntries(reader.readLine().split("[{\\|}]"))).collect(Collectors.toList());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        List<String> newsb=new ArrayList<>();
        List<String> nonmatched= Arrays.stream(string.split("([a-zA-Z]+)([ -~]+)\\1")).collect(Collectors.toList());

        int indexPlaceholder=0;
        while (matcher.find()) {
            if (indexPlaceholder<nonmatched.size()){
                newsb.add(nonmatched.get(indexPlaceholder));
            }
            newsb.add(matcher.group(1));
            newsb.add(placeholders.get(indexPlaceholder));
            newsb.add(matcher.group(1));

            indexPlaceholder++;
        }
        newsb.forEach(System.out::print);

    }

}
