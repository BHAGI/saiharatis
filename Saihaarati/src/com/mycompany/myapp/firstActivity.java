package com.mycompany.myapp;
import java.lang.*;
import android.text.method.ScrollingMovementMethod;
import android.app.*;
import android.os.*;
import android.view.*;
import android.media.MediaPlayer;
import android.widget.*;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.content.Intent;
import android.net.Uri;


public class firstActivity extends Activity
{
	TextView tv;
	LinearLayout ll;
	@Override
	String hello;
	MediaPlayer mediaPlayer;
	Button buttonPlayPause, buttonQuit;
	TextView textState;

	private int stateMediaPlayer;
	private final int stateMP_NotStarter = 0;
	private final int stateMP_Playing = 1;
	private final int stateMP_Pausing = 2;
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
    
		ll = new LinearLayout(this);  
		ll.setOrientation(LinearLayout.VERTICAL);  
		ll.setLayoutParams(new ViewGroup.LayoutParams(-1,-1));  
		ll.setBackgroundColor(0x00000000);
		
		tv = new TextView(this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(-1,-2));
		tv.setTextSize(25);
       
        // ARGB: Opaque Green
        tv.setBackgroundColor(0xFF00FF);
		buttonPlayPause = new Button(this);
		buttonPlayPause.setText("Play");
	
		buttonQuit = new Button(this);
		buttonQuit.setText("Quit");
		
		textState = new TextView(this);
		
		buttonPlayPause.setOnClickListener(buttonPlayPauseOnClickListener);
		buttonQuit.setOnClickListener(buttonQuitOnClickListener);
		
		initMediaPlayer();
        //	txtView=(TextView)findViewById(R.id.txtView);
		//	txtwidth = (TextView)findViewById(R.id.viewwidth);
		hello="Morning Harati"
			+'\n'+'\n'		+"Sri Satchitanand Sadguru Sainath Maharaj Ki Jai"
			+'\n'+'\n'
			+	"1"
			+'\n'
			+"	Joduniya kar charani thevila Matha"
			+'\n'
			+"Parisawi vinanti majhi sagurunatha(pandharinatha)"
			+'\n'
			+"Aso-naso bhav alo tujhiya thaya"
			+'\n'
			+"Kripa drishti pahe majkade sadgururaya"
			+'\n'
			+"Akhandit asawe aise watate payi"
			+'\n'
			+"	Sanduni sankoch thav thodasa dei"
			+'\n'
			+"Tuka manhane deva maji vedi wakudi"
			+'\n'
			+"Namhe – bhavapash hati apulya todi"
			+'\n'+'\n'
			+"2"
			+'\n'
			+"Utha panduranga ata prabhat samayo patala"
			+'\n'
			+"Vaishnawancha mela garud pari datala"
			+'\n'
			+"Garud para pasuni mahadwara paryant"
			+'\n'
			+"Suracharanchi mandi ubhi joduniya hath"
			+'\n'
			+"Shuka sanakadik narad tumbar bhaktanchyakoti"
			+'\n'
			+"Trishul damaroo ghewooni ubha girjecha pati"
			+'\n'
			+"Kaliyugincha bhakta namhe ubha kirtani"
			+'\n'
			+"Pathimage ubhi dola lawooniya jani"
			+'\n'+'\n'
			+"3"
			
