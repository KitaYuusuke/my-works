package com.example.linebot.service;

import com.example.linebot.data.SongBattleLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {

    private SongBattleLog songBattleLog;
    private float matsuAvg;
    private float kiyoAvg;
    private float matsuRate;
    private float kiyoRate;
    private float battleCount;
    private float winCount;

    public CalcService(SongBattleLog songBattleLog){
        this.songBattleLog = songBattleLog;
        AvgsResponse avgsResponses = songBattleLog.avgPoints().get(0);
        this.matsuAvg = avgsResponses.matsu_avg();
        this.kiyoAvg = avgsResponses.kiyo_avg();
    }

    public CalcResponse calcAvgRate(){

        List<SongBattleResponse> songBattleResponses = songBattleLog.selectAll();

        battleCount = songBattleResponses.size();

        winCount = 0;
        for(SongBattleResponse songBattleResponse : songBattleResponses){
            if(songBattleResponse.kekka() == 0){
                winCount += 1;
            }
        }
        if(battleCount != 0) {
            matsuRate = winCount / battleCount;
        }
        else{
            matsuRate = 0;
        }

        winCount = 0;
        for(SongBattleResponse songBattleResponse : songBattleResponses){
            if(songBattleResponse.kekka() == 2){
                winCount += 1;
            }
        }
        if(battleCount != 0) {
            kiyoRate = winCount / battleCount;
        }
        else{
            kiyoRate = 0;
        }

        CalcResponse calcResponse = new CalcResponse(this.matsuAvg, this.kiyoAvg, this.matsuRate, this.kiyoRate);
        return calcResponse;
    }
}
