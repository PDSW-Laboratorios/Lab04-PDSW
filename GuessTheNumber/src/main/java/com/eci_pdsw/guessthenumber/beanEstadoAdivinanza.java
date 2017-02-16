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
@ManagedBean(name = "beanEstadoAdivinanza")
@SessionScoped
public class beanEstadoAdivinanza implements Serializable{
    
    private int number;
    private int maximum = 100;
    private int attempts;
    private int prize;
    private int iniPrize = 100000;
    private String gameStatus;
    private String status1 = "Sigue intentando, te falta poco para lograrlo.";
    private String status2 = "¡Ganaste! Tu premio es de ";
    
    public void reiniciar(){
        number = (int) (Math.random()*maximum);
        attempts = 0;
        prize = iniPrize;
        gameStatus = status1;
    }
}
