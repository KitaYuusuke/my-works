package com.example.linebot.data;

import com.example.linebot.service.PersonResponse;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class PersonAPI {

    //EC2の画像の送付先 application.properties ファイルから読み込まれる
    @Value("${person.api.url}")
    private String API_URL;

    //Springの機能を使って、HTTPの要求メッセージを作成する
    //(ブラウザに相当する)
    private final RestTemplate restTemplate;

    public PersonAPI(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public PersonResponse callAPI(Resource imageResource){

        //HTTPのヘッダに、"multipart/form-data"でデータを送信することを設定する
        //(HTMLの<form ...>に対応する)
        HttpHeaders formHeaders = new HttpHeaders();
        formHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        //本来はHTTPのPOSTは複数の値を送ることができるので、Mapで送信データを定義する
        //(HTMLの<input ... />に対応する)
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("face", imageResource);

        //HTTPの要求メッセージを作成し、API_URLにPOSTする
        //取得できるデータ(JSON)の形は、PersonResponseに格納できるという想定で行う
        //(HTMLで、FORMの送信ボタンが押された後のブラウザの処理に相当する)
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(map, formHeaders);
        ResponseEntity<PersonResponse> response = restTemplate.postForEntity(API_URL, formEntity, PersonResponse.class);

        //HTTPｍｐ返答メッセージから、画像データを取得する
        //(HTMLで、ブラウザの画像が表示されたことに対応する)
        return response.getBody();
    }
}
