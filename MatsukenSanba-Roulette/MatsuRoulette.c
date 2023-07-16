#include<stdio.h>
#include<stdlib.h> /*randのため*/
#include<time.h>   /*randのため*/
#include<unistd.h> /*usleepのため*/
#include<string.h> /*strcpy、strcmpのため*/
#include<stdlib.h> /*exitのため*/
struct Sanba{
	char san1[1000];
	char san2[1000];
};
void input(int *);
void randsanba(int *);
void dance(void);
void ore(struct Sanba *);
void matuken(struct Sanba *);

/*マツケンサンバの”サンバ”の部分を
 ３文字ランダムで表示し、
 サンバが揃うと踊るプログラム*/
int main(){
	srand((unsigned int)time(NULL)); /*初期化するので毎回randの値は変わる*/
	setbuf(stdout,NULL);  /*これを入れないと文字が一気に出てくる*/
	
	int x;

	input(&x);
	randsanba(&x);

	return 0;
}

void input(int *px){
	
	char ans[100];

	printf("Do you play MATUKEN Challenge ? (y/n)\nAnswer = ");
	scanf("%s",ans);
	printf("\n\n");

	if(strcmp(ans,"y")==0){
		*px = 1;
	}
	else if(strcmp(ans,"n")==0){ /*nだったらプログラム終了*/
		printf("\nOh no.......\n");
		exit(0);
	}
	else if(strcmp(ans,"sanba")==0){
		*px = 2;
	}
	else{
		printf("\nyかnを入力してください。\n\n");
		input(px);
	}

	return;
}

void randsanba(int *px){

	int i,r;
	char matu[7][4] = {"マ","ツ","ケ","ン","サ","ン","バ"};
	char sanba[3][4];
	char check[4];
	
	if(*px==1){/*サンバが出たらラッキー*/
		for(i=0;i<7;i++){
			if(i<4){	
				printf("%s  ",matu[i]);
				usleep(0.6*1000000);
			}
			else{
				r = rand() % 3 + 4; /*０～２＋４＝４～６*/
				printf("%s  ",matu[r]);
				strcpy(sanba[i-4],matu[r]);

				if(r==4 && i==4){ /*サ、ン、バの並びを記録　（後で使う）*/
					check[0] = 's';
				}
				else if(r==5 && i==5){
					check[1] = 'n';
				}
				else if(r==6 && i==6){
					check[2] = 'b';
					check[3] = '\0';
				}
				usleep(0.8*1000000);
			}

		}
	}
	else{	/*強制的にサンバを表示*/
		for(i=0;i<7;i++){
			if(i<4){
				printf("%s  ",matu[i]);
				usleep(0.6*1000000);
			}
			else{
				printf("%s  ",matu[i]);
				strcpy(sanba[i-4],matu[i]);

				if(i==4){ /*サ、ン、バの並びを記録　（後で使う）*/
					check[0] = 's';
				}
				else if(i==5){
					check[1] = 'n';
				}
				else{
					check[2] = 'b';
					check[3] = '\0'; /*なぜか"snbサ"となるので\0で"snb"にする*/
				}
				usleep(0.8*1000000);
			}
		}
	}


	printf("\n\nマツケン%s%s%s!!!\n",sanba[0],sanba[1],sanba[2]);

	if(!strcmp(check,"snb")){ /*sanba[]がサンバになってたら踊る*/

		dance();
	}
	else{
		printf("No SANBA........");
	}
	return;

}

void dance(void){
	struct Sanba san[2];

	/*分解されたアスキーアートたち*/
	strcpy(san[0].san1,"　　⌒  ⌒\n　（´･ω ･｀）\n   (　つ　ヽ\n　  )  とﾉ )\n　(__ノ^(＿)");
	strcpy(san[0].san2,"    ⌒  ⌒\n  （´･ω ･｀）\n　γ　 と )\n  ( ヽつ (\n　 (＿)^(__)");
	strcpy(san[1].san1,"　 ⌒  ⌒\n  (´･ω ･`)\n  ⊂　　　つ\n　(_ノ^(_)");
	strcpy(san[1].san2,"　　⌒ ⌒\n　∩ ・ω ・）\n  |　　 ⊂ﾉ\n  |      |\n （_ノ^(__)");
	
	
	usleep(1*1000000);
	printf(" ｵ ﾚ !!!\n");
	usleep(1*1000000);
	printf("\n~ ~ ♪\n\n");
	usleep(2*1000000);
	
	/*踊るとこ*/
	ore(san);
	matuken(san);
	ore(san);
	matuken(san);

	printf("\n\n       ｵ ﾚ !!!\n");

}

void ore(struct Sanba *san){

	int i;
	for(i=0;i<8;i++){
		if(i%2 == 0){
			system("clear");
			printf("%s\n",(san)->san1);
			printf("オーレ―　オーレ―");
			usleep(0.5*1000000);
			
		}
		else if(i%2 == 1){
			system("clear");
			printf("%s\n",(san)->san2);
			printf("オーレ―　オーレ―");
			usleep(0.5*1000000);
		}
	
	}

}


void matuken(struct Sanba *san){
	
	int i;
	char matu[7][4] = {"マ","ツ","ケ","ン","サ","ン","バ"};

	system("clear");
	printf("%s",(san+1)->san1);
	usleep(0.6*1000000);

	system("clear");
	printf("%s\n",(san+1)->san2);
	
        for(i=0;i<7;i++){
        	if(i<4){
                	printf("%s ",matu[i]);
                        usleep(0.3*1000000);
		}
                else{
                        printf("%s  ",matu[i]);
                        usleep(0.5*1000000);
                }
                
        }

	

}
