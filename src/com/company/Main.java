package com.company;
import java.util.Scanner;
class Calc{
    private int number1;
    private int number2;
    private int rezult;
    private double rezultD;
    private char znak;
    protected boolean metka;
    //--------------------------------------
    protected void setNumber1(int number){
        number1 = number;
    }
    protected void setNumber2(int number){
        number2 = number;
    }
    protected void setRezult(int number){
        rezult = number;
    }
    protected void setRezultDouble(double number){
        rezultD = number;
    }
    protected void setZnak(char newZnak){
        znak = newZnak;
    }
    //--------------------------------------
    protected int getNumber1(){
        return number1;
    }
    protected int getNumber2(){
        return number2;
    }
    protected int getRezult(){
        return rezult;
    }
    protected double getRezultDouble(){
        return rezultD;
    }
    protected char getZnak(){
        return znak;
    }
    //--------------------------------------
    final private char plus = '+';
    final private char minus = '-';
    final private char multiplication  = '*';
    final private char division  = '/';
    boolean isDigit(String str){
        if (str.equals("10") || str.equals("9") || str.equals("8") || str.equals("7") || str.equals("6") || str.equals("5")
                || str.equals("4") || str.equals("3") || str.equals("2") || str.equals("1") || str.equals("0")) return true;

        return false;

    }
    boolean isPlus_etc(String str){
        for (char c : str.toCharArray()) {
            if (c==plus) {
                setZnak(c);
                return true;
            }
            else if (c==minus) {
                setZnak(c);
                return true;
            }
            else if (c==multiplication) {
                setZnak(c);
                return true;
            }
            else if (c==division) {
                setZnak(c);
                return true;
            }
        }
        return false;

    }

    public int sum(int num1, int num2){
        return num1 + num2;
    }
    public int min(int num1, int num2){
        return num1 - num2;
    }
    public int umn(int num1, int num2){
        return num1 * num2;
    }
    public double del(int num1, int num2){
        if (num2 == 0){
            System.out.println("Input error - division by zero");
            System.exit(0);
        }
        double num = (double)num1 / (double)num2;
        return num;
    }


}
class RimCalc extends Calc{
    private int RimToArabNumber;
    private int number;
    private String ArabToRimString;
    private String s;
    public void setRimToArabnumber(int number){
        RimToArabNumber = number;
    }
    public int getRimToArabnumber(){
        return RimToArabNumber;
    }
    public void setArabToRimString(String str){
        ArabToRimString = str;
    }
    public String getArabToRimString(){
        return ArabToRimString;
    }
    public void isTrueInput(String newStr){
        String[] words = newStr.split(" ");

        for(int i=0;i<3;i++){
            if (isDigit(words[i]) | isPlus_etc(words[i]) | isRimDigit(words[i])) {
                continue;
            }
            else{
                System.out.println("Input error");
                System.exit(0);
            }
        }
        if (isDigit(words[0]) & isDigit(words[2])){
            setNumber1(Integer.parseInt(words[0]));
            setNumber2(Integer.parseInt(words[2]));
            metka = true;

        }
        else if (isRimDigit(words[0]) & isRimDigit(words[2])){
            setNumber1(setRimToArab(words[0]));
            setNumber2(setRimToArab(words[2]));
            metka = false;
        }
        else{
            System.out.println("Input error");
            System.exit(0);
        }


    }
    public boolean isRimDigit(String str){
        if (str.equals("I") || str.equals("II") || str.equals("III") || str.equals("IV") || str.equals("V") || str.equals("VI")
                || str.equals("VII") || str.equals("VIII") || str.equals("IX") || str.equals("X")) return true;

        return false;
    }
    public String ArabToRim(){
        if (!(getZnak()=='/')) number = getRezult();
        else number = (int)getRezultDouble();

        s = "";
        if (number==0) s+= "0";
        while (number >= 100) {
            s += "C";
            number -= 100;
        }
        while (number >= 90) {
            s += "XC";
            number -= 90;
        }
        while (number >= 50) {
            s += "L";
            number -= 50;
        }
        while (number >= 40) {
            s += "XL";
            number -= 40;
        }
        while (number >= 10) {
            s += "X";
            number -= 10;
        }
        while (number >= 9) {
            s += "IX";
            number -= 9;
        }
        while (number >= 5) {
            s += "V";
            number -= 5;
        }
        while (number >= 4) {
            s += "IV";
            number -= 4;
        }
        while (number >= 1) {
            s += "I";
            number -= 1;
        }


        return s;

    }
    public int setRimToArab(String str){

        if (str.equals("I")) setRimToArabnumber(1);
        else if (str.equals("II")) setRimToArabnumber(2);
        else if (str.equals("III"))setRimToArabnumber(3);
        else if (str.equals("IV")) setRimToArabnumber(4);
        else if (str.equals("V")) setRimToArabnumber(5);
        else if (str.equals("VI")) setRimToArabnumber(6);
        else if (str.equals("VII")) setRimToArabnumber(7);
        else if (str.equals("VIII")) setRimToArabnumber(8);
        else if (str.equals("IX")) setRimToArabnumber(9);
        else if (str.equals("X")) setRimToArabnumber(10);
        return getRimToArabnumber();
    }

    public void Print(){
        if (getZnak()=='/'){
            setRezultDouble(del(getNumber1(), getNumber2()));
            if (metka) System.out.println(getRezultDouble());
            else{
                setArabToRimString(ArabToRim());
                System.out.println(getArabToRimString());
            }
        }
        else if (getZnak()=='-'){
            setRezult(min(getNumber1(), getNumber2()));
            if (metka) System.out.println(getRezult());
            else{
                setArabToRimString(ArabToRim());
                System.out.println(getArabToRimString());
            }

        }
        else if (getZnak()=='*'){
            setRezult(umn(getNumber1(), getNumber2()));
            if (metka) System.out.println(getRezult());
            else{
                setArabToRimString(ArabToRim());
                System.out.println(getArabToRimString());
            }
        }
        else if (getZnak()=='+'){
            setRezult(sum(getNumber1(), getNumber2()));
            if (metka) System.out.println(getRezult());
            else{
                setArabToRimString(ArabToRim());
                System.out.println(getArabToRimString());
            }
        }

    }
}
public class Main {

    public static void main(String[] args) {
        RimCalc ob = new  RimCalc();
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.println("Input:");
            String str = in.nextLine();//get as string
            try {

                ob.isTrueInput(str);//check
                System.out.println("Output:");
                ob.Print();

            } catch (ArithmeticException е ){
                System.out.println("Input error - division by zero");
            }
        }
    }
}
