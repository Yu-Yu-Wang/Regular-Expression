import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RegExp {
    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);
        //For your testing of input correctness

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                //You main code should be invoked here
                String[] ans = new String[4];
                Arrays.fill(ans, "Y");//全部都先假設為真
                //ans[1]
                String lineLowercase = line.toLowerCase();
                //public static void Answer1(String Line, String str1){
                    boolean containsstr1 = lineLowercase.contains(str1);
                    if(containsstr1!=true){
                        ans[1] = "N";
                    }
                //}
                //ans[2]
                
                int index = 0;
                int count1 = 0;
                while((index = lineLowercase.indexOf(str2, index)) != -1){
                    count1++;
                    index += str2.length();
                }
                if(count1<s2Count){
                    ans[2] = "N";
                }
                //ans[0]
                int Length = lineLowercase.length();
                char[] charArray = lineLowercase.toCharArray();
                if(Length%2==1){
                    int length_right1 = Length/2+1;
                    int length_left1 = Length/2-1;
                    for(int count2=0;count2<Length/2;count2++){
                        if(charArray[length_left1] == charArray[length_right1]){
                            length_left1 --;
                            length_right1 ++;
                        }
                        else{
                            ans[0] = "N";
                            break;
                        }
                    }
                }
                else if(Length%2==0){
                    int length_right2 = Length/2;
                    int length_left2 = Length/2-1;
                    for(int count2=0;count2<Length/2;count2++){
                        if(charArray[length_left2] == charArray[length_right2]){
                            length_left2 --;
                            length_right2 ++;
                        }
                        else{
                            ans[0] = "N";
                            break;
                        }
                    }
                }
                //ans[3]
                int Aappear = 0;
                int Atimes = 0;
                while( Aappear<line.length() && (String.valueOf(charArray[Aappear]).equals("a"))){
                    Atimes++;
                    if(Aappear + 1 < charArray.length){
                        if(!String.valueOf(charArray[Aappear+1]).equals(String.valueOf(charArray[Aappear]))){
                            break;
                        }
                    }
                    Aappear += 1;
                }
                int Bappear = line.length()-1;
                int Btimes = 0;
                while(Bappear > 0 && (String.valueOf(charArray[Bappear]).equals("b"))){
                    Btimes++;
                    if(!String.valueOf(charArray[Bappear]).equals(String.valueOf(charArray[Bappear - 1]))){
                        break;
                    }
                    Bappear -= 1;
                }
                /*int Aappear = 0;
                int Atimes = 0;
                while(Aappear<line.length()){
                    if((String.valueOf(charArray[Aappear]).equals("a"))){
                        Atimes++;
                        break;
                    }
                    if(Aappear < charArray.length - 1){
                        if(!String.valueOf(charArray[Aappear+1]).equals(String.valueOf(charArray[Aappear]))){
                            break;
                        }
                    }
                    Aappear += 1;
                }
                int Bappear = line.length()-1;
                int Btimes = 0;
                while(Bappear > 0){
                    if((String.valueOf(charArray[Bappear]).equals("b"))){
                        Btimes++;
                        if(Btimes==2){
                            break;
                        }
                        if(!String.valueOf(charArray[Bappear]).equals(String.valueOf(charArray[Bappear - 1]))){
                            Btimes = 0;
                        }
                        Bappear -= 1;
                    }
                }*/
                if(Atimes==0||Btimes==0||Btimes==1){
                        ans[3]="N";
                }
                //System.out.println(line);
                for(int x=0;x<4;x++){
                    System.out.printf(ans[x]);
                    if(x!=3){
                        System.out.printf(", ");
                    }
                }
                System.out.println();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}