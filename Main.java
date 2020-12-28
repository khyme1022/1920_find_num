import java.io.*;
import java.util.*;

class Main {
  public static int[] arrN;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    arrN = new int[N];
    for(int i=0;i<N;i++){
      arrN[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arrN);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    int[] arrM = new int[M];
    for(int i=0;i<M;i++){
      arrM[i] = Integer.parseInt(st.nextToken());
      sb.append(find(arrM[i],N-1)).append("\n");
    }
    System.out.print(sb);

  }

  public static int find(int M,int num){
    int left=0;
    int right =num;
    while(true){
      int mid = (left+right)/2;
      if(arrN[mid]==M||arrN[left]==M||arrN[right]==M)
        return 1;
      else {
        if(arrN[mid]>M){
          right = mid -1;
        }
        else{
          left = mid + 1;
        }
        if(left==mid||right==mid)
          return 0;
      }
    }
  }
}