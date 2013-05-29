import java.util.Stack;


public class LabD {

   public static void main(String args[]) {
      
     System.out.println("STACK book check");
     Stack<String> bs = new Stack<String>();
     bs.push("jim");
     bs.push("jess");
     bs.pop();
     bs.push("jill");
     bs.push("jane");
     bs.pop();
     while(!bs.isEmpty())
        System.out.println(bs.pop());
     
     System.out.println("TESTING PALINDROME + STACKS");
     //create an array of words that contains some palindromes 
     String[] words = { "civic", "a", "hello", "mom", "dood", 
                        "test", "tea", "leaf", "animals" };
     
     //check which words are palindromes + print results 
     for(int i = 0; i < words.length; i++) {
        
        System.out.print("word is: " + words[i]);
        System.out.println(" --> is it a palindrome? " + isPalindrome(words[i]));
     }
   }
   
   /**Method that checks if word is a palindrome by pushing half of the word into a stack
    *        then checking the other half of the word against the contents of the stack.
    * @param word is a String that needs to be checked.
    * @return true if word is a palindrome. 
    */
   private static boolean isPalindrome(String word)
   {
      //if word is one character return true
      if(word.length() == 1)
         return true;
      //create a stack to store letters
      Stack<String> stack = new Stack<String>();
      //get half of the word's length 
      int halfWord = (word.length()/2);
      //use counter to push 1/2 the word
      int counter = 0;
      //push letters into stack
      while(counter <= halfWord-1) {
         
         stack.push(word.substring(counter, counter+1));
         counter++;
      }
      
      //check if word contains odd number of letters
      if(word.length()%2 != 0)
         halfWord = halfWord+1;
      
      //check if word is a palindrome 
      while(halfWord < word.length()) {

         if(stack.pop().equals(word.substring(halfWord, halfWord+1)))
            halfWord++;
         else 
            return false;

      }
      
      return true;
   }
}
