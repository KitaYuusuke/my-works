package com.example.linebot.presentation.replier;

import com.example.linebot.service.CalcResponse;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class CalcReply implements Replier{

    public static final String MESSAGE_FORMAT = "集計\nマツケン平均点：%f点（勝率%f％）\n氷川きよし平均点：%f点（勝率%f％）";
    private float matsuAvg;
    private float kiyoAvg;
    private float matsuRate;
    private float kiyoRate;

    public CalcReply(CalcResponse calcResponse){
        this.matsuAvg = calcResponse.matsuAvg();
        this.kiyoAvg = calcResponse.kiyoAvg();
        this.matsuRate = calcResponse.matsuRate() * 100;
        this.kiyoRate = calcResponse.kiyoRate() * 100;
    }

    @Override
    public Message reply(){
        String message = String.format(MESSAGE_FORMAT, this.matsuAvg, this.matsuRate, this.kiyoAvg, this.kiyoRate);
        return new TextMessage(message);
    }


}
