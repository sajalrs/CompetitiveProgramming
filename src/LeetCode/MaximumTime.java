package LeetCode;

public class MaximumTime {
    public static String maximumTime(String time) {
        boolean[] isHidden = new boolean[]{time.charAt(0) == '?', time.charAt(1) == '?', true, time.charAt(3) == '?', time.charAt(4) == '?'};
        StringBuilder latest = new StringBuilder(time);
        for(int i = 0; i< 5; i++){
            if(isHidden[i] && i!=2){
               latest.setCharAt(i, '9');
            }
        }


        while(true){
                int i =5;
                if(!isHidden[i]){
                    continue;
                }

                for(int j = 9; j>0; j--){
                    latest.setCharAt(i, Character.forDigit(j, 10));
                    if(isValidTime(latest.toString())){
                        return latest.toString();
                    }
                }
            }
//
//        boolean movingLeft = true;
//        int i = time.length()-1;
//        while(!isValidTime(latest.toString())){
//            if(!isHidden[i]){
//                if(movingLeft && i>0){
//                    i--;
//                }else if(i<time.length()-1){
//                    i++;
//                }
//            }
//
//            int num = Character.valueOf(time.charAt(i));
//            for(int j = num; j>0; j--){
//                latest.setCharAt(i, Character.forDigit(j, 10));
//                if(isValidTime(latest.toString())){
//                    break;
//                }
//            }
//            movingLeft = true;
//        }
    }

    public static boolean isValidTime(String time){
        String[] hourMinutes = time.split(":");
        int hour = Integer.parseInt(hourMinutes[0]);
        int minutes = Integer.parseInt(hourMinutes[1]);
        return (hour >=0 && hour<=23) && (minutes >=0 && minutes<= 59);
    }

}
