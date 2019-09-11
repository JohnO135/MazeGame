/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MazeGame {

    //need to edit path file for these images
    static String loadURL = "C:\\Users\\theme\\eclipse-workspace\\MazeGame\\src\\loading.gif";
    static String introURL = "C:\\Users\\theme\\eclipse-workspace\\MazeGame\\src\\Intro_Instructions.PNG";

    public static void main(String[] args) {
        Screen loadScreen = new Screen();
        loadScreen.createScreen(loadURL);
        int secondsToSleep = 3;
        try {
            Thread.sleep(secondsToSleep * 1000);
            loadScreen.visibility();
            Screen introScreen = new Screen();
            introScreen.createScreen(introURL);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