			+'\n'
			+"Utha utha sri sainath guru charan kamal dawa"
			+'\n'
			+"Aadhi wyadi bhawatap waruni tara jadviwa"
			+'\n'
			+"Geli tumha soduniya bhawatama rajani vilaya"
			+'\n'
			+"Pri hi agyanasi tumachi bhulawi yogmaya"
			+'\n'
			+"Shakti na amha Yatkinchitahi tijala saraya"
			+'\n'
			+"Tumhich teetay saruni dawa mukha jan taraaya"
			+'\n'
			+"Bho sainath maharaj bhawa timirnashak ravi"
			+'\n'
			+"Agyani amhi kiti tawa varnavi thorawi"
			+'\n'
			+"Tee warnita bhagale bahuvadani shesh vidhi kavi"
			+'\n'
			+"Sakurpa howooni mahima tumcha tumhich wadwa wa"
			+'\n'
			+"Utha Utha ------------------------(1)"
			+'\n'
			+"Bhakt mani sadbhaw dharuni je tumha anusarale"
			+'\n'
			+"Dhayastawa Te darshan tumche dwari ubhe thele"
			+'\n'
			+"Dhyanastha tumhas pahuni man amuche dhale"
			+'\n'
			+"Pari Twa chanamruta Prashayate atur jhale"
			+'\n'
			+"Ughaduni netra kamaladeenabhandu ramakanta"
			+'\n'
			+"Pahiba krupa drushti balaka jashi mata"
			+'\n'
			+"Ranjavi madhurvani Hari tap Sai Natha"
			+'\n'
			+"Aamhich Apule Kajastawa tuja kashtavito Deva"
			+'\n'
			+"Sahan Karishil te aikuni ghyawi bhet Krishna Dhawa"
			+'\n'
			+"Utha Utha Aadhi Wyadi ..(2)"
			+'\n'+'\n'
			+"4"
			+'\n'
			+"Utha Panduranga ata darshan dya sakala"
			+'\n'
			+"Jhala Arunodaya sarali nidrechi vela"
			+'\n'
			+"Sant sadhu mani avaghe jhaleti gola"
			+'\n'
			+"Sada Sheje sukh ata baghu dhya mukh kamala"
			+'\n'
			+"Rang Mandapi maha dwari jhalise dati"
			+'\n'
			+"Man utavil roop pahawaya drushti"
			+'\n'
			+"Rahi rakhumabai tumha yewoodhya daya"
			+'\n'
			+"Sheje halwooni jage kara devraya"
			+'\n'
			+"Garud hanumant ubhe pahati waat"
			+'\n'
			+"Swarginche surwar ghewooni ale bobhat"
			+'\n'
			+"Jale mukta dwar labh jhala rokada"
			+'\n'
			+"Vishnu das nama ubha ghewooni kankada"
			+'\n'+'\n'
			+"5"
			+'\n'
			+"Ghewooniya pancharati karoo babansi arti karoo sai si.."
			+'\n'
			+"Utha utha ho bandhav owalu ha ramadhav"
			+'\n'
			+"Karuniya Sthira man, Pahu gambhir he dhyana"
			+'\n'
			+"Saiche hey"
			+'\n'
			+"Krishna natha datt sai jado chitt tujhepai"
			+'\n'+'\n'
			+"6"
			+'\n'
			+"Kakad arti karito sainath deva"
			+'\n'
			+"Chinmaya roop dakhavi ghewooni balak laghu seva"
			+'\n'
			+"Kam krodh mad matsar atwooni Kankada kela"
			+'\n'
			+"Vairagyache toop ghalooni me to bhijavila"
			+'\n'
			+"Sai nath guru bhakti jawaane to me petawila"
			+'\n'
			+"Tad wruth jaluni guru ne parakash padila"
			+'\n'
			+"Dwaita tama nasuni milavi tatswaroopi jeewa"
			+'\n'
			+"Chinmaya roop dhakavi ghewooni balak laghu seva"
			+'\n'
			+"Bhoo-kechar vyapuni avaghe hrudhkamali rahasi"
			+'\n'
			+"Tochi datta devu shridi rahuni pawasi"
			+'\n'
			+"Rahooni yethe anyatrahi too bakta stav dhavasi"
			+'\n'
			+"Nirasuniya sankata dasa anubhav davisi"
			+'\n'
			+"Chinmaya roop dakhavi..."
			+'\n'
			+"Twadhyash dundu bhine sare ambar he kondale"
			+'\n'
			+"Sagun murti pahanya atur jan shirdi ale"
			+'\n'
			+"Prashuntwat vachanamrit amuche dehabhan harpale"
			+'\n'
			+"Soduniya durabhiman manas twat charni wahile"
			+'\n'
			+"Krupa karuniya sai maule dass padari ghyawa"
			+'\n'
			+"Chinmaya..."

			+'\n'+'\n'
			+"7"
			+'\n'
			+"Bhaktichiya poti bodh kankada jyothi"
			+'\n'


			+"Panch pran jivebhave owaloo arti"
			+'\n'
			+"Owaloo arti majya pandharinatha majya sainatha"
			+'\n'
			+"Donhi Kara jodoni charani thevila matha"
			+'\n'
			+"Kayb mahima varnu ata sangane kiti"
			+'\n'
			+"Koti brahma hatya mukh pahata jati"
			+'\n'
			+"Rai rukhumabai ubhaya doghi do bahi"
			+'\n'
			+"Mayur pich chamare dhallti thaiche thai"
			+'\n'
			+"Tuka mhane deep ghewooni unmaneet shobha"
			+'\n'
			+"Vite vari ubha dise lawanya gabha .. Owaloo …"

