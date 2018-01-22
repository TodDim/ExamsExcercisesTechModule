import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningTicket {
    public static String[] removeEmptyEntries(String[] collection) {
        ArrayList<String> nonEmpty = new ArrayList<String>();
        for (String o : collection) {
            if (o.length() > 0) {
                nonEmpty.add(o);
            }
        }
        String[] results = new String[nonEmpty.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = nonEmpty.get(i);
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputTokens = Arrays.stream(removeEmptyEntries(reader.readLine().split("[,| ]"))).collect(Collectors.toList());
        for (int i = 0; i < inputTokens.size(); i++) {
            if (inputTokens.get(i).length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            int countOfEquals = 0;
            char valueOFMaxEquals=0;
            int countOfMaxSequence=0;

            int countOfEqualsR = 0;
            char valueOFMaxEqualsR=0;
            int countOfMaxSequenceR=0;

            for (int j = 1; j <=inputTokens.get(i).length()/2 ; j++) {

                char ch=inputTokens.get(i).charAt(j);
                char chm1=inputTokens.get(i).charAt(j-1);

                if (ch != chm1){
                    countOfEquals=1;
                }
                else if (ch == chm1&&(ch=='@'||ch=='#'||ch=='$'||ch=='^')) {
                    countOfEquals++;

                }
                if (countOfEquals>countOfMaxSequence){
                    countOfMaxSequence=countOfEquals;
                    valueOFMaxEquals=ch;
                }

                char ch2=inputTokens.get(i).charAt(inputTokens.get(i).length()-j);
                char ch2m1=inputTokens.get(i).charAt(inputTokens.get(i).length()-j-1);
                if (ch2 != ch2m1){
                    countOfEqualsR=1;
                }
                else if (ch2 == ch2m1&&(ch2=='@'||ch2=='#'||ch2=='$'||ch2=='^')) {
                    countOfEqualsR++;

                }
                if (countOfEqualsR>countOfMaxSequenceR){
                    countOfMaxSequenceR=countOfEqualsR;
                    valueOFMaxEqualsR=ch2;
                }

            }
            if (countOfMaxSequence>=6&&countOfMaxSequenceR>=6&&valueOFMaxEquals==valueOFMaxEqualsR&&(countOfMaxSequence==10||countOfMaxSequenceR==10)){
                System.out.println("ticket \""+ inputTokens.get(i)+"\" - "+countOfMaxSequence+valueOFMaxEquals+" Jackpot!");
                continue;
            }
            else if(countOfMaxSequence>=6&&countOfMaxSequenceR>=6&&valueOFMaxEquals==valueOFMaxEqualsR&&(countOfMaxSequence<10&&countOfMaxSequenceR<10)){
                System.out.println("ticket \""+ inputTokens.get(i)+"\" - "+countOfMaxSequence+valueOFMaxEquals);
            }
            else if((countOfMaxSequence==countOfMaxSequenceR&&countOfMaxSequence<6)||(valueOFMaxEquals!=valueOFMaxEqualsR)){
                System.out.println("ticket \""+ inputTokens.get(i)+"\" - "+"no match");
            }
            else{
                System.out.println("invalid ticket");
            }

        }
    }
}

