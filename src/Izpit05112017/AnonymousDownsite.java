package Izpit05112017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AnonymousDownsite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte n=Byte.parseByte(reader.readLine());
        BigDecimal securityKEy=new BigDecimal(reader.readLine());
        BigDecimal sum=BigDecimal.ZERO;
        for (int i = 0; i <n ; i++) {
          String[] inputTokens=reader.readLine().split(" ");
          sum=sum.add(new BigDecimal(inputTokens[1]).multiply(new BigDecimal(inputTokens[2])));
          System.out.println(inputTokens[0]);

        }
        NumberFormat nf = new DecimalFormat("##.###");
        System.out.printf("Total Loss: %.20f%n",sum);
        securityKEy=securityKEy.pow(n);
        System.out.println("Security Token: "+nf.format(securityKEy));

    }
}
