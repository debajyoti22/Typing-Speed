import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.*;
class wpm{

    // static String words[] = {"envelope","cantelope","the","hello","microphone","elephant","biscuit","hammer","went","cap"};

    static int check(String input1,String input2) {
        String words1[] = input1.trim().split("\\s+");
        String words2[] = input2.trim().split("\\s+");
        List<String>list1 = new ArrayList<>(Arrays.asList(words1));
        List<String>list2 = Arrays.asList(words2);
        list1.retainAll(list2);
        return list1.size();
        }


    public static void main(String args[]) throws InterruptedException
    {
        System.out.print("Get ");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("Set ");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Go ");
        TimeUnit.SECONDS.sleep(1);
        Random rand = new Random();

        String parent="";
        for(int i=0;i<10;i++){     
        String c = data.words[rand.nextInt(49)];   
        System.out.print(c +" ");
        parent = parent + c + " ";
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------");

        double start = LocalTime.now().toNanoOfDay();
        Scanner sc = new Scanner(System.in);

        String user = sc.nextLine();

        double end = LocalTime.now().toNanoOfDay();
        double time = (end-start)/1000000000.0;

        int numchar = user.length();
        int wpm = (int) ((((double) numchar/5) / time) * 60 ) ;

        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Wpm is "+wpm+ " ");
        if(wpm>150)
        System.out.println("You are superhuman !!");
        else if(wpm>100)
        System.out.println("You faster than 98% !!");
        else if(wpm>50)
        System.out.println("You faster than 50% !!");
        else if(wpm>30)
        System.out.println("Well thats decent !!");
        else
        System.out.println("Needs Practise !!");
        System.out.println();

        int accuracy = check(parent,user);
        System.out.println("Your Accuracy is "+(accuracy*10)+" %");
        System.out.println();
    }
}
