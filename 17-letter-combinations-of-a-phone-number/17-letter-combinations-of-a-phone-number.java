class Solution {
    
    private Map<Character, String> map;
    private List<String> list = new ArrayList<>();
    
    private void initMap(){
        this.map = new HashMap<>();
        map.put('1',"");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    private void letterCombinations(String digits, StringBuilder sb, int index, int n){
        if(index==n){
            this.list.add(sb.toString());
            return;
        }
        String word=map.get(digits.charAt(index));
        for(int i=0;i<word.length();++i){
            sb.append(word.charAt(i));
            letterCombinations(digits, sb, index+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        if(n==0) return this.list;
        initMap();
        StringBuilder sb=new StringBuilder("");
        letterCombinations(digits, sb, 0, n);
        return this.list;
    }
}