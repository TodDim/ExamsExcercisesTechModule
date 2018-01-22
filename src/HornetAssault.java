import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> bees= Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> hornets= Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int hornetPower = hornets.stream().mapToInt(Integer::intValue).sum();

        int result=0;
        while (bees.size()>0&&hornets.size()>0) {
            result=0;
            if (bees.get(0)>=hornetPower){
                result=bees.get(0)-hornetPower;
                if (result!=0){
                    System.out.print(result+" ");
                }
                bees.remove(0);
                    hornets.remove(0);
                    hornetPower = hornets.stream().mapToInt(Integer::intValue).sum();

            }
            else{
                bees.remove(0);
            }
        }
        if (result==0&&hornets.size()>0){
            for (int i = 0; i <hornets.size() ; i++) {
                System.out.print(hornets.get(i)+" ");
            }
//            System.out.println( hornets.toString()
//                    .replace(",", "")  //remove the commas
//                    .replace("[", "")  //remove the right bracket
//                    .replace("]", "")  //remove the left bracket
//                    .trim()
//            );
        }
        else if (bees.size()>0){
            for (int i = 0; i <bees.size() ; i++) {
                   System.out.print(bees.get(i)+" ");
            }
//            System.out.println( bees.toString()
//                    .replace(",", "")  //remove the commas
//                    .replace("[", "")  //remove the right bracket
//                    .replace("]", "")  //remove the left bracket
//                    .trim()
//            );
        }
    }
}