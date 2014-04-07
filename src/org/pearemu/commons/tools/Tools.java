/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pearemu.commons.tools;

import java.util.Random;

/**
 *
 * @author moonlight83340,vincent4vx
 */
public class Tools {
    final static private Random rand = new Random();
    
    public static int rand(int max){
        return rand.nextInt(max);
    }
    
}
