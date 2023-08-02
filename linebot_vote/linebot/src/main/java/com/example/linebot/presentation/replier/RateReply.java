package com.example.linebot.presentation.replier;

import com.example.linebot.service.RateResponse;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class RateReply implements Replier{
    public static final String MESSAGE_FORMAT = "得票率\nマツケン：%d％\n氷川きよし：%d％";
    private RateResponse rateResponse;
    private int matsuRate;
    private int kiyoRate;

    public RateReply(RateResponse rateResponse){
        this.rateResponse = rateResponse;
        this.matsuRate = rateResponse.winRate();
        this.kiyoRate = 100 - matsuRate;
    }

    @Override
    public Message reply(){
        String message = String.format(MESSAGE_FORMAT, this.matsuRate, this.kiyoRate);
        return new TextMessage(message);
    }





}
