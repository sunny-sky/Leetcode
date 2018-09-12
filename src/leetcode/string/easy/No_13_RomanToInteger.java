package leetcode.string.easy;

public class No_13_RomanToInteger {
    public static int romanToInt(String s) {
        int len = s.length(),res = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'M') {
                res += 1000;
            }
            else if (s.charAt(i) == 'D') {
                res += 500;
            }
            else if (s.charAt(i) == 'C') {
                if (i == len - 1)
                    res += 100;
                else if (s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D')
                    res -= 100;
                else
                    res += 100;
            }
            else if (s.charAt(i) == 'L') {
                res += 50;
            }
            else if (s.charAt(i) == 'X') {
                if (i == len - 1)
                    res += 10;
                else if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')
                    res -= 10;
                else
                    res += 10;
            }
            else if (s.charAt(i) == 'V') {
                res += 5;
            }
            else if (s.charAt(i) == 'I') {
                if (i == len - 1)
                    res += 1;
                else if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')
                    res -= 1;
                else
                    res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int res = romanToInt(s);
        System.out.println(res);
    }
    public static int romanToInt2(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;

        }

        return sum;

    }
}
