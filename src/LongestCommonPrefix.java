public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        //Using StringBuilder to reduce the memory
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++){
            if(sb.length()==0) return "";
            int a = 0, b = 0;
            while(a < sb.length() && b < strs[i].length()){
                if(sb.charAt(a) != strs[i].charAt(b)){
                    sb = new StringBuilder(sb.substring(0, a));
                    break;
                }
                a++;
                b++;
            }
            //Once the strs[i] is smaller than sb, we need to do this step to ensure the sb will be the shorter one
            sb = new StringBuilder(sb.substring(0,Math.min(sb.length(),strs[i].length())));
        }
        return sb.toString();
    }
}
