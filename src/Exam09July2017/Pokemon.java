package Exam09July2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pokemon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int pokePowerN=Integer.parseInt(reader.readLine());
        int distanceM=Integer.parseInt(reader.readLine());
        byte exhaustionFactorY=Byte.parseByte(reader.readLine());
        int count=0;
        int newPokerPower=pokePowerN;
        while (newPokerPower>=distanceM){
            newPokerPower-=distanceM;
            count++;
            if (newPokerPower==pokePowerN/2&& exhaustionFactorY!=0){
                newPokerPower/=exhaustionFactorY;
            }
        }
        System.out.println(newPokerPower+System.lineSeparator()+count);

    }
}
