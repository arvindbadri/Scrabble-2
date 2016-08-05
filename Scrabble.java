import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import java.util.ArrayList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Scrabble {
		
		public static void main(String[] args) {
			String S;
			int noOfTestCases;
			Scanner sc = new Scanner(System.in);
			noOfTestCases = sc.nextInt();
			for(int i = 1; i <= noOfTestCases; i++) {
				String s=sc.next();
				Rack r=new Rack(s);
				System.out.println(r.getMaxScore());
		}
	}
}