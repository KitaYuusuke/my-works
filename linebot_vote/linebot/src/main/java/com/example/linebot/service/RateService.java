package com.example.linebot.service;

import com.example.linebot.data.PersonLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    private PersonLog personLog;
    private int winRate;
    private float getRate;
    private int resultGetRate;
    private int listSize;

    public RateService(PersonLog personLog){
        this.personLog = personLog;
    }

    public RateResponse calcRate(){
        List<PersonResponse> rateResponses = personLog.selectAll();
        winRate = 50;

        for(PersonResponse rateResponse : rateResponses){
            //顔がマツケンで、勝率が100%より小さかったらマツケンの勝率をあげる
            if(rateResponse.person() == 1){
                if(winRate < 100) {
                    winRate += 25;
                }
            }
            //顔がきよしで、勝率が0%より大きかったらマツケンの勝率を下げる
            else if (rateResponse.person() == 2) {
                if(winRate > 0) {
                    winRate -= 25;
                }
            }
        }
        //マツケンの勝率を返す
        RateResponse rateResponse = new RateResponse(this.winRate);
        return rateResponse;
    }

    public RateResponse voteRate(){
        getRate = 0;
        List<PersonResponse> rateResponses = personLog.selectAll();
        listSize = rateResponses.size();
        for(PersonResponse rateResponse : rateResponses){
            if(rateResponse.person() == 1){
                getRate += 1;
            }
        }
        getRate = getRate / (float)listSize * 100;
        resultGetRate = (int)getRate;
        RateResponse rateResponse = new RateResponse(this.resultGetRate);
        return rateResponse;
    }

}
