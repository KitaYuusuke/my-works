package com.example.linebot.service;

import com.example.linebot.data.SongBattleLog;
import com.example.linebot.data.PersonLog;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import org.springframework.stereotype.Service;
import com.example.linebot.data.Blob;
import com.example.linebot.data.PersonAPI;
import org.springframework.core.io.Resource;
@Service
public class TotalService {

    //データ層：LINEのデータ格納領域にアクセスするクラス
    private Blob blob;
    //データ層：AWS EC2のプログラムにアクセスするクラス
    private  PersonAPI personAPI;
    //データ層：データベースのperson_logにアクセス
    private PersonLog personLog;
    //データ層：データベースのsongBattle_logにアクセス
    private SongBattleLog songBattleLog;
    //サービス層：歌バトル結果にアクセス
    private SongBattleService songBattleService;
    //サービス層：マツケンの勝率にアクセス
    private RateService rateService;

    public TotalService(Blob blob, PersonAPI personAPI, PersonLog personLog, SongBattleLog songBattleLog, SongBattleService songBattleservice, RateService rateService){
        this.blob = blob;
        this.personAPI = personAPI;
        this.personLog = personLog;
        this.songBattleLog = songBattleLog;
        this.songBattleService = songBattleservice;
        this.rateService = rateService;
    }

    public PersonResult whoPerson(MessageEvent<ImageMessageContent> event) throws Exception {
        //画像データを取得する
        Resource imageResource = blob.getImageResource(event);

        //マツケン判別を実行する
        PersonResponse personResponse = personAPI.callAPI(imageResource);

        //画像の人が誰かを保存
        personLog.insert(personResponse);

        //マツケンの勝率を計算
        RateResponse rateResponse = rateService.calcRate();

        //ビジネスサービス（顔認識）の処理結果を返す
        PersonResult personResult = new PersonResult(personResponse, rateResponse);
        return personResult;
    }

    public SongBattleResponse doBattle() throws Exception{

        //歌バトルを行う
        SongBattleResponse songBattleResponse = songBattleService.songBattle();

        songBattleLog.insert(songBattleResponse);

        return songBattleResponse;
    }



}
