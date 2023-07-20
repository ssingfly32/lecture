package ksh;

import java.util.Scanner;

public class ArrayEx2 {
	public static void main(String[] args) {
		int[] coins = {500, 100, 50, 10};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("거스름돈 >>> ");
		int money = sc.nextInt();
		
		for (int coin : coins) {
			System.out.println(coin+ "원 짜리 동전 : " + money/coin + "개");
			money %= coin;
		}
		sc.close();
	}
}
