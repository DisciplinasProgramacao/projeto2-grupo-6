package Grafos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		
		/*
		 * Código para ler o arquivo TXT
		 * 
		File file = new File("c:\\temp\\FileRead.txt"); 
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		*/
		
		/*
		 * Codigo para salvar em arquivo TXT
		 
		  
		  String[] lines = new String [] {"A", "B", "C"};
		  
		  String path = "c:\\temp\\FileSave.txt";
		  
		  try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			  for (String line : lines) {
				  bw.write(line);
				  bw.newLine();
			  }
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		 
		*/ 		
		
		nodeList.add(new GraphNode("A",0));
		nodeList.add(new GraphNode("B",1));
		nodeList.add(new GraphNode("C",2));
		nodeList.add(new GraphNode("D",3));
		nodeList.add(new GraphNode("E",4));
		
		Graph g = new Graph(nodeList);
		
	
		g.addUnidirectedEdge(0, 1);
		g.addUnidirectedEdge(0, 2);
		g.addUnidirectedEdge(0, 3);
		g.addUnidirectedEdge(1, 4);
		g.addUnidirectedEdge(2, 3);
		g.addUnidirectedEdge(3, 4);
		
		System.out.println(g.toString());
		
		g.dfs();
		
	}

}
