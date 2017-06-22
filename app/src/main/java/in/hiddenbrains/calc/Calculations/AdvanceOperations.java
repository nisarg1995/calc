package in.hiddenbrains.calc.Calculations;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

import static java.lang.Math.*;

public class AdvanceOperations {

    public static Double addition(Double number1 , Double number2){
        number1=number1+number2;
        return number1;
    }
    public static Double substraction(Double number1, Double number2){

        return number1 - number2;
    }
    public static Double multiplication(Double number1 , Double number2){

        return number1 * number2;
    }
    public static Double division(Double number1 , Double number2){

        if(number2!=0) {
            return (number1 / number2);
        }
        else {
            number1 = 1.0;
            return number1;
        }
    }
    public static Double factorial(Integer number1){

        double result=1;
        for(int i=1;i<=number1;i++)
        {
            result = result * i;
        }
        return result;
    }
    public static Double power (Double number1,Double number2){

        number1=power(number1, number2);
        return number1;
    }
    public static Double root(Double number1,int m){

        number1=sqrt(number1);
        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        else {
            return number1;
        }
    }
    public static Double pi() {

        return 3.14159265359;
    }
    public static Double sine(Double number1,int a,int m){

        number1=sin(number1);

        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }

        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        return number1;
    }
    public static Double cose(Double number1,int a,int m){

        number1=cos(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }

        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        return number1;
    }
    public static Double tane(Double number1,int a,int m){

        number1=tan(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        return number1;
    }
    public static Double ln(Double number1,int m){

        number1= log(number1);
        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;
        }
        else {
            return number1;
        }
    }
    public static Double logee(Double number1,int m){
        number1=log10(number1);
        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        else {
            return number1;
        }
    }
    public static Double e(){
        return 2.71828;
    }

    public static Double sinhe(Double number1,int a){
        number1=sinh(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }

    public static Double coshe(Double number1,int a){
        number1=cosh(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }

    public static Double tanhe(Double number1,int a){
        number1=tanh(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }

    public static Double sininverse(Double number1,int a){

        number1 = asin(number1);

        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }

    public static Double cosinverse(Double number1,int a){
        number1=acos(number1);

        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }
    public static Double taninverse(Double number1,int a){
        number1=atan(number1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }
    public static Double sinhinverse(Double number1,int a){
        number1=ln((number1 + sqrt(number1 * number1 + 1)), 1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }
    public static Double coshinverse(Double number1,int a){
        number1=ln((number1 + sqrt((number1 * number1) - 1)),1);
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }
    public static Double tanhinverse(Double number1,int a){
        number1=(ln(((1+number1)/(1-number1)),1))/2;
        if(a==1) {

            Double f=180/pi();
            number1=number1*f;

        }
        Integer i= number1.intValue();
        double s1= number1-i;
        if(s1>=0.9999999 && s1!=0) {
            number1 = Double.valueOf(round(number1));
        }
        return number1;
    }
    public static Double inverse(Double number1){
        number1=1/number1;
        return number1;
    }
    public static Double powerof2(Double number1){
        number1=pow(2,number1);
        return number1;
    }

    public static Double powerxy(Double number1,Double number2){
        number1=pow(number1,number2);
        return number1;
    }
    public static Double cube(Double number1){
        number1=number1*number1*number1;
        return number1;
    }
    public static Double cuberoot(Double number1,int m){
        number1=cbrt(number1);
        if(m==0) {
            number1=number1*10000;
            number1=Double.valueOf(round(number1));
            return number1/10000;        }
        else {
            return number1;
        }
    }
    public static Double masterroot(Double number1,Double number2){

        if(number2<0)
        {
            number2=-(number2);
            number1=pow(number1, number2);

            return number1;
        }
        else {
            number1 = pow(number1, 1 / number2);
            return number1;
        }
    }

    public static Double logy(Double number1,Double number2){

        number1=log10(number1);
        number2=log10(number2);
        number1=number1/number2;
        return number1;
    }

    public static Double log2(Double number1){
        number1=log(number1)/log(2.0);
        return number1;
    }
    public static Integer randome(Double number1,Double number2){
        Random r = new Random();
        int Low = number1.intValue();
        int High = number2.intValue();
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    }
    public static Double percentage(Double number1){
        return number1/100;
    }
    public static Double sign(Double number1){
        return (number1*-1);
    }

    public static Double square(Double number){
        return number * number;
    }
}