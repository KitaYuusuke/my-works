package com.example.linebot.data;

import com.example.linebot.service.AvgsResponse;
import com.example.linebot.service.SongBattleResponse;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongBattleLog {

    //Spring Frameworkのデータベース接続ライブラリを利用する
    private JdbcTemplate jdbcTemplate;

    //Spring Frameworkのデータベース接続ライブラリを初期化する
    public SongBattleLog(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //janken_logテーブルにJankenResponseのデータを記録する（永続化）
    //戻り値のnは、データベースに記録できた行数
    public int insert(SongBattleResponse response) {
        String sql = "insert into songBattle_log VALUES (?, ?, ?)";
        int n = jdbcTemplate.update(
                sql, response.matsu(), response.kiyo(), response.kekka()
        );
        return n;
    }

    //janken_logテーブルに記録された全てのデータをJankenResponseのリストとして取得する
    public List<SongBattleResponse> selectAll(){
        String sql = "select matsu, kiyo, kekka from songBattle_log";
        List<SongBattleResponse> selected
                = jdbcTemplate.query(sql, new DataClassRowMapper<>(SongBattleResponse.class));
        return selected;
    }

    public List<AvgsResponse> avgPoints(){
        String sql = "select avg(matsu) as matsu_avg, avg(kiyo) as kiyo_avg from songBattle_log";
        List<AvgsResponse> avgs = jdbcTemplate.query(sql, new DataClassRowMapper<>(AvgsResponse.class));

        return avgs;
    }
}
