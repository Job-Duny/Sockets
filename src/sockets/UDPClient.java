/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Job_M
 */
class UDPClient
{        
   public static void main (String args[]) throws Exception
  {
      BufferedReader inFromUser = new BufferedReader ( new InputStreamReader( System.in ) ) ;
      DatagramSocket clientSocket = new DatagramSocket ( ) ;
      InetAddress IPAddress = InetAddress.getByName ( "localhost" ) ;
      byte [ ] sendData = new byte [ 1024 ] ;         
      byte [ ] receiveData = new byte [ 1024 ] ;
      String sentence = inFromUser.readLine ( ) ;
      sendData = sentence.getBytes ( ) ;
      DatagramPacket sendPacket = new DatagramPacket ( sendData , sendData.length , IPAddress , 9876 ) ;
      clientSocket.send(sendPacket) ;
      DatagramPacket receivePacket = new DatagramPacket ( receiveData , receiveData.length ) ;
      clientSocket.receive(receivePacket) ;
      String modifiedSentence = new String( receivePacket.getData()) ;
      System.out.println ( " FROM SERVER : " + modifiedSentence ) ;
      clientSocket.close ( ) ;
      
  }
}
