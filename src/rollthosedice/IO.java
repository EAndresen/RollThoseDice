/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollthosedice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erica
 */
public class IO {

    //Instans varaible
    ArrayList highscore = new ArrayList(); //Lista för att lagra highscore

    //Konstruktor
    public IO() throws FileNotFoundException, IOException {

        //Läser in befintlig highscore och stoppar i Listan highscore
        try (BufferedReader inFil = new BufferedReader(new FileReader("highscore.txt"))) {
            for (int n = 0; n <= 5; n++) {
                String number = inFil.readLine();
                if (number == null) {
                    break;
                }

                int lagringsNummer = Integer.parseInt(number);   //Konverterar textfilens sträng till int
                highscore.add(lagringsNummer);                   //Stoppar in det lagrade nummret i highscore listan 

            }
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Tar vinnarens värde och placerar i highscorelistan
    //Sorterar sedan och skriver toppresultaten till highscore textfilen
    public void inData(int winner) throws IOException {
        String utString = "";

        highscore.add(winner);
        Collections.sort(highscore, Collections.reverseOrder());

        for (int i = 0; i < 6; i++) {
            utString += highscore.get(i) + "\n";
        }

        try (PrintWriter utFil = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt")))) {
            utFil.println(utString);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    //Tar den inlästa highscore listan formaterar en sträng och returnerar.
    public String outData() throws FileNotFoundException, IOException {
        String highscoreOutput = "";
        for (int p = 0; p < 5; p++) {
            highscoreOutput += " " + highscore.get(p) + "\n";
        }

        return highscoreOutput;
    }

    //Tömmer befintlig highscore lista och fyller den med nollor.
    //Skriver sedan ut den nya listan till higscore textfilen
    public String resetHighScore() throws IOException {
        String reset = " 0\n" + " 0\n" + " 0\n" + " 0\n" + " 0\n";
        String resetToFile = "0\n" + "0\n" + "0\n" + "0\n" + "0\n" + "0\n";

        highscore.clear();
        highscore.add(0);
        highscore.add(0);
        highscore.add(0);
        highscore.add(0);
        highscore.add(0);
        highscore.add(0);
        highscore.add(0);

        try (PrintWriter utFil = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt")))) {
            utFil.println(resetToFile);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reset;
    }

}
