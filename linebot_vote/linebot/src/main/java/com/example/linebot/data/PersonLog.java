package com.example.linebot.data;

import com.example.linebot.service.PersonResponse;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonLog {

    //Spring Frameworkのデータベース接続ライブラリを利用する
    private JdbcTemplate jdbcTemplate;

    //Spring Frameworkのデータベース接続ライブラリを初期化する
    public PersonLog(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //person_logテーブルにPersonResponseのデータを記録する（永続化）
    //戻り値のnは、データベースに記録できた行数
    public int insert(PersonResponse response) {
        String sql = "insert into person_log VALUES (?)";
        int n = jdbcTemplate.update(
                sql, response.person()
        );
        return n;
    }

    //person_logテーブルに記録された全てのデータをPersonResponseのリストとして取得する
    public List<PersonResponse> selectAll(){
        String sql = "select person from person_log";
        List<PersonResponse> selected
                = jdbcTemplate.query(sql, new DataClassRowMapper<>(PersonResponse.class));
        return selected;
    }
}
