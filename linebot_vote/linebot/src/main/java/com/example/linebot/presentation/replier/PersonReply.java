package com.example.linebot.presentation.replier;

import com.example.linebot.service.PersonResult;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class PersonReply implements Replier{

    public static final String MESSAGE_FORMAT = "%sの勝率は%d％になりました！";

    private String person;
    private int winRate;

    public PersonReply(PersonResult personResult){
        if(personResult.personResponse().person() == 1){
            this.person = "マツケン";
        }
        else if (personResult.personResponse().person() == 2) {
            this.person = "氷川きよし";
        }

        if(personResult.personResponse().person() == 1) {
            this.winRate = personResult.rateResponse().winRate();
        }
        else if (personResult.personResponse().person() == 2) {
            this.winRate = 100 - personResult.rateResponse().winRate();
        }
    }

    @Override
    public Message reply(){
        String message = String.format(MESSAGE_FORMAT, this.person, this.winRate);
        return new TextMessage(message);
    }

}
