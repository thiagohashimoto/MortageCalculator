package com.atekengenharia;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12; //Somente para questão organizacional, saber de onde está vindo o valor 12
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1K - $1M): ");
        int principal = scanner.nextInt();

        while (principal < 1000 || principal > 1000000) {
            System.out.println("Enter a number between 1.000 and 1.000.000,00");
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        while (annualInterest <= 0 || annualInterest > 30) {
            System.out.println("Enter a value greater than 0 and less or equal to 30.");
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Porcentagem: " + monthlyInterest);

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

        while (years <= 0 || years > 30){

            System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
        }

        int numbersOfPayment = years * MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayment)) / (Math.pow(1 + monthlyInterest,numbersOfPayment)) - 1;
        NumberFormat currencyMortgage = NumberFormat.getCurrencyInstance();
        String currency = currencyMortgage.format(mortgage);

        System.out.println("Mortgage: " + currency);







    }

}
