package com.example.linebot.presentation;

import com.example.linebot.presentation.replier.*;
import com.example.linebot.service.*;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.MessageEvent;

import java.util.List;

@LineMessageHandler
public class Callback {

    private static final Logger log = LoggerFactory.getLogger(Callback.class);
    private TotalService totalService;
    private CalcService calcService;
    private RateService rateService;


    public Callback(TotalService totalService, CalcService calcService, RateService rateService) {
        this.totalService = totalService;
        this.calcService = calcService;
        this.rateService = rateService;
    }

    // フォローイベントに対応する
    @EventMapping
    public Message handleFollow(FollowEvent event) {
        // 実際はこのタイミングでフォロワーのユーザIDをデータベースにに格納しておくなど
        Follow follow = new Follow(event);
        return follow.reply();
    }

    // 文章で話しかけられたとき（テキストメッセージのイベント）に対応する
    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) throws Exception {
        TextMessageContent tmc = event.getMessage();
        String text = tmc.getText();
        switch (text){
            case "バトル":
                SongBattleResponse songBattleResponse = totalService.doBattle();
                return new BattleReply(songBattleResponse).reply();
            case "集計":
                CalcResponse calcResponse = calcService.calcAvgRate();
                return new CalcReply(calcResponse).reply();
            case "得票率":
                RateResponse rateResponse = rateService.voteRate();
                return new RateReply(rateResponse).reply();

        }

        return new TextMessage("おうち帰りたい～");
    }

    @EventMapping
    public List<Message> handlePerson(MessageEvent<ImageMessageContent> event)
            throws Exception{
        //じゃんけんを実施するビジネスサービス層のクラスを呼び出す
        PersonResult personResult = totalService.whoPerson(event);

        return List.of(new SongReply(personResult).reply(),
                new PersonReply(personResult).reply());
    }

}
