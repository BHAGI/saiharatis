package com.mycompany.myapp;
import java.lang.*;
import android.text.method.ScrollingMovementMethod;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.media.MediaPlayer;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.content.Intent;
import android.net.Uri;



public class fourthActivity extends Activity
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
		buttonPlayPause = new Button(this);
		buttonPlayPause.setText("Play");

		buttonQuit = new Button(this);
		buttonQuit.setText("Quit");

		textState = new TextView(this);

		buttonPlayPause.setOnClickListener(buttonPlayPauseOnClickListener);
		buttonQuit.setOnClickListener(buttonQuitOnClickListener);

		initMediaPlayer();
        
        // ARGB: Opaque Green
        tv.setBackgroundColor(0xFF00FF);
        //	txtView=(TextView)findViewById(R.id.txtView);
		//	txtwidth = (TextView)findViewById(R.id.viewwidth);
		hello="Night Harati"
			+'\n'+'\n'
			+"1"
			+'\n'
			+"Owaloo aaratee mazhaa Sadgurunaathaa - maazhaa Sainaatha"+'\n'+"Paanchaahee tatwaanche deep laawilaa aataan"+'\n'+"Nirgunaachee sthitee kaisee aakaaraa aalee - Baba aakaaraa aalee"+'\n'+"Sarvaa ghatee bharooni vuralee Sayee Maawoolee"+'\n'+"Owaloo aaratee...."+'\n'+"RajaTamaSathwa tighe maayaa prasawalee - Mazyawara maayaa prasawalee"+'\n'+"Mayecheeye potee kaisee maayaa udbhavalee"+'\n'+"Owaloo aaratee...."+'\n'+"SaptaSaagaree kaisa khel maandeelaa - Baba khel maandeelaa"+'\n'+"Khelooniyaa khel awagha visthaar kelaa"+'\n'+"Owaloo aaratee...."+'\n'+"Brahmaandeechee rachanaa keisee daakhavilee dolaa - Baba daakhavilee dolaa"+'\n'+"Tuka hmane maazhaa Swaamee kripaaloo bholaa"+'\n'+"Owaloo aaratee..."
			+'\n'+'\n'
			+"2"
			+'\n'
			+"Lopale jnaana jagin - hita nenatee konee"+'\n'+"Avataara Panduranga - nam ttevile jnanee"+'\n'+"Aaratee Jnaanaraaja - mahaa kaivalya tejaa"+'\n'+"Sevitee Saadhusanta - hmanu vedhalaa maazha"+'\n'+"Aaratee Jnaanaraaja."+'\n'+"Kanakachee tat kareen - Ubhyaa gopikaa naaree"+'\n'+"Narada tumbaraho - samgaayan karee"+'\n'+"Aaratee Jnaanaraaja...."+'\n'+"Pragata guhya bole - vishwa brahmachi kele"+'\n'+"Rama Janardanee - payee masthak ttevile"+'\n'+"Aaratee Jnaanaraaja..."
			+'\n'+'\n'
			+"3"
			+'\n'
			+"Aaratee Tukaaraamaa - Swamee Sadguru dhaamaa"+'\n'+"Satchidaananda murtee - paaya dakhavi aamhaa Aaratee Tukaaraamaa"+'\n'+"Raaghave Saagaraat - jaise paashaan taarile"+'\n'+"Taise he tuko baache - abhang rakshile"+'\n'+"Aaratee Tukaaraamaa..."+'\n'+"Tukitaa tulanesee - brahma tukasee aale"+'\n'+"Hmanoni raamesware - charanee mastak ttevile"+'\n'+"Aaratee Tukaaraamaa..."
			+'\n'+'\n'
			+"4"
			+'\n'
			+"Jai jai Sainatha aataa pahudaave mandiree ho,"+'\n'+"Jai jai Sainatha aataa pahudaave mandiree ho"+'\n'+"Aalavito sapreme tuzhala aaratee ghevuni kareeho,"+'\n'+"Jai jai Sainatha aataa pahudaave mandiree ho"+'\n'+"Ranjavisee too madhura bulunee - maaya jashi nija mulaa ho."+'\n'+"Ranjavisee too madhura bulunee - maaya jashi nija mulaa ho"+'\n'+"Bhogisi vyadhee tunch haruniyaa - nijasevak dukhaalaa ho."+'\n'+"Bhogisi vyadhee tunch haruniyaa - nijasevak dukhaalaa ho."+'\n'+"Dhavuni bhakta vyasana harisi - darshan deshee tyaalaa ho"+'\n'+"Dhavuni bhakta vyasana harisi - darshan deshee tyaalaa ho"+'\n'+"Jzhaale astil kasta ateesaya tumache yaa dehaalaa ho"+'\n'+"Jai jai Sainatha..."+'\n'+"Skhmaa shayana sundara hee shobhaa - suman shej tyaavareen ho"+'\n'+"Skhmaa shayana sundara hee shobhaa - suman shej tyaavareen ho"+'\n'+"Gdhyaavee todee bhakta jananchee - pujan archan kareen ho"+'\n'+"Gdhyaavee todee bhakta jananchee - pujan archan kareen ho"+'\n'+"Owaalito panchaprana - jyotee sumatee kareen ho"+'\n'+"Owaalito panchaprana - jyotee sumatee kareen ho"+'\n'+"Sevaa kinkara bhakta preetee - attar parimala vaaree ho"+'\n'+"Jai jai Sainatha..."+'\n'+"Soduni jaayaa dukha waatate - Baba tava charanaansee ho"+'\n'+"Soduni jaayaa dukha waatate - Sayee tava charanaansee ho"+'\n'+"Agnesthavah aasi prasaada - ghevuni nijasadanaasee ho"+'\n'+"Agnesthavah aasi prasaada - ghevuni nijasadanaasee ho"+'\n'+"Jaato aata yevu punarapi - twatcharanaanche paashee ho"+'\n'+"Jaato aata yevu punarapi - twatcharanaanche paashee ho"+'\n'+"Uttavoon tujala Saimaavule - nijahitasaadhaa yaasee ho"+'\n'+"Uttavoon tujala Saimavule - nijahitasaadhaa yaasee ho"+'\n'+"Jai jai Sainatha..."
			+'\n'+'\n'
			+"5"
			+'\n'
			+"Aataa Swaamee sukhe nidraa karaa avadhutaa - Baba karaa Sainathaa"+'\n'+"Chinmaya he sukhfhaama jaawuni pahudaa ekaantaa"+'\n'+"Vairaagyaachaa kunchaa ghewuni chowk jhadeela - Baba chowk jhadeela"+'\n'+"Tayaawaree supremaachaa shidakaavaa didhalaa Aataa Swaamee..."+'\n'+"Paayaghadadyaa ghatalyaa sundar navavidhaa bhakti - Baba navavidhaa bhakti"+'\n'+"Jnaanaachyaa samayaa laawuni ujalalyaa jyotee Aataa Swaamee..."+'\n'+"Bhaavaarthaanchaa manchaka hridaya kaashee taangilaa - hridaya kaashee taangilaa"+'\n'+"Manaachee sumane karunee kele sheejelaa Aataa Swaamee..."+'\n'+"Dwaitaache kapaat laavuni ekatra kele - Baba ekatra kele"+'\n'+"Durbuddheenchyaa gatte soduni padade sodeele Aataa swaamee..."+'\n'+"Aashaa trishnaa kalanechaa Soonduni galabala - Baba Saanduni galabala"+'\n'+"Dayaa kshamaa shaantee daasee ubhyaa sewelaa Aataa Swaamee..."+'\n'+"Alakshya unmanee ghevunee Baba naajuk dusshaalaa - Baba naajuk dusshaalaa"+'\n'+"Niranjana Sadguru swamee nijavile shejelaa Aataa Swaamee..."+'\n'+"Shri Satchitaanand Sadguru Sainaath Maharaaj ki jay"+'\n'+"Shri Guru Deva Datta!"
			+'\n'+'\n'
			+"6"
			+'\n'
			+"Paahen prasadachee vaat ghyaave dhuvoniyaan taat"+'\n'+"Sesh ghewoniaan taat Tumche jhaliyaan bhojan"+'\n'+"Jhaalo aata eksavaa Tumha aadu niyaa devaa"+'\n'+"Tuka hmane aatan chitt karooni raahilo nischint"
			+'\n'+'\n'
			+"7"
			+'\n'
			+"Paawala prasaad aataa vitto nijaave - Baba aataa nijaave"+'\n'+"Apulaa to shrama kalo yetase bhaave"+'\n'+"Aataan Swaamee sukhe nidraa karaa Gopala - Baba Sai dayaalaa"+'\n'+"Purale manorath jato aapule sthalaa."+'\n'+"Tumhaasee jaagawoo aamhi aapulya chaada - Baba aapulya chaada"+'\n'+"Shubhashub karme dosh haraavayaa peedaa."+'\n'+"Aataan Swaamee sukhe nidraa karaa Gopala - Baba Sai dayaalaa"+'\n'+"Purale manorath jato aapule sthalaa."+'\n'+"Tuka hmane didhale utchistaache bhojan - utchistaache bhojan"+'\n'+"Naahi nivadile aamha apulya bhinn."+'\n'+"Aataan Swaamee sukhe nidraa karaa Gopala - Baba Sai dayaalaa"+'\n'+"Purale manorath jato aapule sthalaa."+'\n'+"Aataan Swaamee sukhe nidraa karaa Gopala - Baba Sai dayaalaa"+'\n'+"Purale manorath jato aapule sthalaa."+'\n'+"Sadguru Sainaath Maharaaj ki jay"+'\n'+'\n'+"Aum Raajaadhiraaja Yogiraaja ParaBrahma Sainaath Maharaaj"+'\n'+'\n'+"Shri Satchitaanand Sadguru Sainaath Maharaaj ki jay!!!"
			;


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
		mediaPlayer = MediaPlayer.create(this, R.raw.ntaa3);
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
