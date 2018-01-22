import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Snowballs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BigDecimal bestBall=new BigDecimal(0);
        short bestsnowballSnow=0;
        short bestsnowballTime=0;
        byte bestsnowballQuality=0;

        for (int i = 0; i <n ; i++) {
            BigDecimal power=new BigDecimal(0);
            short snowballSnow  = Short.parseShort(reader.readLine());
            short snowballTime  = Short.parseShort(reader.readLine());
            byte snowballQuality  = Byte.parseByte(reader.readLine());

            power=new BigDecimal(Math.pow((snowballSnow/snowballTime),snowballQuality));
            if (power.compareTo(bestBall)>0){
                bestBall=power;
                bestsnowballSnow=snowballSnow;
                bestsnowballTime=snowballTime;
                bestsnowballQuality=snowballQuality;
            }
        }
        System.out.println(bestsnowballSnow+" : "+bestsnowballTime+ " = "+bestBall+ " ("+bestsnowballQuality+")");
    }
}