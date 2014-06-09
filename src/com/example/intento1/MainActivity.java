package com.example.intento1;

import com.example.intento1.MainActivity2;
import com.example.intento1.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	MediaPlayer mepe;
	int pos = 0;
	
	Button start; 
	Button stop;
    TextView tiempo;
    int h=0,m=0,s=0;
    boolean bandera=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		start= (Button)findViewById(R.id.btnStart);
		stop=(Button)findViewById(R.id.btnStop);
        tiempo=(TextView)findViewById(R.id.tiempo);
        
        start.setOnClickListener(empieza);
        stop.setOnClickListener(para);}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//*******************Cronometro de canción********************************//
	
	public void correcta() {
        Toast t=Toast.makeText(this,"Congratulation, this right - can continue", Toast.LENGTH_SHORT);
        t.show();
        if(mepe != null && mepe.isPlaying()==false){
			mepe.start();
			bandera=true;
            hilador();
            tiempo.setText(""+h+" : "+m+" : "+s);
            start.setText("Pausa");
            start.setOnClickListener(pausa);}};
        
    
    
    public void incorrecta() {
    	 Toast t=Toast.makeText(this,"Wrong answer, you'll have to return to top.", Toast.LENGTH_SHORT);
         t.show();
        finish();
        if(mepe != null){
    		mepe.stop();
    		}
    }
    
	public void hilador(){
		mepe = MediaPlayer.create(this,R.raw.tv);
		Thread cronometro = new Thread(){
	        public void run(){
	                try{
	                        while(bandera==true){
	                        handler.post(proceso);
	                        Thread.sleep(1000);
	                        }
	                }
	                catch(Exception e){
	                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	                        b.show();
	                }
	        }
	    };
	    
	    
	    
	   cronometro.start(); }

	Handler handler = new Handler();
	   
	Runnable proceso = new Runnable(){
        public void run() {
                try{
                        tiempo.setText(" "+h+" : "+m+" : "+s);
                        s++;
                        if(s==60){m++;s=0;}
                        if(m==60){h++;m=0;}
                        if(s==1){mepe.start();}
                        
                        if(s==31 && mepe.isPlaying()){mepe.pause();}
                        if(s==31){bandera=false;
                		tiempo.setText("-pausado->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}
                        
//***********************************Preguntas *********************************************      
                        
              //--------Pregunta1          
                        if(s==31){
                        	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);  
                            dialogo1.setTitle("Question 1");  
                            dialogo1.setMessage("¿ What did we do last week?");            
                            dialogo1.setCancelable(false);  
                            dialogo1.setPositiveButton("The same old thing", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    correcta();  
                                }  
                            });  
                            dialogo1.setNegativeButton("Dance all day", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                                  
                            dialogo1.setNegativeButton("Walk on the Street", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                            dialogo1.show();    
                        }
                        
                        if(s==31 && mepe.isPlaying()){mepe.pause();}
                        if(s==31){bandera=false;
                		tiempo.setText("-pausado->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}
                        
                        
                        
            //------Pregunta2-------
                        
                        if(s==47){
                        	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);  
                            dialogo1.setTitle("Question 2");  
                            dialogo1.setMessage("¿ Where mom and dad live??");            
                            dialogo1.setCancelable(false);  
                            dialogo1.setPositiveButton("upstairs", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    correcta();  
                                }  
                            });  
                            dialogo1.setNegativeButton("Donw", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                            dialogo1.setNegativeButton("with neighbors", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                             
                            dialogo1.show();    
                        }
                        
                        if(s==47 && mepe.isPlaying()){mepe.pause();}
                        if(s==47){bandera=false;
                		tiempo.setText("-pausado->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}
                        
                        
                 //----- Pregunta 3                        
                        if(m==1){
                        	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);  
                            dialogo1.setTitle("Question 3");  
                            dialogo1.setMessage("¿When live Rock?");            
                            dialogo1.setCancelable(false);  
                            dialogo1.setPositiveButton("Tomorrow", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();  
                                }  
                            });  
                            dialogo1.setNegativeButton("Yesterday", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                            dialogo1.setNegativeButton("Now", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    correcta();
                                }  
                            });       
                             
                            dialogo1.show();    
                        }
                        
                        if(m==1 && mepe.isPlaying()){mepe.pause();}
                        if(m==1){bandera=false;
                		tiempo.setText("-pausado->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}
                        
//*******************************Pregunta 4 *****************************************************
                        if(m==1 && s==30){
                        	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);  
                            dialogo1.setTitle("Question 4");  
                            dialogo1.setMessage("¿Where are we rocking?");            
                            dialogo1.setCancelable(false);  
                            dialogo1.setPositiveButton("in China", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();  
                                }  
                            });  
                            dialogo1.setNegativeButton("in wisconsin", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    correcta();
                                }  
                            });       
                            dialogo1.setNegativeButton("in the beach", new DialogInterface.OnClickListener() {  
                                public void onClick(DialogInterface dialogo1, int id) {  
                                    incorrecta();
                                }  
                            });       
                             
                            dialogo1.show();    
                        }
                        
                        if(m==1 && s==30 &&mepe.isPlaying()){mepe.pause();}
                        if(m==1 && s==30){bandera=false;
                		tiempo.setText("-pausado->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}
//  ***************************En el caso que ahiga errores ************************************
                   }
                catch(Exception e){                    
                                           
                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
                            b.show();     }
                }};
                
//*******************Cambiar nombre a botones y funciones ******************************************                
                
                OnClickListener empieza =new OnClickListener(){
                    public void onClick(View arg0) {
                            bandera=true;
                            hilador();
                            start.setOnClickListener(pausa);
                            start.setText("Pausa");}};
                            
                            
                OnClickListener pausa =new OnClickListener(){
                
                	public void onClick(View arg0) {
                		bandera=false;
                		tiempo.setText("-->"+h+" : "+m+" : "+s);
                		start.setText("Continuar");
                		start.setOnClickListener(continua);}};
                		
                		
                OnClickListener continua =new OnClickListener(){
                    public void onClick(View arg0) {
                        bandera=true;
                        hilador();
                        tiempo.setText(""+h+" : "+m+" : "+s);
                        start.setText("Pausa");
                        start.setOnClickListener(pausa);}};
                        
                        
                 OnClickListener para =new OnClickListener(){
                     public void onClick(View arg0) {
                        bandera=false;
                        tiempo.setText("Tiempo");
                        m=0;s=m;h=m;   
                        start.setText("Empezar");
                        start.setOnClickListener(empieza);}};
                        
}
