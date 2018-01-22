package Exam09July2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> sequence= Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        long sum=0;
        while (sequence.size()>0){
            int index=Integer.parseInt(reader.readLine());
            if (index<0){
                int valueToAdd=sequence.get(0);
                sum+=valueToAdd;
                sequence.set(0,sequence.get(sequence.size()-1));
                for (int i = 0; i <sequence.size() ; i++) {
                    if (sequence.get(i)<=valueToAdd){
                        sequence.set(i,sequence.get(i)+valueToAdd);
                    }
                    else {
                        sequence.set(i,sequence.get(i)-valueToAdd);
                    }
                }
                continue;
            }
            else if (index>sequence.size()-1){
                int valueToAdd=sequence.get(sequence.size()-1);
                sum+=valueToAdd;
                sequence.set(sequence.size()-1,sequence.get(0));
                for (int i = 0; i <sequence.size() ; i++) {
                    if (sequence.get(i)<=valueToAdd){
                        sequence.set(i,sequence.get(i)+valueToAdd);
                    }
                    else {
                        sequence.set(i,sequence.get(i)-valueToAdd);
                    }
                }
                continue;
            }
            int valueToAdd=sequence.get(index);
            sum+=valueToAdd;
        sequence.remove(index);
            for (int i = 0; i <sequence.size() ; i++) {
                if (sequence.get(i)<=valueToAdd){
                    sequence.set(i,sequence.get(i)+valueToAdd);
                }
                else {
                    sequence.set(i,sequence.get(i)-valueToAdd);
                }
            }
        }

        System.out.println(sum);
    }
}