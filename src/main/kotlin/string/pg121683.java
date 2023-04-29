package src.main.kotlin.string;

public class pg121683 {
    public String solution(String input_string) {
        String answer = "";
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int[] cnt = new int[26];
        int[] continueCnt = new int[26];

        char pre = 'a';
        for(int i = 0; i < input_string.length(); i++){

            char ch = input_string.charAt(i);
            cnt[ch-'a']++;

            if(i == 0){
                pre = ch;
                continue;
            }

            if(pre != ch){
                continueCnt[pre-'a']++;
                pre = ch;

            }

            if( i == input_string.length()-1 ){
                continueCnt[ch-'a']++;
            }

        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < 26; i++){
            if(cnt[i] >= 2 && continueCnt[i] >= 2){
                sb.append(alpha[i]);
                flag = true;
            }
        }
        if (!flag){
            answer = "N";
        }else{
            answer = sb.toString();
        }

        return answer;
    }
}
