import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsomorphicWords {
	
	
      public int countPairs(String[] words) {
         // fill in code here
    	 int totalcounter=0;
    	 int increment =0;
    	 Set<HashMap<Character, Set<Integer>>> MEGASET = new HashSet<>(); //every word will have one element in this ridiculous HashMap
    	 
    	  
    	  for (int i=0; i<words.length; i++){//iterates through every word
        	  //declare a HashMap with Key = char and Value = sets (of positions of said char)
        	  HashMap<Character, Set<Integer>> charpositions = new HashMap<Character, Set<Integer>>(); //this will hash the characters to their positions for the word
        	  for (int j=0; j<words[i].length(); j++){
        		  //iterates through each character
        		  Integer jInt = new Integer(j); //cast the current position as an Integer
    			  Character ch = new Character(words[i].charAt(j)); //casts the current char as Character

        		  if (charpositions.get(ch)!=null){
        			  //if the Character in position j is already in the hashmap as a key...
        			  (charpositions.get(ch)).add(jInt); //add the current position to the set for the key that already exists	  
        		  }
        		  else{
        			  Set<Integer> values = new HashSet<>(); //create a new set
        			  charpositions.put(ch, values); //creates an entry with the <Character, Set>
        			  //now we need to add the first position to  the values set
        			  charpositions.get(ch).add(jInt); 
        		  }
        	
        	  }
        	  
    		  MEGASET.add(charpositions); //stick charpositions in the megaset... charpositions is defined for each word
    	  }
        	  //now the hashmap is filled with sets of all positions for each character
        	  //we want ot iterate through all of hte words and see how many have 
        	  
        	  for (HashMap<Character,Set<Integer>> temp : MEGASET) {
        		  //we now are examining one of the hashmaps, temp. we want to compare this hashmap to other hashmaps, so we nest...
        	  
        		  for (HashMap<Character,Set<Integer>> temp2 : MEGASET){
        			  //we now have two hashmaps, temp and temp2. We want to see if temp2 contains all the values that temp contains...
        			  //want to iterate through VALUES of the first hashset and 
        			  
        			  for (Set<Integer> value : temp.values()) {
        				    // iterates through all the Sets in the HashMap temp
        				  if (temp2.containsValue(value)){
        					  increment = 1;
        					     					  
        				  }
        				  else{
        					  increment=0;
        					  break; 
        					  
        				  }
        				  		//after we go through every value in the hash set, we add increment to the total
        						  
        				  
        				  
        				} // at this point ,we've either broken or gone through every value in the first HashMap
        			  
        			  totalcounter = totalcounter + increment; //should change nothing if we broke out after finding that one set was not contained in the other hashmap...
        			    
        		  }
        		  
        		  totalcounter = totalcounter - 1; //extract the match with itself

        	  }

    	  return totalcounter/2; //it SHOULD be doublecounted at this point
  
      }

      
   }