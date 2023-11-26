<!doctype html>
<html lang = "ja">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=devicewidth, initial-scale=1.0">
        <title>来たれ！芭蕉オンリー掲示板</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <!--dbに接続したり入力データをチェックしたりするworks.phpを読み込む-->
        <?php require "works.php"; ?>
        <h1 class="title">来たれ！芭蕉オンリー掲示板</h1>
        <!--ここにヘッダー画像を表示（なぜか同じフォルダ内にないと読み込まれない）-->
        <div class="headerImg"></div>
        <div class="board">
            <section>
                <!--ここでデータベース内の投稿を表示-->
                <?php foreach ($ikku_array as $ikku): ?>
                   <div class="nameArea">
                        <span>名前：</span>
                        <p class="username"><?php echo $ikku["username"]; ?></p>
                        <time>:<?php echo $ikku["date"]; ?></time>
                    </div>
                    <p class="ikku"><?php echo $ikku["comment"]; ?></p>
                <?php endforeach; ?>
            </section>
            <section>
                <div>
                    <!--入力ミスがあった場合、ここでミスの内容を表示-->
                    <?php if(!empty($error_message)): ?>
                        <div class="errorMessage">
                            <?php foreach($error_message as $error): ?>
                                <p><?php echo $error ?></p>
                            <?php endforeach; ?>
                        </div>
                    <?php endif; ?>    
                </div>
                <!--入力部分-->
                <form method="POST" action="" class="form">
                    <div>
                        <input type="submit" id="btn" name="btn" value="ここで一句">
                        <label for="">名前：</label>
                        <input type="text" name="username" placeholder="名無しの芭蕉">
                    </div>
                    <div>
                        <!--拗音（ゃゅょを含む語）を考慮してmaxlengthはminの2倍確保-->
                       <textarea name="frontIkku" minlength="5" maxlength="10" placeholder="ふるいけや"></textarea>
                        <textarea name="middleIkku" minlength="7" maxlength="14" placeholder="かわずとびこむ"></textarea>
                        <textarea name="backIkku" minlength="5" maxlength="10" placeholder="みずのおと"></textarea>
                    </div>
                </form>
            </section>
        </div>    
    </body>
</html>