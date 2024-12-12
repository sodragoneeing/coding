package org.study.softeer.level_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CommuteToWork {
  /*
   *
   * 문제 출처 : Softeer
   * 문제 이름 : 출퇴근길
   * 추가 문제 설명 : HSAT 6회 정기 코딩 인증평가 기출
   *
   * 입력 예제
   * 5 9
   * 1 2
   * 1 4
   * 2 1
   * 2 3
   * 3 4
   * 3 5
   * 4 1
   * 4 3
   * 5 1
   * 1 3
   *
   * 출력 예제
   * 1
   *
   *********************************
   *
   * 입력 예제
   * 8 14
   * 1 2
   * 1 5
   * 1 7
   * 2 3
   * 3 1
   * 4 1
   * 4 2
   * 5 4
   * 5 8
   * 6 2
   * 6 3
   * 7 1
   * 7 6
   * 8 7
   * 6 5
   *
   * 출력 예제
   * 4
   */

  static int nodeCount;
  static int edgeCount;
  static int startNode;
  static int endNode;

  static List<List<Integer>> graphs;
  static List<List<Integer>> reverseGraphs;

  public static void main(String[] args) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    
    // 노드 및 간선 개수 입력
    nodeCount = Integer.parseInt(stringTokenizer.nextToken());
    edgeCount = Integer.parseInt(stringTokenizer.nextToken());
    
    // 정방향 역방향 그래프 초기화
    graphs = new ArrayList<>();
    reverseGraphs = new ArrayList<>();
    for (int i = 0; i <= nodeCount; i++) {
      graphs.add(new ArrayList<>());
      reverseGraphs.add(new ArrayList<>());
    }

    // 간선 정보 입력
    for (int i = 0; i < edgeCount; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int u = Integer.parseInt(stringTokenizer.nextToken());
      int v = Integer.parseInt(stringTokenizer.nextToken());
      graphs.get(u).add(v);
      reverseGraphs.get(v).add(u);
    }

    // 시작점 종점 입력
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    startNode = Integer.parseInt(stringTokenizer.nextToken());
    endNode = Integer.parseInt(stringTokenizer.nextToken());

    Set<Integer> startReachableNode = new HashSet<>();
    Set<Integer> reverseStartReachableNode = new HashSet<>();

    // 시작 노드에서 도달할 수 있는 중간 정점들
    dfs(startNode, endNode, graphs, startReachableNode, new boolean[nodeCount + 1]);
    // 역방향 간선에 대해서 마지막 노드에 도달할 수 있는 정점
    dfs(endNode, -1, reverseGraphs, reverseStartReachableNode, new boolean[nodeCount + 1]);
    startReachableNode.retainAll(reverseStartReachableNode); //교집합

    Set<Integer> endReachableNode = new HashSet<>();
    Set<Integer> reverseEndReachableNode = new HashSet<>();

    // 마지막 노드에서 도달 할 수 있는 중간 정점들
    dfs(endNode, startNode, graphs, endReachableNode, new boolean[nodeCount + 1]);
    // 역방향 간선에 대해서 시작 노드에 도달 할 수 있는 정점
    dfs(startNode, -1, reverseGraphs, reverseEndReachableNode, new boolean[nodeCount + 1]);
    endReachableNode.retainAll(reverseEndReachableNode);  // 교집합

    startReachableNode.retainAll(endReachableNode);

    int redundantNodeCount = startReachableNode.size();

    if (startReachableNode.contains(startNode))
      redundantNodeCount--;
    if (startReachableNode.contains(endNode))
      redundantNodeCount--;

    System.out.println(redundantNodeCount);
  }

  public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set,
      boolean[] visited) {
    if (stop != -1 && node == stop) {
      return;
    }

    for (int i = 0; i < graph.get(node).size(); i++) {
      int next = graph.get(node).get(i);

      if (visited[next]) {
        continue;
      }

      visited[node] = true;
      set.add(next);
      dfs(next, stop, graph, set, visited);
    }
  }
}