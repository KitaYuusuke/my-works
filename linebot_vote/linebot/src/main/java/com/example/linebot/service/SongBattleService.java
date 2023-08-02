package com.example.linebot.service;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class SongBattleService {

    private RateService rateService;
    private int winRate;
    private int randRate;
    private int matsu;
    private int kiyo;
    private int kekka;

    public SongBattleService(RateService rateService){
        this.rateService = rateService;
    }

    public SongBattleResponse songBattle(){
        Random rand = new Random();
        winRate = rateService.calcRate().winRate();
        matsu = rand.nextInt(100) + 1; //歌の点数を決めておく
        kiyo = rand.nextInt(100) + 1;

        if(matsu > kiyo){
            kekka = 0; //マツケンの勝ち
        }
        else if(matsu == kiyo){
            kekka = 1; //同点
        }
        else{
            kekka = 2; //マツケンの負け
        }

        randRate = rand.nextInt(100) + 1;
        if((randRate <= winRate) && (kekka != 0)){ //マツケンの勝率内で、マツケンが勝っていなかった場合
            //きよしの点数操作
            kiyo = rand.nextInt(matsu-1) + 1;
            kekka = 0;
        }
        else if((randRate > winRate) && (kekka != 2)){ //きよしの勝率内で、マツケンが負けていなかった場合
            //マツケンの点数操作
            matsu = rand.nextInt(kiyo-1) + 1;
            kekka = 2;
        }

        return new SongBattleResponse(this.matsu, this.kiyo, this.kekka);

    }

}
