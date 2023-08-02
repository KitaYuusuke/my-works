package com.example.linebot.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SongBattleResponse(int matsu, int kiyo, int kekka) {
}
