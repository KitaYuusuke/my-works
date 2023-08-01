#include <LiquidCrystal.h>

LiquidCrystal lcd( 2, 3, 10, 11, 12, 13 );
char keymap[4][4] = {
  {'1','2','3','#'},
  {'4','5','6','#'},
  {'7','8','9','#'},
  {'*','0','#','#'},
};

void setup() {
  for(int i=5; i<=9; i++){    //5～7ピンを出力に設定
    pinMode(i,OUTPUT);
  }
  for(int i=14; i<=17; i++){    //A0～A3ピンを入力に設定
    pinMode(i,INPUT);
  }
  lcd.begin( 16, 2 );
  //割り算確認（1）引き算確認（7）
  randomSeed(5);
  
}

void playSound(int sec,int max) {
  for(int i=0;i<max;i++){
    digitalWrite(9, HIGH);
    delayMicroseconds(sec);
    digitalWrite(9, LOW);
    delayMicroseconds(sec);
  }
}

void loop() { 
  int randOpe = random(1, 5);//演算子を決定
  int rand1 = random(1, 101);
  int rand2 = random(1, 101);
  int ans;//答え（仮置き）
  int amari;
  char* ope;//演算子文字（仮置き）
  char num[50];
  int flag = 0;
    
  switch(randOpe){//計算をしておいて演算子文字を代入
    case 1:
      ans = rand1 + rand2;
      ope = "+";
      break;
    case 2:
      if(rand1<rand2){
        ans = rand1; //入れ替え
        rand1 = rand2;
        rand2 = ans;
      }
      ans = rand1 - rand2;
      ope = "-";
      break;
    case 3:
      ans = rand1 * rand2;
      ope = "*";
      break;
    case 4:
      ans = rand1 / rand2;
      ope = "/";
      amari = rand1%rand2;
      break;
  }
  lcd.print(rand1);
  lcd.print(ope);
  lcd.print(rand2);
  lcd.print("=");
  
  char c;  
  int count = 0;
  int myans = 0;
  int size = 0;
  memset(num, 0, sizeof(num));
  while(flag == 0){
    for(int i=5; i<=8; i++){
      digitalWrite(i, HIGH);    //i番ピンから電圧を印加
      for(int j=14; j<=17; j++){
        if(digitalRead(j)){     //j番ピンに入力があるか判断
          c = keymap[j-14][i-5];  // keymapから入力に対応した文字を参照
          while(true){//文字が連続にならない処理
            if(digitalRead(j)==NULL){ //電圧入力がなくなるまで無限ループ
              break;
            }
          }
          if(c=='#'){//入力が#だった時
            lcd.setCursor(0, 1);
            lcd.print("answer=");//答えを表示
            lcd.print(ans);
            if(randOpe == 4){//割り算のときはあまりを表示
              lcd.print("...");
              lcd.print(amari);
            }
            //ここに音の処理
            size = sizeof(num)/sizeof(char);
            if(size!=0){ //numに値が入っていた時
              myans = atoi(num);
              if(ans == myans){ //正解だった時
                playSound(252,200);
                playSound(315,500);
              }
              else{//不正解の音
                playSound(1893,264);
              }
            }
            else{//不正解の音（numに値が入っていないとき）
              playSound(1893,264);
            }
            flag = 1;//最初のwhileを抜ける
          }//入力が#だった時の処理おわり
          else if(c=='*'){//*を入力されたら全部消す
            lcd.clear();
            lcd.setCursor(0,0);
            lcd.print(rand1);
            lcd.print(ope);
            lcd.print(rand2);
            lcd.print("=");
            memset(num, 0, sizeof(num));
            count=0;
          }
          else{
            num[count] = c;//値を保存
            lcd.print(c);//入力が数字ならｃを表示
            count++;
          }

        }//digitalRead(j)のおわり
      }//for(j)のおわり
      digitalWrite(i,LOW);
    }//for(i)のおわり
  }//while(true)のおわり
  
  delay(1500);
  lcd.clear();
  lcd.setCursor(0, 0);
   
}