class Solution {
    public int canBeTypedWords(String s, String b) {
        String[] words = s.split(" ");
        int count = 0;
        for(String a : words){
            count += isBroken(b, a);
        }
        return count;
    }
    public static int isBroken( String b, String a){
        for(int i = 0; i<b.length(); i++){
            if(a.contains(b.charAt(i) + "")) return 0;
        }
        return 1;
    }
}
