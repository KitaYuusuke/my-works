package com.example.linebot.presentation.replier;

import com.example.linebot.service.SongBattleResponse;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class BattleReply implements Replier{

    public static final String MESSAGE_FORMAT = "歌バトル結果\nマツケン：%d点\n氷川きよし：%d点\n\n%s　%s!!!!!";
    private int matsu;
    private int kiyo;
    private String whoWin;
    private String kekka;

    public BattleReply(SongBattleResponse songBattleResponse){
        this.matsu = songBattleResponse.matsu();
        this.kiyo = songBattleResponse.kiyo();

        if(songBattleResponse.kekka() == 0){
            this.whoWin = "マツケン";
            this.kekka = "WIN";
        }
        else if(songBattleResponse.kekka() == 1){
            this.whoWin = "なんと";
            this.kekka = "同点";
        }
        else {
            this.whoWin = "氷川きよし";
            this.kekka = "WIN";
        }
    }

    @Override
    public Message reply(){
        String message = String.format(MESSAGE_FORMAT, this.matsu, this.kiyo, this.whoWin, this.kekka);
        return new TextMessage(message);
    }
}
