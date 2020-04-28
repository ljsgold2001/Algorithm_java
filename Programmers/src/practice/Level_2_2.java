package practice;

/*
 * 프로그래머스 Level 2
 * https://programmers.co.kr/skill_checks/123820
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 * 제한 조건
 * - 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * - 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * - 곱할 수 있는 배열만 주어집니다.
 */

public class Level_2_2 {
	
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<arr1.length; i++) { // i는 arr1의 행
            for(int j=0; j<arr1[0].length; j++) { // j는 arr1의 열이자 arr2의 행 
                for(int k=0; k<arr2[0].length; k++) { // k는 arr2의 열
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }     
        return answer;
    }
	
}
