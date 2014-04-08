/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pearemu.commons.tools;

/**
 *
 * @author p13006381
 */

  public class Pair<F, S>{
      final private F first;
      final private S second;

       public Pair(F first, S second) {
           this.first = first;
           this.second = second;
       }

       public F getFirst() {
           return first;
       }

       public S getSecond() {
           return second;
       }
}

