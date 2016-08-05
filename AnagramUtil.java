import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramUtil {

	public static void main(String[] args) {
		
		Map<String,String> anagram=getMapOfWords();
	}
		
	private static ArrayList<String> getBlankSpaceReplacements(int num) 
	// fill the empty spaces => _ _ => 'aa'
	{
		ArrayList<string> replacements;
		String replacement;
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		for ( int octr = 0; ctr < alphabet.length() ; octr++ ) {
			for ( int ictr = 0 ; ictr < alphabet.length() ; ictr++ ) {
				replacement = alphabet[octr] + alphabet[ictr];
				for ( int list_index = 0 ; list_index < replacements.size() ; list_index++ ) {
					if ( replacements[list_index] != replacement ) {
						replacements.add(replacement);
					}
				}
			}
		}
	}

	private static ArrayList<String> makeScrabbleWords(ArrayList<String> replacements, String curtailed_string) {
		String helper_string;
		ArrayList<String> scrabble_words;
		for ( int ctr = 0 ; ctr < replacements.size() ; ctr++ ) {
			helper_string = replacements.get(ctr);
			helper_string += curtailed_string;
			scrabble_words.add(helper_string)
		}
		return scrabble_words;
	}

	private static String curtailed_input(String input) {
		String curtailed_string = input.replace("_","")
		return curtailed_string;
	}


	public static Map<String,Boolean> getMapOfWords(){
		 Map<String,Boolean> words_map = new HashMap<String,Boolean>();
			
			try {
				FileInputStream fstream = new FileInputStream("sowpods.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;
				while ((strLine = br.readLine()) != null)   {
				 	String sorted=sortLetters(strLine);
				    words_count.put(sorted,True);

				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return words_count;
		
	}

	public static void makeCombinationsAndCheck(HashMap<String,ArrayList<Integer>> hash, String inputstring,int[] scores, ArrayList<String> words) {
		StringBuilder output = new StringBuilder();
		combine(hash,inputstring,output,scores,words);
	}
	
	public static void combine(HashMap<String,ArrayList<Integer>> hash, String inputstring,StringBuilder output,int[] scores, ArrayList<String> words) { 
		combine(hash,inputstring,output,0,scores, words); 
	}
	
    private static void combine(HashMap<String,ArrayList<Integer>> hash,String inputstring,StringBuilder output,int start ,int[] scores,ArrayList<String> words){
    	
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            String oStr = output.toString();
            char[] oArr = oStr.toCharArray();
            Arrays.sort(oArr);
            String temp = String.copyValueOf(oArr);
            if(hash.containsKey(temp))
            	if(calcScore(oStr,scores) > maxScore) {
            		maxScore = calcScore(oStr,scores);
            		maxWord = words.get(hash.get(temp).get(0));
            	}
            	
            if ( i < inputstring.length() )
            combine(hash,inputstring,output,i + 1,scores,words);
            output.setLength( output.length() - 1 );
        }
    }


	private static String sortLetters(String strLine) {
		// TODO Auto-generated method stub
		char[] chars = strLine.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars).toLowerCase();
		return sorted;
	}
}