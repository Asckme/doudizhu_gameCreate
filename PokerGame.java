package doudizhu_program;

import java.util.*;

//"♦", "♣", "♥", "♠"
//        "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"

public class PokerGame {

    //牌盒
    static ArrayList<Integer> list = new ArrayList<>();//存牌的序号
    static Map<Integer,String> hm = new HashMap<>();

    //1.准备牌


    static {//随着类的加载而加载的，而且只执行一次，保证了每次只发一副牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //序号
        int serialNumber = 1;

        for (String n : number) {

            for (String c : color) {
                hm.put(serialNumber,c+n);
                list.add(serialNumber);
                serialNumber++;
            }
        }

        //大小王添加：
        hm.put(serialNumber,"小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber,"大王");
        list.add(serialNumber);


    }

    public PokerGame(){

        //2.洗牌
        Collections.shuffle(list);

        //3.发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 =new TreeSet<>();
        TreeSet<Integer> player2 =new TreeSet<>();
        TreeSet<Integer> player3 =new TreeSet<>();

        for(int i=0;i<list.size();i++){

            //i表示集合中索引，list.get(i)元素：表示排的序号
            int serialNumber = list.get(i);

            if(i<=2){
                lord.add(serialNumber);
                continue;
            }
            //分批进行循环发放
            if(i%3==0){
                player1.add(serialNumber);
            }
            else if(i%3==1){
                player2.add(serialNumber);
            }
            else {
                player3.add(serialNumber);
            }


        }

        //4.看牌
        lookPoker("底牌",lord);
        lookPoker("李白",player1);
        lookPoker("不周山",player2);
        lookPoker("杜甫",player3);




    }
        //4.看牌
    public void lookPoker(String name,TreeSet<Integer> list){
        System.out.print(name+": ");
        for (Integer serialNumber : list) {
            String poker = hm.get(serialNumber);
            System.out.print(poker+" ");
        }
        System.out.println();
    }


}
