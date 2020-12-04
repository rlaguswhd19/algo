package programmers.정렬;


import java.util.Arrays;

public class level1_k번째수 {
	static int[] array = {1,5,2,6,3,7,4};
	static int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
	static int[] result;
	
	public static void main(String[] args) {
		int cnt = 0;
		result = new int[commands.length];
		int[] ans = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            int index = 0;
            for(int j = commands[i][0]-1; j<commands[i][1]; j++){
                temp[index++] = array[j];
            }
            Arrays.sort(temp);
            result[cnt++] = temp[commands[i][2]-1];
        }
        System.out.println(Arrays.toString(result));
	}
}
