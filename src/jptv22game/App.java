/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class App {

    Random random = new Random();
    
    public App() {
        this.random = new Random();
    }
    
    
    public void run(){
        
        int number = this.random.nextInt(10)+1;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Угадайте число от 1 до 10");
        
        System.out.print("Ваш ответ: ");
        int answer = scanner.nextInt(); scanner.nextLine();
        
        if(answer == number){
            System.out.println("Вы победили");
        }
        else{
            System.out.println("Вы проиграли!");
        }

    }
}
