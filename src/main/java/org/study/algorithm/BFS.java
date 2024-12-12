package org.study.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
  static int node;
  static int edgeCount;
  static int startNode;
  static LinkedList<Integer>[] edge;
  static LinkedList<Integer> resultList;

  // 방문 여부 판단 배열
  static boolean[] visited;

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
     * BFS -> [1, 2, 3, 4]
     *
     */

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    node = Integer.parseInt(stringTokenizer.nextToken());
    edgeCount = Integer.parseInt(stringTokenizer.nextToken());
    startNode = Integer.parseInt(stringTokenizer.nextToken());

    // 간선 생성
    edge = new LinkedList[node + 1];
    for(int i = 0; i < node + 1; i++) {
      edge[i] = new LinkedList<>();
    }

    resultList = new LinkedList<>();

    visited = new boolean[node + 1];

    for(int i = 0; i < edgeCount; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int u = Integer.parseInt(stringTokenizer.nextToken());
      int v = Integer.parseInt(stringTokenizer.nextToken());

      // 양방향일 경우
      edge[u].add(v);
      edge[v].add(u);

      // 단방향 일 경우
      // edge[u].add(v);
    }

    // 문제에 작은 순서부터 방문하라는 이야기가 있음
    for(LinkedList<Integer> list : edge) {
      Collections.sort(list);
    }

    System.out.println(createBFS(startNode, visited, edge, resultList));
  }

  static LinkedList<Integer> createBFS(int startNode, boolean[] visited, LinkedList<Integer>[] edge, LinkedList<Integer> result) {
    // 큐 생성
    Queue<Integer> queue = new LinkedList<>();

    visited[startNode] = true;
    queue.add(startNode);

    while(!queue.isEmpty()) {
      startNode = queue.poll();
      result.add(startNode);

      for (int node : edge[startNode]) {
        //방문 하지 않은 노드면 방문한것으로 표시하고 큐 푸시
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }

    return result;
  }
}
