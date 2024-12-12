package org.study.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1260 {
  static int nodeCount;
  static int edgeCount;
  static int startNode;
  static LinkedList<Integer>[] edge;
  public static void main(String[] args) throws IOException {
    /*
     *
     * 입력 정보
     *
     * 4 5 1  -> 4 : 노드 개수, 5 : 간선 개수, 1 : 시작 노드 번호
     * 1 2
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     *
     * ※ 첫번 째 줄 외의 입력은 모두 간선 정보
     *
     * 결과 정보
     * DFS -> [1, 2, 4, 3]
     * BFS -> [1, 2, 3, 4]
     *
     */

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    nodeCount = Integer.parseInt(stringTokenizer.nextToken());
    edgeCount = Integer.parseInt(stringTokenizer.nextToken());
    startNode = Integer.parseInt(stringTokenizer.nextToken());

    // 노드별 링크드 리스트 생성
    edge = new LinkedList[nodeCount + 1];
    for(int i = 0; i < nodeCount + 1; i++) {
      edge[i] = new LinkedList<>();
    }

    // 그래프 입력 받기
    for(int i = 0; i < edgeCount; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int u = Integer.parseInt(stringTokenizer.nextToken());
      int v = Integer.parseInt(stringTokenizer.nextToken());

      // 양방향일 경우
      edge[u].add(v);
      edge[v].add(u);

      // 단방향 일 경우
      // graph[u].add(v);
    }

    // 문제에서
    // "방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료"
    // 라는 문구가 있기 때문에 graphs 정렬 필요
    for(LinkedList<Integer> list : edge) {
      Collections.sort(list);
    }

    //DFS 시작
//    System.out.println(createDfsList(startNode, new boolean[node + 1], graphs, DFS_result));
//    System.out.println(createBfsList(startNode, new boolean[node + 1], graphs, BFS_result));
    print(createDfsList(startNode, new boolean[nodeCount + 1], edge, new LinkedList<>()));
    print(createBfsList(startNode, new boolean[nodeCount + 1], edge, new LinkedList<>()));


  }

  /**
   *
   * @param statrNode
   * @param visited : 노드 방문 여부
   * @param edge
   * @param resultLists
   * @return
   */
  static LinkedList<Integer> createDfsList(int statrNode, boolean[] visited, LinkedList<Integer>[] edge, LinkedList<Integer> resultLists) {
    visited[statrNode] = true;  // 방문한 노드 처리
    resultLists.add(statrNode);

    for (int integer : edge[statrNode]) {
      if (!visited[integer]) { // 방문하지 않은 정점이라면
        createDfsList(integer, visited, edge, resultLists);// 재귀 함수
      }
    }

    return resultLists;
  }

  /**
   *
   * @param startNode
   * @param visited : 노드 방문 여부
   * @param edge    : 간선
   * @param result  : 결과값
   * @return
   */
  static LinkedList<Integer> createBfsList(int startNode, boolean[] visited, LinkedList<Integer>[] edge, LinkedList<Integer> result) {
    // 큐 생성
    Queue<Integer> queue = new LinkedList<>();

    visited[startNode] = true;
    queue.add(startNode);

    while(!queue.isEmpty()) {
      int pollNode = queue.poll();
      result.add(pollNode);

      for (int node : edge[pollNode]) {
        //방문 하지 않은 노드면 방문한것으로 표시하고 큐 푸시
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }

    return result;
  }

  static void print(LinkedList<Integer> list) {
    for(int element : list) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
