package Practice;

import java.util.*;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> toReturn = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            String curSearch = searchWord.substring(0, i+1);
            List<String> curMatches = new ArrayList<>();
            int count = 0;
            for(String product: products){

                if(product.startsWith(curSearch)){
                    count++;
                    curMatches.add(product);
                }
                if(count>=3){
                    break;
                }
            }
            toReturn.add(curMatches);
        }
        return toReturn;
    }

    public static void main(String[] args){
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        for(List<String> matches: searchSuggestionsSystem.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},"mouse")){
            for(String match: matches){
                System.out.print(match);
            }
            System.out.println();
        }
    }

}
