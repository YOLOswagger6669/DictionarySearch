 public static SearchResult sequentialSearch(String wordToFind) {
   SearchResult auto=new SearchResult(-1, words.size());
   for(int i=0; i<words.size(); i++) {
     if(words.get(i)==wordToFind) {
       SearchResult find=new SearchResult(i, i-1);
       return find;
     }
   }
   return auto;
 }

 /**
  * Implement a binary search to find wordToFind in the ArrayList words
  * 
  * @param wordToFind - String to find in words
  * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
  */
 public static SearchResult binarySearch(String wordToFind) {
   int max=words.size()-1;
      int min=0;
      int mid;
      int c=0;
      int i=-1;
      while(max>=min) {
        c++;
        mid=(max+min)/2;
        if(words.get(mid)==wordToFind) {
          i=mid;
        }
        else if(words.get(mid).compareTo(wordToFind)<0) {
          min=mid+1;
        }
        else {
          max=mid-1;
        }
      }
      SearchResult find=new SearchResult(c, i);
      return find;
 }

 /**
  * create an ArrayList<String> and populate it from text file
  * 
  * @return an ArrayList<String>
  * @throws FileNotFoundException
  */
 public static ArrayList<String> getWords() throws FileNotFoundException {
  ArrayList<String> result = new ArrayList<String>();
  Scanner input = new Scanner(new File("words.txt"));
  while(input.hasNextLine()) {
   result.add(input.nextLine());
  }
  input.close();
  return result;
 }
}
