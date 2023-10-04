/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
    private void saveBalance(int balance){
        try{
            File file = new File("data.txt");
            file.createNewFile();

            FileWriter fileWriter = new FileWriter("data.txt");
            fileWriter.write(balance);
            fileWriter.close(); 
        } catch(Exception e){
            System.out.println("Ошибка сохранения баланса!");
        }
        
    }
    
    private int loadBalance(){
        try{
            File file = new File("data.txt");
            Scanner data = new Scanner(file);
            return Integer.parseInt(data.nextLine());
        } catch(Exception e){
            saveBalance(10);
        }
        return 10;
    }
    
    public void run(){
        System.out.println("----- Game -----");
        int money = loadBalance();
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
                    money++;
                } else if(userInt > number){
                    System.out.println("Загаданное число меньше");
                } else{
                    System.out.println("Загаданное число больше");
                }
                tries--;
            }while(tries > 0 && win == false);
            if(!win){
                System.out.println("Вы проиграли! Задуманное число: " + number);
                money--;

            }
            System.out.println("Ваш баланс: " + money);
            if(money <= 0){
                System.out.println("У вас кончились деньги, вы не можете продолжить игру!");
                System.out.print("Хотите пополнить баланс? (y): ");
                String isUserDeb = this.scanner.nextLine();
                if(isUserDeb.equals("y")){
                    int userDeb;
                    do{
                        try{
                            System.out.print("Введите сумму пополнения: ");
                            userDeb = this.scanner.nextInt(); this.scanner.nextLine();
                            break;
                        } catch(Exception e){
                            System.out.println("Не верный ввод!");
                        }
                    } while(true);
                    
                    money += userDeb;
                    System.out.println("Ваш новый баланс: " + money);
                } else{
                    System.out.println("Вы не можете продолжать без денег");
                    System.out.println("----- End Game -----");
                    return;
                }
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
 