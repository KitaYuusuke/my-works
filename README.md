# README
`my-works`は喜多佑介が今まで作ったものを紹介するリポジトリです。  
動作環境やだいたいの動作を書いています。  

# じゃばっくりさん
![javakkuri-gif](https://github.com/KitaYuusuke/my-works/assets/117000159/b3725514-77ec-4eec-9021-7ac9f0b1b2a8)  
画質が悪くてすいません（泣）  
- [じゃばっくりさんのコード](https://github.com/KitaYuusuke/my-works/tree/main/Jabakkuri-san/Jabakkuri)  
## 概要
ChatGPTみたいなものを作りたいなと思って作ったらいつの間にかこっくりさんになっていました。  
Javaで動くこっくりさんなのでじゃばっくりさんです。
## 動作環境
`IntelliJ IDEA 2023.1.4`
`Java`  
## 動作
`Main.java`を実行することで動作が始まります。  
しばらく説明書きがあった後に質問タイムになりますが**誰/食べ物/場所**という単語を入れた質問をしないとじゃばっくりさんは答えてくれません。  
じゃばっくりさんはこっくりさんよりも安全ですが圧倒的に語彙が少ないので、少し遊んだらネタ切れになります。遊び終わったら動作を終了してください。  
ゲームみたいに１文字ずつ文字が表示される演出がこだわりポイントです。  

# マツケンサンバルーレット
![matsuroulette-gif](https://github.com/KitaYuusuke/my-works/assets/117000159/5cc25ad0-fd3c-4061-b5c5-2753963748d5)  
- [マツケンサンバルーレットのコード](https://github.com/KitaYuusuke/my-works/tree/main/MatsukenSanba-Roulette)  
## 概要
**サ**と**ン**と**バ**の中から重複ありで3文字を抽出し、**サンバ**の文字列がそろえばアスキーアートが踊りだすプログラムです。  
サババやンサバなどのそろっていない文字列が出たら残念がります。  
## 動作環境
`Cygwin64 Terminal ver3.3.6-1`
`C言語`  
## 動作
> Do you play MATUKEN challenge ?

と聞かれるので`y`と答えると動作が始まります。  
どうしても踊りが見たいときは`sanba`と入力すれば確定で**サンバ**の文字列になるので試してみてください。  
アスキーアートの踊りは実際のマツケンサンバとはテンポが合わないので、音楽に関しては想像でお楽しみください。  
こだわりポイントはアスキーアートが踊るときにこれまでの表示を全削除して踊りだすところと、オーレ―のあとに手を横に伸ばすポーズを入れることで踊りがかわいくなったところです。  

# 勝手に占い巫女さん
![mikosan-gif](https://github.com/KitaYuusuke/my-works/assets/117000159/501dd0ac-c22d-4cd3-8587-8ca51deea4db)  
- [勝手に占い巫女さんのコード](https://github.com/KitaYuusuke/my-works/tree/main/Mikosan-Omikuzi)  
## 概要
猫耳っぽい巫女さんが突然現れて占ってくれます。  
最初期に作った、いろいろ試すためのものなのであまり書くことがありません。  
## 動作環境
`Cygwin64 Terminal ver3.3.6-1`
`C言語`  
## 動作
実行すると巫女さんが突然出てくるので、エンターキーを押すと話が進みます。  
エンターキーを押して場面を進める動作の勉強とおみくじシステムの勉強のために作りました。  

# 初等教育用四則演算ランダム生成
![配線図](https://github.com/KitaYuusuke/my-works/assets/117000159/8516f1d6-7254-4514-b690-616b334f4f35)  
- [初等教育用四則演算ランダム生成のスケッチ](https://github.com/KitaYuusuke/my-works/tree/main/basicArithmeticOperations)  
## 概要
Arduinoで動作する、**四則演算を無限にランダム生成**してくれるプログラムです。  
回答が正解なら**ピンポン**、不正解なら**ブー**の音が鳴ります。  
小学生用を想定しているので負の数は扱いません。小数も使って大丈夫かあまりわからなかったので一応あまりの表記にしています。  
## 動作環境
`Tinkercad`
`Arduino`  
## 動作
Tinkercadで配線図通りに回路を作って、右上の`コード`ボタンを押し、出てきた表示の左上のプルダウンから`ブロック`を`文字`に変えてスケッチをコピー＆ペーストし、シミュレーションを開始ボタンを押すと動作が始まります。  
lcdディスプレイにランダムな式が表示されるので、キーパッドで数字のキーを押して`#`ボタンで回答を決定すると**ピンポン**か**ブー**の音が流れます。  
`*`ボタンを押すことで回答を削除できるので間違えても安心です。  
自分のPCだと回答を重ねるごとに動作が重くなり、0.1秒で発せられる音が1秒かかって発せられていたのが不安ポイントです。  

# 投票歌バトルLINEボット
![LINEBOT](https://github.com/KitaYuusuke/my-works/assets/117000159/8609445b-1302-4f05-97b3-e146696abfbe)  
- [投票歌バトルLINEボットのコード](https://github.com/KitaYuusuke/my-works/tree/main/linebot_vote/linebot)  
## 概要
マツケンと氷川きよしの写真をLINEボットに送って歌バトルの勝率を上げ下げしたり、2人に歌バトルさせたりできます。  
AWSのEC2にあるサーバとやりとりして、rekognitionを使った自作のapiでマツケンと氷川きよしの顔を識別しています。やりとりしてるapiのコードは持って来る方法がわからなかったので掲載していません。  
## 動作環境
`IntelliJ IDEA 2023.1.4`
`AWS EC2`
`Java(LINEボット)`
`Python(サーバ/api)`  
## 動作
LINEボットにマツケンか氷川きよしの画像を送ることで、送られた方の歌バトルの勝率が25%上がります。  
`バトル`と送信することで1～100のランダムな数値を生成し、勝率を考慮して数値を決定してLINEに表示します。  
`集計`、`得票率`と送信するとデータベースに保存していた顔や勝負のデータを使って計算したさまざまなデータを送ってくれます。  
いままで作ってきたものの中で最も複雑なので作成は大変でしたが、サーバやデータベースを使うことができるようになって成長を感じます。  

# 英語音声8感情推定AI
![AI最終混合180エポック50](https://github.com/KitaYuusuke/my-works/assets/117000159/0f647861-0424-4cc3-981f-e42c79858451)  
- [英語音声8感情推定AIのコード](https://github.com/KitaYuusuke/my-works/blob/main/Pytorch_librosa_8%E6%84%9F%E6%83%85%E6%8E%A8%E5%AE%9A.ipynb)  
↑自分の画面だとなぜかコードが震えているので、もしかしたらうまく見えないかもしれません
## 概要
AIを作ってみたかったので、**英語音声を8感情に分類するAI**を作ってみました。  
`librosa`を用いてwavファイルから特徴量を抽出し、`LSTM`を用いて特徴量を時系列的に学習していきます。  
## 動作環境
`Google Colaboratory`
`Python`  
## 動作
全てのセルを実行すると1時間ぐらいかけて学習します。（エポック数と隠れ層を減らせば割とすぐ終わります）  
最終的に`グラフ`と`混同行列`に結果をまとめていますが、正解率が5割くらいまでしか上がりませんでした。ただ混同行列を見る限り対角線上の色が薄くなっているので、ある程度は学習できていると思います。 

# impressionAI
![impression_result](https://github.com/KitaYuusuke/my-works/assets/117000159/01741dca-43be-424e-991a-568065dfad54)  
- [impressionAIのコード](https://github.com/KitaYuusuke/my-works/blob/main/impressionAI.ipynb)  
## 概要
複数要素を学習するAIを作りたかったので、動画を入力し**画像と音声**から動画の印象を判定するAIを作成しました。  
動画面接で動画を送る前にこのAIで客観的に自分を見てみようというコンセプトです。  
上の[英語音声8感情推定AI](https://github.com/KitaYuusuke/my-works/blob/main/Pytorch_librosa_8%E6%84%9F%E6%83%85%E6%8E%A8%E5%AE%9A.ipynb) も一部組み込んでいます。  
## 動作環境
`Google Colaboratory`
`Python`  
## 動作
使用している学習データは`OGVC`と呼ばれる日本語話者の音声をラベル付きで感情分類した音声コーパスで、無料ですが専用サイトで申請しないと入手できません。  
表情系はpyfeatを用いて推定しているので楽に動作してくれるのですが、音声系が自作AIかつ学習データが多いのでとにかく学習に時間がかかります。（1時間以上）  
音声AIは**メルスぺクトログラム**と呼ばれる音声を画像にしたものを、**畳み込み層**という画像を2次元のまま学習できる層を通して学習しています。よくよく考えたらメルスペクトログラム+発話内容の文章データで学習しないとただ音声の形を見てるだけになるのでここは後で改良したいところです。  
最終的には表情+音声の感情をもう一つのAIにいれて学習させて印象を判定するので計3つのAIを動作させています。印象AIのところを生成AIにできたら面白そうです。 

# 芭蕉オンリー掲示板
![basyo_board](https://github.com/KitaYuusuke/my-works/assets/117000159/1b656d49-324b-49d4-8447-342210660d73)  
- [芭蕉オンリー掲示板のコード](https://github.com/KitaYuusuke/my-works/tree/main/haikuPHP)  
## 概要
PHPとdockerを勉強したので、docker desktopにPHP（slim）とMySQLとphpmyadminのコンテナを建ててlocalhostで動作させる575掲示板を作りました。（EC2で動作させたかったけどEC2が使えなくなってました...）  
## 動作環境
`Visual Studio Code ver.1.84.2`
`PHP 8`
`docker desktop`  
## 動作
`docker-compose up -d`でコンテナを起動して`http://localhost:8080/`にアクセスすると掲示板を見ることができます。
もし「テーブルがないよ」と言われたらsqlフォルダにsqlを入れているので`http://localhost:8081/`のphpmyadminにインポートしてみてください。自分の環境ではdocker desktopのvolumeにデータを保存してるので動作しますが、他の人の環境だと「テーブルがないよ」とおそらく言われそうです  
この掲示板は拗音（イ行+ゃゅょ）を1文字としてカウントした**575のひらがな**でしか入力することができません。（きょうのあさ<-これは5文字カウント）  
文字数がオーバーorひらがな以外を使うとエラー文を出力します。  
上の方の画像の「せきをしてもひとり」はテストでphpmyadminに直書きしたものなので実際の動作では575しか入力できません。  
![basyo_str_error](https://github.com/KitaYuusuke/my-works/assets/117000159/708f52ae-8ad2-4284-94d0-4397774e5ae9)
作成時、データベースとの接続でエラーがなかなか解決できずdockerFileをいじって解決しようと頑張っていたのでその痕跡があります。結果的にdockerFileをいじらずに解決できたのでコメントアウトしてます。（コメントアウトで残すと起動時間が伸びたりとかするのでしょうか？）  
こだわりポイントは拗音を含めて575に制限したところと、上部のヘッダー画像です。  
ヘッダー画像はなぜかindex.phpと同じフォルダに入れないと表示されなかったので、解決法を見つけたいです。  

# 趣味で作った3Dモデルの画像
## 概要
趣味でblenderを用いて3Dのキャラクターモデルを作ったので`バーチャルキャスト`と`VRChat`に遊びに行った時の画像を掲載します。  
blenderを勉強して割とすぐに作り始めたのですが、3か月ほどでUnityでの設定まで終わらせることができました。  
## 写真（バーチャルキャスト）
`インフィニットループ公式ルームにて、るぷたんと撮影`  
![Vcas_ava1](https://github.com/KitaYuusuke/my-works/assets/117000159/3e571806-94e6-4d4d-bca8-9101c25009de)  
  
`同じく公式ルームであいえるたん新立ち絵と撮影`  
![Vcas_ava3](https://github.com/KitaYuusuke/my-works/assets/117000159/f52be6fe-b1ac-45ec-9ad0-b0fbc0636e0a)  
  
`雪ミクと撮影`  
![Vcas_ava2](https://github.com/KitaYuusuke/my-works/assets/117000159/a2fe488f-ccab-43f1-8bca-e33b160d93ca)  
## 写真（VRChat）
`おしゃれに撮れた写真`  
![VRChat_ava1](https://github.com/KitaYuusuke/my-works/assets/117000159/eb2fd4d7-076e-4cae-8fd3-56700c03738b)  
![VRChat_ava2](https://github.com/KitaYuusuke/my-works/assets/117000159/f55a4f81-aeb5-42ea-99bc-adc02462c4a5)  
![VRChat_ava3](https://github.com/KitaYuusuke/my-works/assets/117000159/2d6faedf-013e-405a-84ab-82cd6afe0dcc)  
  
`オリジナルキャラクターのかぶとうふ`  
![VRChat_ava4](https://github.com/KitaYuusuke/my-works/assets/117000159/e079b539-f20e-4dc3-b36f-2adceef9a64a)  