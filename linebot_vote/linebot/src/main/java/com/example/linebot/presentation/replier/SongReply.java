package com.example.linebot.presentation.replier;

import com.example.linebot.service.PersonResult;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class SongReply implements Replier{

    public static final String MESSAGE_FORMAT = "%s";
    private String song;
    public SongReply(PersonResult personResult){
        if(personResult.personResponse().person() == 1){
            this.song = "オーレ～！オーレ～！\nマ ツ ケ ン サ ン バ ！！！";
        }
        else if (personResult.personResponse().person() == 2) {
            this.song = "ズン ズンズン ズンドコ\nき　よ　し　！！！";
        }
    }

    @Override
    public Message reply(){
        String message = String.format(MESSAGE_FORMAT, this.song);
        return new TextMessage(message);
    }
}
