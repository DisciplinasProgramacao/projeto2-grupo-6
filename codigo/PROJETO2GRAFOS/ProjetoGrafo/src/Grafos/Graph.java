package Grafos;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int[][] adjacencyMatrix;
	
	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	
	public void addUnidirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;		
	}
	
	//Checar ordem e tamanho do grafo
	public void SizeGraph () {
	
			
		int ordem = 0; // numero de vertices
		int tamanho = 0; // numero de arestas 
		
		for(int i  = 0; i< nodeList.size(); i++) {				
			ordem++;			
			for(int  j : adjacencyMatrix[i]) {
				if(adjacencyMatrix[i][j] == 1) {
					tamanho++;
			}
			}	
	}		
		
		System.out.println("Ordem: " +  ordem);
		System.out.println("Tamanho: " + tamanho/2);
		
	}
	
	//Checar a exitencia de uma aresta
	public void checkEdge () {
		for(int i  = 0; i< nodeList.size(); i++) {		
			for(int  j : adjacencyMatrix[i]) {
				if(i == 1) {
				System.out.println("Tem aresta");
				}
			}
	
		}
	}
	
	//Gerar um grafo completo
	public void CompleteGraph() {}
	
	//Gerar um subgrafo 
	public void Subgraph () {}
	
	//Criação de arestas ponderadas
	public void weightedEdge () {}
	
	//Encontrar caminho entre dois vertices
	
	//Caminho euleriano (Hierholzer ou Fleury)
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for(int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + " ");
		}
		s.append("\n");
		for(int i  = 0; i< nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for(int  j : adjacencyMatrix[i]) {
				s.append((j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	
	public ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode>neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.index;		
		for(int i = 0; i < adjacencyMatrix.length; i++) {
			if(adjacencyMatrix[nodeIndex][i]==1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}
	
	// Busca em Profundidade
	public void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.println(currentNode.name + "  ");
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for(GraphNode neighbor : neighbors ) {
				if(!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}			
		}			
		}
	
	public void dfs() {
		for (GraphNode node : nodeList) {
			if(!node.isVisited) {
				dfsVisit(node);
			}
		}
	}
	
	
}
