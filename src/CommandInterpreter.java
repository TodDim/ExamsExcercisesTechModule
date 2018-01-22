import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommandInterpreter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        String command = reader.readLine();
        while (!command.equals("end")) {
        String[] commandTokens=command.split(" ");
        switch (commandTokens[0]){
            case "reverse":
            Reverse(Integer.parseInt(commandTokens[2]),Integer.parseInt(commandTokens[4]),tokens);
            break;
            case "sort":
                Sort(Integer.parseInt(commandTokens[2]),Integer.parseInt(commandTokens[4]),tokens);
                break;
            case "rollLeft":
                Rowleft(Integer.parseInt(commandTokens[1]),tokens);
                break;
            case "rollRight":
                Rollright(Integer.parseInt(commandTokens[1]),tokens);
                break;

        }
        command=reader.readLine();
        }
        System.out.println(Arrays.toString(tokens));

    }

    private static String[] Rollright(int times, String[] s1) {
        for (int j = 0; j < times; j++) {
            for (int i = s1.length-1; i >0 ; i--) {
                String x =s1[i];
                s1[i]=s1[i-1];
                s1[i-1]=x;
            }
    }
        return s1;
    }

    private static String[] Rowleft(int times, String[] s1) {
        for (int j = 0; j < times; j++) {
            for (int i = 0; i < s1.length-1; i++) {
                String x = s1[i];
                s1[i] = s1[i + 1];
                s1[i+1]=x;
            }
        }
        return s1;
    }
    private static String[] Sort(int start, int count, String[] s1) {
        try {
            if (count<0||start<0||start+count>s1.length-1){
                System.out.println("Invalid input parameters.");
                return s1;
            }

            String[] newArray = Arrays.copyOfRange(s1, start, start+count);
            Arrays.sort(newArray);
            for (int i = 0; i <count ; i++) {
                s1[start+i]=newArray[i];
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid input parameters.");
            return s1;
        }
        return s1;
    }

    private static String[] Reverse(int start, int count,String[] s1) {
        try {
            if (count<0||start>s1.length-1||start<0){
                System.out.println("Invalid input parameters.");
                return s1;
            }
            for (int i = 0; i <count/2 ; i++) {
                String member=s1[start+i];
                s1[start+i]=s1[start+count-1-i];
                s1[start+count-1-i]=member;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid input parameters.");
            return s1;
        }
        return s1;
    }
}