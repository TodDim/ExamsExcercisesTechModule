package Exam09July2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
//        char []input=reader.readLine().toCharArray();

        String didimonRegex = "[^a-zA-Z-]+";
        String bojomonRegex = "[a-zA-Z]+-[a-zA-Z]+";

        int index = 0;
        int count=1;
        int legthoffound=0;
        while (index < input.length()) {
            if (count%2==1){
                Pattern pattern = Pattern.compile(didimonRegex, Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(input.substring(index));
                if (matcher.find()) {
                    System.out.println( matcher.group(0));

                    index+=matcher.group(0).length()+(input.substring(index).indexOf(matcher.group(0)));
                }
                else {
                    return;
                }
            }
            else {
                Pattern pattern = Pattern.compile(bojomonRegex, Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(input.substring(index));
                if (matcher.find()) {
                    System.out.println( matcher.group(0));
                    index+=matcher.group(0).length()+(input.substring(index).indexOf(matcher.group(0)));
                }
                else {
                    return;
                }
            }
            count++;
        }
    }
}