package com.example.linebot.data;


import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import com.linecorp.bot.client.LineBlobClient;
import com.linecorp.bot.client.MessageContentResponse;
import java.io.InputStream;

@Repository
public class Blob {

        //LINEの画像保存場所にアクセスするためのクラス
        //（専用のブラウザのようなもの）
        private LineBlobClient blob;

        public Blob(LineBlobClient blob){
            this.blob = blob;
        }

        public Resource getImageResource(MessageEvent<ImageMessageContent> event)
                throws Exception{
            //送られたLINEメッセージID(一つ一つの、メッセージにIDがついている)を取得する
            String msgId = event.getMessage().getId();

            //Blob(LINEの画像保存場所)からメッセージIDと対応する画像の取得準備をする
            MessageContentResponse contentResponse = blob.getMessageContent(msgId).get();

            try(InputStream is = contentResponse.getStream()){
                //画像をバイトデータとして取得する
                //画像が期限切れなどの場合には例外が発生する
                LINEImageResource resource = new LINEImageResource(is.readAllBytes());
                return resource;
            }
        }
}
