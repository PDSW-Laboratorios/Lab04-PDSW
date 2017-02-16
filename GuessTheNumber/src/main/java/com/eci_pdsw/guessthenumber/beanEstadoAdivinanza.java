/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci_pdsw.guessthenumber;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fabian
 */
@ApplicationScoped
@ManagedBean(name="beanEstadoAdivinanza")
public class beanEstadoAdivinanza implements Serializable{
    
    private static final int INITIAL_PRIZE = 100000;
    private static final int MINIMUM_PRIZE = 0;
    private static final int MAXIMUM_PRIZE = INITIAL_PRIZE;
    private static final int MAXIMUM_VALUE = 20;
    private static final int STEPS = 10000;
    private static final String status1 = "Sigue intentando, te falta poco para lograrlo.";
    private static final String status2 = "¡Ganaste! Tu premio es de ";
    private static final String status3 = "Lo siento, intentalo de nuevo reiniciando el juego.";
    
    private int number;
    private int guessedNumber;
    private int attempts;
    private int prize;
    private String gameStatus;
    
    public beanEstadoAdivinanza() {
        number = (int) (Math.random() * MAXIMUM_VALUE);
        attempts = 0;
        prize = INITIAL_PRIZE;
        gameStatus = status1;
    }
    
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
    
    public int getGuessNumber() {
        return guessedNumber;
    }
    
    public void process() {
        if (prize > MINIMUM_PRIZE) {
            if (this.guessedNumber == number) {
                gameStatus = status2 + prize;
            } else {
                prize = bounds(prize - STEPS, MINIMUM_PRIZE, MAXIMUM_PRIZE);
                gameStatus = status1;
                if (prize == 0){
                    gameStatus = status3;
                }
                attempts++;
            }
        }
    }
    
    public void setGuessNumber(int guessedNumber) {
        this.guessedNumber = guessedNumber;
    }
    
    public void reiniciar(){
        number = (int) (Math.random() * MAXIMUM_VALUE);
        attempts = 0;
        prize = INITIAL_PRIZE;
        gameStatus = status1;
    }
}
