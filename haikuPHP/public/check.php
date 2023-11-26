<?php
class CheckClass{

    #判定用の数字を初期化＋拗音をリストに入れる
    private $check_error_hira = 0;
    private $check_error_komo = 0;
    private $komozi_array = array("きゃ", "きゅ", "きょ", "しゃ", "しゅ", "しょ", "ちゃ", "ちゅ", "ちょ", "にゃ", "にゅ", "にょ", "ひゃ", "ひゅ", "ひょ", "みゃ", "みゅ", "みょ", "りゃ", "りゅ", "りょ", "ぎゃ", "ぎゅ", "ぎょ", "じゃ", "じゅ", "じょ", "びゃ", "びゅ", "びょ", "ぴゃ". "ぴゅ", "ぴょ");

    #俳句にひらがなが入っているかチェックする
    public function hiragana_check($str1,$str2,$str3){

        #正規表現でチェックし、ひらがな以外があったらフラグを立てる
        #このやり方はあまりよくないらしいが他に思いつかず...
        if (!preg_match('/^[ぁ-ゞ]+$/u', $str1)) {
        	$this->check_error_hira = 1;
        }

        if (!preg_match('/^[ぁ-ゞ]+$/u', $str2)) {
        	$this->check_error_hira = 1;
        }

        if (!preg_match('/^[ぁ-ゞ]+$/u', $str3)) {
        	$this->check_error_hira = 1;
        }
        
        return $this->check_error_hira;
    }

    #拗音を1文字としてカウントし、俳句が575かチェックするところ
    public function komozi_check($str1,$str2,$str3){

        $this->komozi_check_work(5,$str1);
        $this->komozi_check_work(7,$str2);
        $this->komozi_check_work(5,$str3);

        return $this->check_error_komo;
    }

    #実際にチェックしているところ
    public function komozi_check_work($fiveSeven, $str){

        #拗音の数をカウントする変数
        $komozi_count = 0;
        foreach($this->komozi_array as $komozi){
            #俳句に含まれている拗音の数をカウント
            $komozi_count += mb_substr_count($str, $komozi);
        }
        #俳句（575のうちの1つ）の文字数から拗音の数を引いて575に一致していなかったらフラグを立てる
        #例：「きょうのあさ」->6文字　は、拗音を1文字とすると5文字なのでフラグは立たない
        if(mb_strlen($str, 'UTF-8') - $komozi_count !== $fiveSeven){
            $this->check_error_komo = 1;
        }

    }

}