import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CoffeeOrders {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy", Locale.getDefault());
        Calendar orderDate = Calendar.getInstance();
        BigDecimal sum = BigDecimal.ZERO;
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            BigDecimal price = new BigDecimal(reader.readLine());
            orderDate.setTime(format.parse(reader.readLine()));
            long count = Long.parseLong(reader.readLine());
            int numDays = orderDate.getActualMaximum(Calendar.DATE);
            price = ((new BigDecimal(numDays)).multiply(new BigDecimal(count))).multiply(price);
            sum = sum.add(price);
            System.out.printf("The price for the coffee is: $%.2f%n",price);
        }
            System.out.printf("Total: $%.2f" ,sum);
    }
}