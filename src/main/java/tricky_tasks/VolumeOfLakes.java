package tricky_tasks;

import java.util.*;

//https://techdevguide.withgoogle.com/resources/former-interview-question-volume-of-lakes/#!

public class VolumeOfLakes {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2};
        System.out.println(calcSimple(arr));
    }

    // TODO: 2/28/2021  
    public static int calcSimple(int[]arr){
        int volume = 0;
        int highest_point;
        int volLeftToRight[] = new int[arr.length];
        int volRightToLeft[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            highest_point = arr[i];
            if (i + 1 < arr.length && arr[i + 1] < highest_point){
                while (i + 1 < arr.length && arr[i + 1] < highest_point){
                    volLeftToRight[i] += (highest_point - arr[i + 1]);
                    i++;
                }
            }
        }
        volume = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            highest_point = arr[j];
            if (j - 1 > 0 && arr[j - 1] < highest_point){
                while (j - 1 > 0 && arr[j - 1] < highest_point){
                    volRightToLeft[j] += (highest_point - arr[j - 1]);
                    j--;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (volLeftToRight[i] < volRightToLeft[i])
                volume += volLeftToRight[i];
            else
                volume += volRightToLeft[i];
        }
        return volume;
    }

    public static int calcHard(int[]arr){
        Map<Integer,Boolean> lowestPoints = new HashMap<>();
        int highest_point;
        for (int i = 0; i < arr.length; i++) {
            highest_point = arr[i];
            if (i + 1 < arr.length && arr[i + 1] < highest_point){
                int lowest_point = arr[i+1];
                while (true){
                    if (i + 1 == arr.length){
                        lowestPoints.put(i,true);
                        break;
                    }
                    if (arr[i+1] >= highest_point){
                        int j = i;
                        while(arr[j] < highest_point){
                            lowestPoints.put(j,false);
                            j--;
                        }
                        break;
                    }
                    if (arr[i+1] > lowest_point && arr[i+1] < highest_point){
                        lowest_point = arr[i+1];
                        lowestPoints.put(i+1,true);
                        lowestPoints.put(i,false);
                    }
                    i++;
                }
            }
        }
        int volume = 0;

        for (int i = 0; i < arr.length; i++) {
            highest_point = arr[i];
            if (i + 1 < arr.length && arr[i + 1] < highest_point){
                while (i + 1 < arr.length && arr[i + 1] < highest_point){
                    if (lowestPoints.containsKey(i + 1) && lowestPoints.get(i + 1) == true){
                        int j = i;
                        int lowest_point = arr[i+1];
                        while(arr[j] < highest_point){
                            volume = volume - (highest_point - lowest_point);
                            j--;
                        }
                        break;
                    }
                    volume += (highest_point - arr[i + 1]);
                    i++;
                }
            }
        }
        return volume;
    }
}
