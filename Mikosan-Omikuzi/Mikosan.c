#include<stdio.h>
#include<stdlib.h>
#include<time.h>

/*巫女さん呼び出し関数*/
void miko(char serihu[]){
	printf("　 リ＿＿ﾘ\n");
	printf("　 o＼＿／o\n");
	printf("`〈>´ ｀くﾉ\n");
	printf("∩|iiﾉノ人))\n");
	printf("))|ﾄゝﾟヮﾟﾉl ＜%s\n",serihu);
	printf("((　/ フﾌつつ\n");
	printf("（(く//元ﾘ_>\n");
	printf("　　しし′\n");
}

int main(){
	srand(time(NULL));

	char *serihu[]={"あなたの運勢、勝手に占ってあげます！","ふんにゃかはんにゃか.....","ほわーーーーーー！！！！！","あ...ごめんなさい.......","え、怖......"};
	char *yorino,*unsei;
	int i,yorinoint,unseiint,key;


	/*巫女が喋るぞ*/
	printf("～神社に来たら巫女さんが出てきた～\n");

	for(i=0;i<3;i++){
		/*Enterを押したらmiko関数のセリフすすめるぞ*/
		/*nを押したら巫女さんがいなくなるぞ*/
		/*Enterとn以外を押しても巫女さんがいなくなるぞ*/
		key=getchar();
		switch(key){
			case '\n':
				miko(serihu[i]);
				break;
			case 'n':
				miko(serihu[3]);
				printf("\n～巫女さんは悲しそうな顔をして帰っていった～\n");
				return 1;

			default:
				miko(serihu[4]);
				printf("\n～意味のないキーを押したあなたに怖がって巫女さんは帰った～\n");
				return 1;	
		}
	
	}
	

	/*何よりか決めるぞ*/
	yorinoint=rand()%101;
	if(yorinoint<=1){
		yorino="ミジンコ";
	}
	else if(yorinoint<=10){
		yorino="大凶";
	}
	else if(yorinoint<=30){
		yorino="普通";
	}
	else if(yorinoint<=60){
		yorino="普通以上";
	}
	else if(yorinoint<=90){
		yorino="吉";
	}
	else if(yorinoint<=100){
		yorino="大吉";
	}


	/*運勢決めるぞ*/
	unseiint=rand()%101;
        if(unseiint<=1){
                unsei="ミジンコ";
        }
        else if(unseiint<=10){
                unsei="大凶";
        }
        else if(unseiint<=30){
                unsei="凶";
        }
        else if(unseiint<=60){
                unsei="吉";
        }
        else if(unseiint<=90){
                unsei="まぁまぁ吉";
        }
        else if(unseiint<=100){
                unsei="大吉";
        }
	

	printf("\n運勢！%sよりの%s！！！\n",yorino,unsei);

return 0;
}

