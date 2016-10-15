/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollthosedice;

import java.util.Random;

/**
 *
 * @author erica
 */
public class RandomNumber {

    //Metod, genererar tärningsslag och returnerar värde 1-6.    
    public static int getRandomNumber() {
        Random rand = new Random();

        int randomReturn = rand.nextInt(6) + 1;

        return randomReturn;

    }

}
