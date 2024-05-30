public class Main {
    public static int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0; i<jewels.length(); i++){
            for(int j=0; j<stones.length(); j++){
                if(jewels.charAt(i) == stones.charAt(j)) count++;
            }
        }
        return count;
    }

    public static int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])count++;
            }
        }
        return count;
    }

    public static int maxNumberOfBalloons(String text) {
        int count = 0;
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (char c: text.toCharArray()){
            switch (c){
                case 'b' -> a++;
                case 'a' -> b++;
                case 'l' -> l++;
                case 'o' -> o++;
                case 'n' -> n++;
            }
            if (b >= 1 && a >= 1 && n >= 1 && l >= 2 && o >= 2){
                count++;
                b -= 1; a -= 1; n -= 1; l -= 2; o -= 2;
            }
        }
        return count;
    }
}
