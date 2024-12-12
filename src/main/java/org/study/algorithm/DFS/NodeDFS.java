package org.study.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NodeDFS {
  static int node;
  static int edge;
  static int startNode;
  static LinkedList<Integer>[] graphs;
  static boolean[] visited;
  static LinkedList<Integer> DFS_result;
  static LinkedList<Integer> BFS_result;
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
     *
     */

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    node = Integer.parseInt(stringTokenizer.nextToken());
    edge = Integer.parseInt(stringTokenizer.nextToken());
    startNode = Integer.parseInt(stringTokenizer.nextToken());

    // 노드별 링크드 리스트 생성
    graphs = new LinkedList[node + 1];
    for(int i = 0; i < node + 1; i++) {
      graphs[i] = new LinkedList<>();
    }

    // 방문여부 판단 배열 생성
    visited = new boolean[node + 1];

    // DFS 결과값 링크드 리스트 생성
    DFS_result = new LinkedList<>();
    BFS_result = new LinkedList<>();

    // 그래프 입력 받기
    for(int i = 0; i < edge; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int u = Integer.parseInt(stringTokenizer.nextToken());
      int v = Integer.parseInt(stringTokenizer.nextToken());

      // 양방향일 경우
      graphs[u].add(v);
      graphs[v].add(u);

      // 단방향 일 경우
      // graph[u].add(v);
    }

    // 문제에서
    // "방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료"
    // 라는 문구가 있기 때문에 graphs 정렬 필요
    for(LinkedList<Integer> list : graphs) {
      Collections.sort(list);
    }

    //DFS 시작
    System.out.println(createDfs(startNode, visited, graphs, DFS_result));
  }

  static LinkedList<Integer> createDfs(int statrNode, boolean[] visited, LinkedList<Integer>[] graphs, LinkedList<Integer> resultLists) {
    visited[statrNode] = true;  // 방문한 노드 처리
    resultLists.add(statrNode);

    for (int node : graphs[statrNode]) {
      if (!visited[node]) { // 방문하지 않은 정점이라면
        createDfs(node, visited, graphs, resultLists);// 다시 DFS
      }
    }

    return resultLists;
  }
}
