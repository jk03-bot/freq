import java.io.*;
import java.util.*;
class Freq
{
    public static void main(String args[])
    {
        char[] freqlett={'e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q'};
        Scanner in=new Scanner(System.in);
        System.out.print("Enter cipher text:");
        String ci=in.nextLine();
        String de="";
        int shift,bestsh;
        boolean meaning=false;
        for(char letter:freqlett)
        {
            shift=(letter -'e'+26)%26;
            de=decrypt(ci,shift);
            if(isMeaning(de))
            {
                bestsh=shift;
                meaning=true;
                break;
            }
            else
            {
                System.out.println(de);
                System.out.println(shift);
                System.out.println("is this the meaningful text?");
                String o=in.nextLine();
                if(o.equals("yes"))
                {
                    bestsh=shift;
                    meaning=true;
                    break;
                }
            }
        }
        if(meaning)
    {
        System.out.println(de);
    }

    }
    
    private static String decrypt(String text,int shift)
    {
        StringBuilder dec=new StringBuilder();
        for(int i=0;i<text.length();i++)
        {
            char ch=text.charAt(i);
            char det=ch;
            if(Character.isUpperCase(ch))
            {
                det=(char)('A'+(ch-'A'-shift+26)%26);
            }
            if(Character.isLowerCase(ch))
            {
                det=(char)('a'+(ch-'a'-shift+26)%26);
            }
            dec.append(det);

        }
        return dec.toString();
    } 
    private static boolean isMeaning(String tex)
    {
        return tex.toLowerCase().contains("the");
    }
}