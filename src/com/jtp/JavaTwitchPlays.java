package com.jtp;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jibble.pircbot.PircBot;


public class JavaTwitchPlays extends PircBot {
	
	public String acc_name;
	public String acc_auth;
	public String listen_channel;
	public int num_of_commands;
	public String[][] inputs = new String[100][4];
	public int[] inputTime = new int[100];

	public void connect(){
		try {

			this.setName(acc_name);
			this.changeNick(acc_name);
			this.connect("irc.twitch.tv", 6667, acc_auth);
			this.joinChannel("#" + listen_channel);
			System.out.println("[LOG]  CONNECTION SUCCESFUL");
			
		} catch(Exception e){
			e.printStackTrace();
		}
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
			    	 System.out.println("[LOG]  SET ACC_NAME TO " + acc_name);
			     }
			     if(i == 1){
			    	 acc_auth = Line;
			    	 System.out.println("[LOG]  SET ACC_AUTH TO " + acc_auth);
			     }
			     if(i == 2){
			    	 listen_channel = Line;
			    	 System.out.println("[LOG]  SET LISTEN_CHANNEL TO " + listen_channel);
			     }
			     if(i == 3){
			    	 num_of_commands = Integer.parseInt(Line);
			    	 System.out.println("[LOG]  SET NUM_OF_COMMANDS TO " + num_of_commands);
			     }
		     }
		     System.out.println("[LOG] LOADED JTP.INI[LOG] ");
		     this.readcmd();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void readcmd(){
		try {
			 InputStream ips=new FileInputStream("cmd.ini"); 
		     InputStreamReader ipsr=new InputStreamReader(ips);
		     BufferedReader br=new BufferedReader(ipsr);
			
		     for(int i = 0; i < num_of_commands; i++){
		    	 String line = br.readLine();
			     String[] LineSplit = line.split(",");
			     inputs[i][0] = LineSplit[0];
			     inputs[i][1] = (LineSplit[1]);
			     inputs[i][2] = (LineSplit[2]);
		    	 System.out.println("[LOG] LOADING CMD.INI #" + i + " --> " + line);
		     }	
			    System.out.println("[LOG] LOADED CMD.INI");
			    this.connect();
			    this.loop();
		} catch(Exception e){ 
			e.printStackTrace(); 
		}
	}
	
	public void loop(){
		try {	
			
			Robot bot = new Robot();
			long delta = System.currentTimeMillis();
		
			while(true){
		
				for(int i = 0; i < num_of_commands; i++){
					if(inputTime[i] > 0){
						inputTime[i]--;
					} else {
						bot.keyRelease(Integer.parseInt(inputs[i][1]));
					}
				}
				
			Thread.sleep(1 - (System.currentTimeMillis()-delta));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * onMessage method is called by the PircBot Client, this should not in any case be called by the user.
	 */
	public void onMessage(String channel, String sender, String login, String hostname, String message){
		try {
			Robot bot = new Robot();
			for(int i = 0; i < 4; i++){
				if(message.toLowerCase().equals(inputs[i][0])){
					System.out.println("[INPUT PARSED] " + message);
					inputTime[i] = Integer.parseInt(inputs[i][2]);
					bot.keyPress(Integer.parseInt(inputs[i][1]));
				}
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JavaTwitchPlays jtp = new JavaTwitchPlays();
		jtp.readinf();
	}
}