			+'\n'+'\n'
			+"8"
			+'\n'
			+"Utha sadhu sant sadha apulale heet"
			+'\n'
			+"Jaeel jaeel ha nardeh mag kaicha bhagwant"
			+'\n'
			+"Uthoniya pahate baba uba ase vite"
			+'\n'
			+"Charan tayancha gomate amrut drishti awaloka"
			+'\n'
			+"Utha utha ho vegsi chala jawooya rawoolasi"
			+'\n'
			+"Jalatil patakanchya rashi kakad arti dekhiliya"
			+'\n'
			+"Jage kara rukminivar, dev ahe nijsurant"
			+'\n'
			+"Vege linlon kara drisht hoel tayasi"
			+'\n'
			+"Dari wajantri vajati dhol damane garjati"
			+'\n'
			+"Hote kakad ati majhya sadguru rayanchi"
			+'\n'
			+"Sihanad shankh bheri anand hoto maha dwari"
			+'\n'
			+"Keshavraj vetewari nama charan vandito"
			+'\n'
			+"Sainath guru majhe aaee"
			+'\n'
			+"Majla thav dhava payee"
			+'\n'
			+"Datt raj guru majhe aaee"
			+'\n'
			+"Majla thav dhava payee"
			+'\n'
			+"Sri satchidanand sadguru"
			+'\n'
			+"Sainath maharajki jai"
			+'\n'+'\n'
			+"9"
			+'\n'
			+"Prabhat samayi shubh ravi prabha phankali"
			+'\n'
			+"Samare guru sada asha samayi tya chhale na kali"
			+'\n'
			+"Manhoni kar jodoni karu ata guru prarthana"
			+'\n'
			+"Samarth guru sai nath purvi manovasana……………1"
			+'\n'
			+"Tama nirsi bhanu ha guru hi nasi adnyanata"
			+'\n'
			+"Parantu guruchi kari na ravihi kadhi samyata"
			+'\n'
			+"Punha timir janma ghe gurukrupeni adnyana na"
			+'\n'
			+"Samarth guru sainath puri manovasana………………2"
			+'\n'
			+"Ravi pragat hawooni twarita ghalwi alasa"
			+'\n'
			+"Tasa guruhi sodwi sakal dushkruti lalasa"
			+'\n'
			+"Haroni abhimani jadwi tatpadi bhavana"
			+'\n'
			+"Samarth guru sainath purvi manovasana……………...3"
			+'\n'
			+"Gurusi upma dise vidheehari haranchi uni"
			+'\n'
			+"Kuthoni mag yei tee kavani ya ugi pahooni"
			+'\n'
			+"Tujjhich upma tula bharvi shobhate sajana"
			+'\n'
			+"Samarth guru sainath purvi manovasana…………….4"
			+'\n'
			+"Samadhi utroniya guru chala mashidikade"
			+'\n'
			+"Twaidya vachnoti tee madhur variti sankade"
			+'\n'
			+"Ajatripu sadguru akhil pataka bhajana"
			+'\n'
			+"Samarth guru sainath purvi manovasana……………..5"
			+'\n'
			+"Aha susamayasi ya guru uthoniya baisale"
			+'\n'
			+"Vilokuni padashrit tadiy aapade nasile"
			+'\n'
			+"Asa suhitkari ya jagati konihi anya na"
			+'\n'
			+"Samarth guru sainath purvi manovasana……………..6"
			+'\n'
			+"Ase bahut shahana pari na jya guruchi kripa"
			+'\n'


			+"Na tatswahit tya kale karitase rikamya gapa"
			+'\n'
			+"Jari gurupada dhari sadrudh bhaktine to mana"
			+'\n'
			+"Samarth guru sainath purvi manovasana……………..7"
			+'\n'
			+"Guro vinati mi kari hridaymandiriya basa"
			+'\n'
			+"Samasta jag he guruswarupachi thaso manasa"
			+'\n'
			+"Karo satat satkruti matihi de jagatpavana"
			+'\n'
			+"Samarth guru sainath purvi manovasana……………..8"
			+'\n'
			+"Premeya ashtakasi padhuni guruvara prarthiti je prabhati,"
			+'\n'
			+"Tyachi chittasee deto akhil"
			+'\n'
			+"Haruniya bhranti mee nitya shanti"
			+'\n'
			+"Aise he sainathekathuni"
			+'\n'
			+"Suchvile jevi ya baalakasi,"
			+'\n'
			+"Tevi tya krisnapayi namuni"
			+'\n'
			+"Savinaye arpito ashtakasi………………………………9"


