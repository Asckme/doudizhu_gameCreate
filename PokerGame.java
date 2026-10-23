package doudizhu_program;

import java.util.ArrayList;
import java.util.Collections;

//"♦", "♣", "♥", "♠"
//        "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"

public class PokerGame {

    //牌盒
    static ArrayList<String> list = new ArrayList<>();


    //1.准备牌


    static {//随着类的加载而加载的，而且只执行一次，保证了每次只发一副牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};




        //添加
        for (String c : color) {//花色
            for (String n : number) {//数字
                list.add(c+n);
            }
        }
        //大小王
        list.add("大王");
        list.add("小王");


    }

    public PokerGame(){

        //2.洗牌
        Collections.shuffle(list);

        //3.发牌
        ArrayList<String> lord =new ArrayList<>();
        ArrayList<String> player1 =new ArrayList<>();
        ArrayList<String> player2 =new ArrayList<>();
        ArrayList<String> player3 =new ArrayList<>();

        for(int i=0;i<list.size();i++){
            String poker = list.get(i);
            if(i<=2){
                lord.add(poker);
                continue;
            }
            //分批进行循环发放
            if(i%3==0){
                player1.add(poker);
            }
            else if(i%3==1){
                player2.add(poker);
            }
            else {
                player3.add(poker);
            }


        }

        //4.看牌
        lookPoker("底牌",lord);
        lookPoker("李白",player1);
        lookPoker("不周山",player2);
        lookPoker("杜甫",player3);




    }
        //4.看牌
    public void lookPoker(String name,ArrayList<String> list){
        System.out.print(name+": ");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }


}
