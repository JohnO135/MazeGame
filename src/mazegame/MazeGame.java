package mazegame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author scott
 */
public class MazeGame {

    //need to edit path file for these images
    static String loadURL = "loading.gif";
    static String introURL = "Intro_Instructions.PNG";

    public static void main(String[] args) {
        Screen loadScreen = new Screen();
        MainMenu mainScreen = new MainMenu();
        loadScreen.createScreen(loadURL);
        int secondsToSleep = 3;
        try {
            Thread.sleep(secondsToSleep * 1000);
            loadScreen.visibility();
            mainScreen.createMain(introURL);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
