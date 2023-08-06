package Prepare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;


public class Prepare1 {
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    //准备牌
    static {
        String[] color = {"♠", "♥", "♦", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int th = 1;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                hm.put(th, color[j] + number[i]);
                list.add(th);
                th++;
            }
        }
        hm.put(th, "小王");
        list.add(th);
        th++;
        hm.put(th, "大王");
        list.add(th);


    }

    public Prepare1() {
        //洗牌
        Collections.shuffle(list);
        //发牌
        TreeMap<Integer, String> squire = new TreeMap<>();
        TreeMap<Integer, String> player1 = new TreeMap<>();
        TreeMap<Integer, String> player2 = new TreeMap<>();
        TreeMap<Integer, String> player3 = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) squire.put(list.get(i), hm.get(list.get(i)));
            else if (i % 3 == 0) player1.put(list.get(i), hm.get(list.get(i)));
            else if (i % 3 == 1) player2.put(list.get(i), hm.get(list.get(i)));
            else player3.put(list.get(i), hm.get(list.get(i)));
        }
        squire.forEach((Integer integer, String s)-> System.out.print(s+" "));
        System.out.println();
        player1.forEach((Integer integer, String s)-> System.out.print(s+" "));
        System.out.println();
        player2.forEach((Integer integer, String s)-> System.out.print(s+" "));
        System.out.println();
        player3.forEach((Integer integer, String s)-> System.out.print(s+" "));

    }

}
