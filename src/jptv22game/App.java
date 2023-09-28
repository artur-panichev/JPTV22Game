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

    final Random random;
    final Scanner scanner;
    boolean repeat;
    
    public App() {
        this.random = new Random();
         this.scanner = new Scanner(System.in);
         this.repeat = true;
    }
    
    
    public void run(){
        System.out.println("----- Game -----");
        do{
            boolean win = false;
            int tries = 3;
            int number = this.random.nextInt(9)+1;
            System.out.println("Угадайте число от 1 до 9");
            do{
                int userInt;
                do{
                    try{
                        System.out.print("Ваш ответ: ");
                        userInt = this.scanner.nextInt(); this.scanner.nextLine();
                        break;
                    } catch(Exception e){
                        this.scanner.nextLine();
                        System.out.println("Не верный ввод!");
                    } 
                } while(true);

                if(userInt == number){
                    System.out.println("Вы победили");
                    win = true;
                } else if(userInt > number){
                    System.out.println("Загаданное число меньше");
                } else{
                    System.out.println("Загаданное число больше");
                }
                tries--;
            }while(tries > 0 && win == false);
            if(!win){
                System.out.println("Вы проиграли! Задуманное число: " + number);

            }
            System.out.print("Для выхода введите \"q\" или любой другой символ для продолжения: ");
            String userExit = this.scanner.nextLine();

            if("q".equals(userExit)){
                this.repeat = false;
            }
        }while(this.repeat);
        
        System.out.println("----- End Game -----");

    }
}
