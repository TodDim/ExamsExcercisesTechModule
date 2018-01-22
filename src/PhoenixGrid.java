import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoenixGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        final String regex = "([^\\s_\\.]{3})\\.?([^\\s_\\.]{3}\\.?)*";
        Pattern pattern = Pattern.compile(regex);
        String input="";
        while (!(input=reader.readLine()).equals("ReadMe")){
            Matcher matcher = pattern.matcher(input);
//            System.out.println(matcher.group(0));
            if (matcher.matches()) {

                boolean sym=true;
                outerloop:{
                    String[] inputTokens= input.split("\\.");
                    for (int i = 0; i <=inputTokens.length/2; i++) {
                        char [] chars1=inputTokens[i].toCharArray();
                        char [] chars2=inputTokens[inputTokens.length-1-i].toCharArray();
                        for (int j = 0; j <chars1.length ; j++) {
                            if (chars1[j]!=chars2[chars1.length-1-j]) {
                                sym = false;
                                System.out.println("NO");
                                break outerloop;
                            }
                        }
                    }
                }

                if (sym==true){
                    System.out.println("YES");
                }
            }
            else {
                System.out.println("NO");
            }
        }
    }
}