			+'\n'+'\n'
			+"10"
			+'\n'
			+"Sai raham najar karna,"
			+'\n'
			+"Bachoon ka palan karna"
			+'\n'
			+"Jana tumne jagat pasara,"
			+'\n'
			+"Sabahi jooth jamana"
			+'\n'
			+"Sai raham najar karna"
			+'\n'
			+"Mai andha hoon banda apaka"
			+'\n'
			+"Mujase prabhu dikhlana"
			+'\n'
			+"Sai ram najar karna"
			+'\n'
			+"Das ganu kahe aab kya bolu,"
			+'\n'
			+"Thak gayi meri rasana"
			+'\n'
			+"Sai ram najar karna"
			+'\n'
			+'\n'
			+"11"
			+'\n'
			+"Raham najar karo, ab more sai"
			+'\n'
			+"Tumbin nahi mujhe maa baap bhai - Raham …."
			+'\n'
			+"Mai andha hoo banda tumara - Mai andha …."
			+'\n'
			+"Mai na janoo allah elahi-Raham najar Karo"
			+'\n'
			+"Khali jamana maineh gamaya - Khali …."
			+'\n'
			+"Sathi akhar ka kiya na koi-Raham najar Karo"
			+'\n'
			+"Apne mashidka jhadoo ganu hai - Apne …."
			+'\n'
			+"Malik hamara, tum baba sai - Raham najar Karo"
			+'\n'
			+'\n'
			+"12"
			+'\n'
			+"Tuj kay deoon sawlya mee khaya tari"
			+'\n'
			+"Mi dubali batik namyachee jaa shree hari"
			+'\n'
			+"Uchhishta tula dene hi goshta na bari"
			+'\n'
			+"Tu jagannath, tuj deoon kashire bhakari"
			+'\n'
			+"Nako anta madiya pahoon sakhiya bhagwanta - shrikanta"
			+'\n'
			+"Madhyanharatr Ultoni galee hi aata - aan chitta."
			+'\n'
			+"Hoiel tujhare kankada ki raulantari"
			+'\n'
			+"Aantil bhakti naivedyahi nanapari -"
			+'\n'
			+'\n'
			+"13"
			+'\n'
			+"Sri sadguru baba sai"
			+'\n'
			+"Tujwanchuni ashray nahi, bhutali"
			+'\n'
			+"Mi papi patit dheemananda - Mi…."
			+'\n'
			+"Tarne mala gurunatha, jhadakari"
			+'\n'
			+"Tu shantishamecha meru, Tu…."
			+'\n'
			+"Tu bhavarnavinche taru guruvara,"
			+'\n'
			+"Guruvara majasi pamara, ata udddhvara"
			+'\n'
			+"Twarit lavlahi, Twarit lavlahi,"
			+'\n'
			+"Mi budto bhavbhay dohi, uddhvara Sri sadguru…."+'\n'
			+'\n'+'\n'
			+"Sri Satchitanand Sadguru Sainath Maharaj Ki Jai";

		
		//Implement listener for your button so that when you click the 
		//button, android will listen to it.             

		            
		
					tv.setMovementMethod(new ScrollingMovementMethod());
					tv.setText(hello);
		
	//	ll.setGravity(Gravity.CENTER);
		ll.addView(buttonPlayPause);
		ll.addView(buttonQuit);
		ll.addView(textState);
		ll.addView(tv);
	setContentView(ll);  

				} 
      	

	private void initMediaPlayer()
	{
		mediaPlayer = new  MediaPlayer();
		mediaPlayer = MediaPlayer.create(this, R.raw.kkaa1);
		stateMediaPlayer = stateMP_NotStarter;
		textState.setText("- IDLE -");
	}

	Button.OnClickListener buttonPlayPauseOnClickListener
	= new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(stateMediaPlayer){
				case stateMP_NotStarter:
					mediaPlayer.start();
					buttonPlayPause.setText("Pause");
					textState.setText("- PLAYING -");
					stateMediaPlayer = stateMP_Playing;
					break;
				case stateMP_Playing:
					mediaPlayer.pause();
					buttonPlayPause.setText("Play");
					textState.setText("- PAUSING -");
					stateMediaPlayer = stateMP_Pausing;
					break;
				case stateMP_Pausing:
					mediaPlayer.start();
					buttonPlayPause.setText("Pause");
					textState.setText("- PLAYING -");
					stateMediaPlayer = stateMP_Playing;
					break;
			}

		}
	};

	Button.OnClickListener buttonQuitOnClickListener
	= new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mediaPlayer.stop();
			mediaPlayer.release();
			finish();
		} 
	};
	}
