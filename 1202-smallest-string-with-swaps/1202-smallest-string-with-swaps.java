class Edge{
    int src, dest;
    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
}

class Char{
    List<Integer> index;
    List<Character> character; 
}

class Solution {
    
    private List<Edge> initGraph(List<List<Integer>> pairs){
        List<Edge> graph = new ArrayList<>();
        for(int i=0;i<pairs.size();++i){
            List<Integer> pair = pairs.get(i);
            graph.add(new Edge(pair.get(0), pair.get(1)));
        }
        return graph;
    }
    
    private int find(List<Integer> parent, int x){
        if(parent.get(x) != x){
            parent.set(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }
    
    private void union(List<Integer> parent, int x, int y){
        parent.set(x, y);
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<Edge> graph = initGraph(pairs);
        List<Integer> parent = new ArrayList<>();
        for(int i=0;i<s.length();++i){
            parent.add(-1);
        }
        for(Edge edge : graph){
            parent.set(edge.src, edge.src);
            parent.set(edge.dest, edge.dest);
        }
        for(Edge edge : graph){
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if(x != y){
                union(parent, x, y);
            }
        }
        Map<Integer, Char> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            if(parent.get(i) == -1)
                continue;
            int p = find(parent, parent.get(i));
            if(map.containsKey(p)){
                Char charList = map.get(p);
                charList.index.add(i);
                charList.character.add(s.charAt(i));
                map.put(p, charList);
            }else{
                Char charList = new Char();
                charList.index = new ArrayList<>();
                charList.character = new ArrayList<>();
                charList.index.add(i);
                charList.character.add(s.charAt(i));
                map.put(p, charList);
            }
        }
        StringBuffer sb = new StringBuffer(s);
        for(Char charList : map.values()){
            Collections.sort(charList.character);
            for(int i=0;i<charList.index.size();++i){
                sb.setCharAt(charList.index.get(i), charList.character.get(i));
            }
        }
        return sb.toString();
    }
}