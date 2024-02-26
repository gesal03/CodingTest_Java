import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();

    private int sum = 0;

    private int [] myArr;


    int binarySearch(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(key == myArr[mid]) { // 탐색 성공
                return mid;
            } else if(key < myArr[mid]) {
                // 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
                return binarySearch(key ,low, mid-1);
            } else {
                // 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색
                return binarySearch(key, mid+1, high);
            }
        }

        return -1; // 탐색 실패
    }
    public  void run() throws Exception {
        int n = Integer.parseInt(br.readLine());
        myArr = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            myArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(myArr);
        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            if(binarySearch(Integer.parseInt(st.nextToken()),0,n-1) == -1) sb.append("0 ");
            else sb.append("1 ");
        }

        System.out.println(sb);






    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}