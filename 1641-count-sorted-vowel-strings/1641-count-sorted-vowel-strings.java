class Solution {
    
    private String vowels="aeiou";
    private int count=0;
    
    private void countVowelStrings(StringBuilder sb, int index, int n){
        if(sb.length()==n) {
            ++count;
            return;
        }
        for(int i=index;i<vowels.length();++i){
            sb.append(vowels.charAt(i));
            countVowelStrings(sb, i, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public int countVowelStrings(int n) {
        countVowelStrings(new StringBuilder(""), 0, n);
        return this.count;
    }
}