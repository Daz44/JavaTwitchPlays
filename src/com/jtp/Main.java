package com.jtp;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jibble.pircbot.PircBot;


public class Main extends PircBot {
	
	public static String acc_name;
	public static String acc_auth;
	public static String listen_channel;
	public static int num_of_commands;
	public static String[][] inputs = new String[10][4];
	public static int[] inputtime = new int[10];
	public static boolean updown = false;
	
	public void connect(){
	try {
		//this.setVerbose(true);
		this.setName(acc_name);
		this.changeNick(acc_name);
		this.connect("irc.twitch.tv", 6667, acc_auth);
		this.joinChannel("#" + listen_channel);
		System.out.println("--CONNECTION SUCCESFUL");
		} catch(Exception e){}
	}
	public void readinf(){
	try {
		 InputStream ips=new FileInputStream("jtp.ini"); 
	     InputStreamReader ipsr=new InputStreamReader(ips);
	     BufferedReader br=new BufferedReader(ipsr);
	     
	     
	     for(int i = 0; i < 4; i++){
	     String[] LineSplit = br.readLine().split("=");
	     String Line = LineSplit[1].trim();
	     
	     if(i == 0){
	    	 acc_name = Line;
	    	 System.out.println("## SET ACC_NAME TO " + acc_name);
	     }
	     if(i == 1){
	    	 acc_auth = Line;
	    	 System.out.println("## SET ACC_AUTH TO " + acc_auth);
	     }
	     if(i == 2){
	    	 listen_channel = Line;
	    	 System.out.println("## SET LISTEN_CHANNEL TO " + listen_channel);
	     }
	     if(i == 3){
	    	 num_of_commands = Integer.parseInt(Line);
	    	 System.out.println("## SET NUM_OF_COMMANDS TO " + num_of_commands);
	     }
	     }
	     System.out.println("##LOADED JTP.INI##");
	     this.readcmd();
	    // System.out.println("##EOF##");
	     
	} catch(Exception e){}
	}
	public void readcmd(){
	try {
		 InputStream ips=new FileInputStream("cmd.ini"); 
	     InputStreamReader ipsr=new InputStreamReader(ips);
	     BufferedReader br=new BufferedReader(ipsr);
		
	     for(int i = 0; i < num_of_commands; i++){
	    	 System.out.println(i);
		     String[] LineSplit = br.readLine().split(",");
		     inputs[i][0] = LineSplit[0];
		     inputs[i][1] = (LineSplit[1]);
		     inputs[i][2] = (LineSplit[2]);
	     }	
		    System.out.println("###LOADED CMD.INI###");
		    this.connect();
		    this.loop();
	} catch(Exception e){ e.printStackTrace(); }
	}
	public void loop(){
	try {	
	Robot bot = new Robot();
	while(true){

		for(int i = 0; i < num_of_commands; i++){
			if(inputtime[i] > 0){
				inputtime[i]--;
			} else {
				bot.keyRelease(Integer.parseInt(inputs[i][1]));
			}
		}
		
	Thread.sleep(1);
	}
	} catch(Exception e){}
	}
	public void onMessage(String channel, String sender, String login, String hostname, String message){
		try {
			Robot bot = new Robot();
			for(int i = 0; i < 4; i++){
			if(message.toLowerCase().equals(inputs[i][0])){
				System.out.println("--INPUT PARSED");
				inputtime[i] = Integer.parseInt(inputs[i][2]);
				bot.keyPress(Integer.parseInt(inputs[i][1]));
			}
			}
			
		} catch (Exception e) {}
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.readinf();
	}
}
