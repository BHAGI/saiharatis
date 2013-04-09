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



public class secondActivity extends Activity
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
		hello="Afternoon Harati"
			+'\n'+'\n'+	"1"+'\n'+"Ghewuniya panchaarati, karoo Babansi aarati"+'\n'+" Karoo Sai see aarati Karoo Babansi arati."+'\n'+" Utta utta ho bandhawa. Owaaloo ha Ramadhava."+'\n'+" Sayee Ramadhava. Owaloo ha Ramadhava."+'\n'+" Karooniya sthira man, pahu gambhirira he dhyan"+'\n'+" Sayeeche he dhyan pahu gambhirira he dhyan"+'\n'+" Krishnanatha Datt Sai jado chitta tujze paayee"+'\n'+" Chitta Baba paayee Jado chitta tuzhe paayee"
			+'\n'+'\n'
			+	"2"
			+'\n'
			+"Aarti Sai Baba, saukhyadaataara jeeva. Charana rajaatalee "+'\n'+"Dhyaava daasaan visaawaa, bhaktaa visaawaa. Aarti Sai Baba"+'\n'+" Jaaluniyaan aananng swaswaroopee raahe dhanga"+'\n'+" Mumukshu janaan daavee nija dolaan Sreeranga, dolaan Sreeranga Aarti Sai Baba"+'\n'+"Jayaa manee jaisaa bhaava tayaa taisaa anubhava"+'\n'+"Daawisee dayaaghanaa aisee tujzee hee maava tujzeeheemaava Aarti Sai Baba"+'\n'+"Tumache naama dhyaataan hare sansrithi vyathaa"+'\n'+" Agaadha tava karanee maarga daawisee anaadhaa,daawisee anaadhaa Aarti Sai Baba"+'\n'+"Kaliyugee avataara saguna parabrahm saachara"+'\n'+" Avateerna jhaalase swami Datta digambara, Datta digambara Aarti Sai Baba"+'\n'+"Aattan divasaan guruwaaree bhakta karitee waaree"+'\n'+"Prabhupada pahaavayaa bhavabhaya niwaree, bhaya niwaree Aarti Sai Baba:"+'\n'+" Maajan nija dravya tteewaa tav charan rajasevaa"+'\n'+"Maagane hechiyaataa tumhan devaadhideva, Devaadhideva Aarti Sai Baba"+'\n'+"Ichchita deena chaatak nirmala toya nijasookha"+'\n'+"Paajaawe maadhavaa yaa saambhal aapulee bhaaka, aapulee bhaaka Aarti"
			+'\n'+'\n'
			+"3"
			+'\n'
			+"Jaya Deva Jaya Deva Datta avadhutaa, O Sayee avadhutaa"+'\n'+"Jodoonikara tava charanee ttevito maathaa, Jaya Deva Jaya Dev"+'\n'+"Avataraseen too yaetaan dharmaante glanee, Naastheekaanaahee too laavisi nijabhajanee"+'\n'+"Daavisi naanaa leela asankhya roopaanee, Harisee dheenanche too sankata dinarajanee"+'\n'+"Jaya Deva Jaya Deva..."+'\n'+" Yavana swaroopee aikhyaa darshana twaan dhidhale, Samsaya nirsuniyaan thathdwaitaa ghaalavile"+'\n'+"Gopichandaa mandaa twaanchee uddharile, Momina vamsee janmuni lokaan taariyale"+'\n'+"Jaya Deva Jaya Deva..."+'\n'+"Bhed na tathwee hindoo yavananchaa kaanhee Daawayaansee jzaalaa punarapi naradehee"+'\n'+"Paahasin premaane too Hindu yavanaanhee, Daavisi aatmatwaane vyaapaka haa sayee"+'\n'+"Jaya Deva Jaya Deva..."+'\n'+"Devaa Sayeenaathaa twatpadanata vhaahe, paramaayaamohita janamochana jhanin vhaave "+'\n'+"Twakripayaa sakalaanche sankata nirasaawe, deshila tari de twadhyash krishnaane gaave"+'\n'+"Jaya Deva Jaya Deva"
			+'\n'+'\n'
			+"4"
			+'\n'
			+"Shirdee maajze Pandharapura Saibaba Ramaavara"+'\n'+"Baba Ramaavara Sai Baba Ramaavara"+'\n'+"Shuddha bhaktee chandrabhaabagaa, Bhaava pundaleeka jaagaa"+'\n'+"pundaleeka jaagaa. Bhaava pundaleeka jaagaa"+'\n'+"Yaa ho yaa ho avaghe jana karaa Babaansee vandana."+'\n'+"Saisi vandana karoo Babaansee vandana"+'\n'+"Ganu mhane Baba Sayee. Dhaava paava maajze aayee"+'\n'+"paava maajze aayee. Dhaava paava maajze aayee"
			+'\n'+'\n'
			+"5"
			+'\n'
			+"Ghaaleena lotaangana vandeen charana Dolyanee paaheen roop tujze"+'\n'+"Preme aalingana aanande poojin, Bhave oowaalina mhane Naamaa."+'\n'+"Tvameva maataa cha pitaa tvameva Tvameva bandhuscha sakhaa tvameva"+'\n'+" Tvameva vidyaa dravinam tvameva, Tvameva servam mama Devadeva."+'\n'+"Kaayena vaachaa manasrendriyaiarwan Budhyatmanaa vaa prakriti swabhavaat"+'\n'+"Karomi yadyatsakalam parasmai, Narayanaayeti samarpayaami"+'\n'+"Acyutam Keshavam Raamanaaraayanam Krishnadaamodaram Vaasudevam Harim"+'\n'+"Shreedharam Maadhavam Gopikaa Vallabham, Jaanakeenaayakam Raamachandram Bhaje."+'\n'+"Hare Rama, Hare Rama. Rama Rama Hare Hare"+'\n'+"Hare Krishna, Hare Krishna. Krishna Krishna Hare Hare. X 3"+'\n'+"Shri Gurudeva Datta"
			+'\n'+'\n'
			+"6"
			+'\n'
			+"Hari Om yagnena yagnamayajanta devaastaani dharmaani prathamaabyaasan"+'\n'+"Tehanakam mahimaanah sachanta yatra poorve sadhyaa santi Devaah;"+'\n'+"Aum rajaadhiraajaaya prasahya saahine namo vayam Vaishravanaaya kurmahe"+'\n'+"Sa me kaaman kaama kaamaya mahyam kameswaro Vaishravano tathatu."+'\n'+"Kuberaraya Vaishravanaaya Mahaaraajaaya namah."+'\n'+"Om swasti saamrajyam bhojyam swaaraajyam vairaajyam, paarameshtyam"+'\n'+"Raajyam mahaarajya maadhi patya mayam Samantaparyaa yeesyat"+'\n'+"Saarvabhoumah saarvayushya aantaadaaparaaraadhaat prithivyai"+'\n'+"Samudraparyanthaayaa ekaraalithi"+'\n'+"Tadapyesha slokobhigeeto marutah parivestaaro marutah pariveshtaaro maruttasyaavasan gruhe"+'\n'+"Avikshitasya kamaprer Visvedevaah sabhaa sada ithi"+'\n'+"Shri Naarayana Vaasudevaaya Sri saccidananda Sadguru Sainatha Maharaja ki Jay"
			+'\n'+'\n'
			+"7"
			+'\n'
			+"Anantaa tulaa ten kase re sthavaave, Anantaa tulaa ten kase re namaave"+'\n'+"Anantaa mukhaanchaa shine shesh gaataan, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Smaraave hmanee twatpadaa nitya bhaave, Wurave taree bhaktisaattee swabhaave"+'\n'+"Tarave jagaa taarunee maaya taataa,Namaskaar saashtaang Shri Sainaatha."+'\n'+"Vase jo sadaa daavayaa santleela, Dise agna lokaanparee jo janaalaa"+'\n'+"Paree antaree gnaana kaiwalya daataa, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Baraa laadhalaa janma haa maanvaachaa Naraa saarthakaa saadhaneebhuta saacha"+'\n'+"Dharoon Sayeepremaa galaayaa ahantaa, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Dharave karee saana alpagna baala, Karaave amhaa dhanya chumboni gaalaa"+'\n'+"Mukhee gala preme karaa graas aataan, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Suraadeeka jyaanchyaa padaa vanditaantee, Sukadeeka jyaante samaanatva detee"+'\n'+"Prayagaadi teerthen padee nasmra hotaa, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Tujhyaa jhya padaa paahtan gopabaalee, Sadaa rangalee chitswaroopee milaalee"+'\n'+"Karee raasakreedaa save Krishna naathaa, Namaskaar saashtaang Shri Sainaatha."+'\n'+"Tulaa maahato maagane eka dhyaave, Karaa jodito deena atyanta bhaave"+'\n'+"Bhavee mohaneeraaja haa taari aataan, Namaskaar saashtaang Shri Sainaatha"
			+'\n'+'\n'
			+"8"
			+'\n'
			+"Aisaa eyee baa - Sayee digambaraa - Akshyaya roopa avataara"+'\n'+"Sarvahi vyapaka too - Shrutisaara - anusayaatrikumaaraa - Aisaa eyee baa!"+'\n'+"Kaashee snaana japa - pratidivashee - Kolhapura bhikshesee - nirmala nadi tungaa"+'\n'+"Jala praasee - Nidra maahur deshee - Aisaa eyee baa"+'\n'+"Jzholee lombatase vaamakaree - trishoola damaroo dhari"+'\n'+"Bhakta varada sadaa sukhakaaree Deseel mukti charee - Aisaa eyee baa"+'\n'+"Paayee paadukaa japamaala - kamandaloo - Mrigacchalaa - dhaarana kariseebaa"+'\n'+"Naagajataa - Mukuta sobhato maathaa - Aisaa eyee baa"+'\n'+"Tatpara tujyaa je dhyaanee - akshyaya Thyaanche sadhanee - Lakshmeevasa karee"+'\n'+"Dinarajanee - Rakshisi sankat vaaruni - Aisaa eyee baa"+'\n'+"Yaa pari dhyaana tujze gururaayaa - Drishya karee nayanaan yaa"+'\n'+"Poornaananda sukhe hee kaayaa - Laavise hariguna gaayaa - Aisaa eyee"
			+'\n'+'\n'
			+"9"
			+'\n'
			+"Sadaa satswaroopam chidaananda kandam"+'\n'+"Jagat sambhavasthaana samhaara hetum"+'\n'+"Swabhaktechhayaa maanusham darsayantam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Bhavadwaantha vidhwamsa maarthaanda meeddyam"+'\n'+"manovaagateetam munir dhyana gamyam"+'\n'+"Jagadvyapakam nirmalam nirgunam twaam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Bhawaambhodi magnaarthitaanaam lanaanaam"+'\n'+"Swapaadaasritaanaam swabhakti priyaanaam"+'\n'+"Samuddhaaranaartham kalow sambhavantam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Sadaa nimba vrikshasya mooladhivaasaat"+'\n'+"Sudhaasravinam tiktamapya priyantam"+'\n'+"Tarum kalpa vrikshaadhikam saadhayantam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Sadaa kalpavrikshyasya tasyaadhi moole"+'\n'+"Bhawadbhava budhyaa saparyaadisevaam"+'\n'+"Nrinaam kurwataam bhukti mukti pradantam"+'\n'+" Nameeswaram Sadgurum Sainaatham"+'\n'+"Anekaashrutaa tarkya leelaa vilaasaeih"+'\n'+"Samaavishkruteshaana bhaasvat prabhaavam"+'\n'+"Ahambhaava heenam prasannathma bhaawam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Sataam Vishramaaraama mevaabhiraamam"+'\n'+"sadaa sajjanaih samsthutam sannamadbhih"+'\n'+"Janaamodadam bhakta bhadrapradantam"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Ajanmaadhyamekam param brahma saakshaat"+'\n'+"Swayam sambhavam raamamevaavateernam"+'\n'+"Bhawadharshanaathsam puneetah praboham"+'\n'+"Nameeswaram Sadgurum Sainaatham."+'\n'+"Sree Sayeesa kripaanidhe akhilanrinaam sarwaartha siddhi prada"+'\n'+"Yushmatpaadarajah prabahavamatulam dhaataapi vaktaakshhamah"+'\n'+"Sadbhakthyaa saranam kritaan jali putah samprapthithosmi prabho"+'\n'+"Shrimath Sayi paresa paada kamalaa naanya ccharanyam mama"+'\n'+"Sayiroopadhara raaghavottamam, Bhakta kaama vibhuda dhrumam prabhum"+'\n'+"Maayayopahata chitta shudhayae, Chintayaamyahamaharnisam mudaa"+'\n'+"Sharat sudhaamsu pratrima prakaasam, kripatapaatram tava Sainaatha"+'\n'+"Twadeeya paadaabja samaashritaanaam, Swachhaayayaa taapamapaa karothu"+'\n'+"Upaasanaa Daivata Sainaatha, Sthavairmayopaasaninaasthu sthatwam"+'\n'+"Ramenmaromne tava paadayugme bhrungo, Yathaabji makarmda lubdhah"+'\n'+"Aneka janmaarjita paapasamkshayo, Bhavet bhawatpaada saroja darshanaat"+'\n'+"Kshamaswa sarvaanaparaadha poonjakaan, praseeda Sayeesa Sadguro dayaanidhe"+'\n'+"Sri Sainatha charanaamrita putachithaah,"+'\n'+"Sthwatpaada seva natrataah satatamcha bhaktyaa"+'\n'+"Samsaara janya duritaagha vinirgataaste,"+'\n'+"kaivalya dhaama paramam samavaapnuvanti"+'\n'+"Strotrame tatpatte bhakthyaa yonara athanmanaahsadaa"+'\n'+"Sadguroh Sainaadhasya kripa paatram bhaveddhruham."+'\n'+"Karacharanakritam vaakkaayajam karmajam vaa"+'\n'+"Shravananayanajam vaa maanasam vaaparadham"+'\n'+"Viditamaviditam vaa sarvame tatshkamasva"+'\n'+"Jaya Jaya karunaabdhe shri pabho sainaatha."+'\n'+'\n'+"Shri Satchitaanand Sadguru Sainaath Maharaaj ki"+'\n'+'\n'+" Aum Raajaadhiraaja Yogiraaja ParaBrahma Sainaath Maharaaj"+'\n'+'\n'+" Shri Satchitaanand Sadguru Sainaath Maharaaj ki jai"
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
		mediaPlayer = MediaPlayer.create(this, R.raw.maa1);
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
