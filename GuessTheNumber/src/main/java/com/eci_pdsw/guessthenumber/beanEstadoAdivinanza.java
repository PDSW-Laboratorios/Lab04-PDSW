/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci_pdsw.guessthenumber;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author fabian
 */
@ManagedBean(name="beanEstadoAdivinanza")
@SessionScoped
public class beanEstadoAdivinanza implements Serializable{
    
    private static final int INITIAL_PRIZE = 100000;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 100;
    private static final int STEPS = 10000;
    private static final String status1 = "Sigue intentando, te falta poco para lograrlo.";
    private static final String status2 = "¡Ganaste! Tu premio es de ";
    
    
    private boolean showSend=true;
    private boolean showReset=true;
    private int number;
    private int attempts;
    private int prize;
    private String gameStatus;
    
    
    public int getNumber() {
        return number;
    }
    
    public int getAttempts() {
        return attempts;
    }
    
    public int getPrize() {
        return prize;
    }
    
    public String getStatus() {
        return gameStatus;
    }
    
    private int bounds(int value, int min, int max) {
        return Math.max(Math.min(value, max), min);
    }
    
    public void setGuessNumber(int guessedNumber) {
        if (prize > MINIMUM) {
            if (guessedNumber == number) {
                gameStatus = status2 + prize;
            } else {
                gameStatus = status1;
                prize = bounds(prize - STEPS, MINIMUM, MAXIMUM);
                attempts++;
            }
        }
    }
    
    public void reiniciar(){
        number = (int) (Math.random() * MAXIMUM);
        attempts = 0;
        prize = INITIAL_PRIZE;
        gameStatus = status1;
    }
}
