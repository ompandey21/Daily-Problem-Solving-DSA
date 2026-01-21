import java.util.*;
class Sol {
    public List<String> removeAnagrams(String[] words) {


        List<String> li = new ArrayList<>();
        String prev = "";
  
        for(String s : words){
            String hs = s;
            if(prev.equals(hs)){ 
                continue;
            }
            else{
                prev = hs;
                li.add(s);
            }

        }
        return li;
    }
   
}
