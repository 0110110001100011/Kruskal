import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kruskal {

	static int path[];
	static int n,m,mincost,i,j;
		
	public static void main(String[] args) throws Exception {
		InputStreamReader isr;
		isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		
		//crear grafo de 'n' vertices & 'm' aristas
		System.out.println("Ingresar el numero de vertices en el grafo: ");
		n = Integer.parseInt(in.readLine());
		System.out.println("Ingresa el numero de aristas en el grafo: ");
		m = Integer.parseInt(in.readLine());
		
		path = new int[n+1];
		
		Arista e[] = new Arista[m];
		Arista t = new Arista();
		
		for(i=0;i<m;i++){
			e[i]=new Arista();
			System.out.println("Ingresar 2 vertices y peso del arista");
			System.out.print("Primer vertice: ");
			e[i].u=Integer.parseInt(in.readLine());
			System.out.print("Segundo vertice: ");
			e[i].v=Integer.parseInt(in.readLine());
			System.out.print("Peso: ");
			e[i].wt=Integer.parseInt(in.readLine());
		}
		
		//ordenar aristas de forma ascendente por peso
		for(i=0;i<m-1;i++){
			for(j=0;j<m-i-1; j++){
				if(e[j].wt > e[j+1].wt){
					t=e[j];
					e[j]=e[j+1];
					e[j+1]=t;
				}
			}
		}
		
		//Inicializar el arreglo path
		for(i=1;i<=n;i++){
			path[i]=0;
		}
		
		i=0;
		j=0;
		mincost=0;
		System.out.println();
		
		while((i!=n-1)&&(j!=m)){
			System.out.print("Arista ("+e[j].u+", "+e[j].v+") "+
					"con peso: "+e[j].wt+" ");
			if(RevisaCiclo(e[j])){
				mincost = mincost + e[j].wt;
				i++;
				System.out.println("Seleccionado");
			}
			else{
				System.out.println("Descartado");
			}
			j++;
		}
		if(i!=n-1){
			System.out.println("No se puede formar arbol de expansion minima");
		}
	}
	public static boolean RevisaCiclo(Arista e){
		int u=e.u, v=e.v;
		while(path[u]>0)
			u=path[u];
		while(path[v]>0)
			u=path[v];
		if(u!=v){
			path[u]=v;
			return true;
		}
		return false;
		
	}
	
	static class Arista{
		int u, v, wt;
		
	}

}
