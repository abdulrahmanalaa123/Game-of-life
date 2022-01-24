/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import java.lang.Math;
import java.util.Scanner;

public class Life {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = 1;
		Grid Life = new Grid();
		Life.random_state(10,5);
		while(k == 1)
		{
			Life.board_state();
			Life.next_state();
			System.out.print("if you want to continue enter 1 if not enter 0");
			k = s.nextInt();
		}
		

	}

}
