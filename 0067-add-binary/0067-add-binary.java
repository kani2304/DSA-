class Solution {
    public String addBinary(String a, String b) {
       StringBuilder sb=new StringBuilder();
        int len1=a.length()-1,len2=b.length()-1;
        char carry='0';
        while(len1>=0||len2>=0){
            char a1=len1>=0?a.charAt(len1--):'0';
            char b1=len2>=0?b.charAt(len2--):'0';
            int one=0;
            if(a1=='1')one++;
            if(b1=='1')one++;
            if(carry=='1')one++;
            sb.append(one%2==1?'1':'0');
            carry=(one>=2?'1':'0');
        }
        if(carry=='1')sb.append('1');
        return sb.reverse().toString();
    }
}