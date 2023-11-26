<?php 
#初期化したりする
$ikku_array = array();
$error_message = array();
require 'check.php';
$check = new CheckClass();

#データベースと接続
try {
    $dbh = new PDO('mysql:host=db;dbname=haiku_db',"root","root");
} catch (PDOException $e) {
    echo $e->getMessage();
}

#ボタンが押されたら
if(!empty($_POST["btn"])){
    $date = date("Y-m-d H:i:s");

    #俳句がひらがなのみかチェック
    if($check->hiragana_check($_POST["frontIkku"],$_POST["middleIkku"],$_POST["backIkku"]) === 1){
        $error_message[] = "使用文字は平仮名だけでお頼み申しあげます";
    }
    #俳句が拗音を1文字でカウントして575がチェック
    if($check->komozi_check($_POST["frontIkku"],$_POST["middleIkku"],$_POST["backIkku"]) === 1){
        $error_message[] = "文字数は５７５でお願い申し上げます（イ行+「ゃ、ゅ、ょ」は一文字）";
    }
    #俳句をスペースをはさんで結合
    $comment_Ikku = $_POST["frontIkku"]." ".$_POST["middleIkku"]." ".$_POST["backIkku"];

    #名前が空なら勝手に名前を付ける
    if(empty($_POST["username"])){
        $_POST["username"] = "名無しの芭蕉";
    }

    #エラーが無かったらデータベースに加える
    if(empty($error_message)){
        try{
            $stmt = $dbh->prepare("INSERT INTO `basyo_info` (`username`, `comment`, `date`) VALUES (:username, :comment, :date)");
            $stmt->bindParam(':username', $_POST["username"], PDO::PARAM_STR);
            $stmt->bindParam(':comment', $comment_Ikku, PDO::PARAM_STR);
           $stmt->bindParam(':date', $date, PDO::PARAM_STR);

           $stmt->execute();
        } catch(PDOException $e){
            echo $e->getMessage();
        }
    }
}

#sqlのbasyo_infoテーブルに入っているデータを全て$ikku_arrayに入れる
$sql = "SELECT `id`, `username`, `comment`, `date` FROM `basyo_info`;";
$ikku_array = $dbh->query($sql);

$dbh = null;

?>