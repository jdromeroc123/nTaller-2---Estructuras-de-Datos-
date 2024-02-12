package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }
    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        return this.arregloEnteros.clone();
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        return this.arregloCadenas.clone();
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad= this.arregloEnteros.length;
        return cantidad; 
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad=this.arregloCadenas.length;
        return cantidad;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int tamaño=getCantidadEnteros();
    	int posiciones = tamaño+1;
    	int[] nuevoElemento= new int[posiciones];
    	for(int i = 0;i < tamaño; i++)
    	{
    		nuevoElemento[i]=this.arregloEnteros[i];
    	}
    	nuevoElemento[tamaño]=entero;
    	this.arregloEnteros = nuevoElemento;
    }
    

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int tamaño=getCantidadCadenas();
    	int posiciones = tamaño+1;
    	String[] nuevoElemento= new String[posiciones];
    	for(int i = 0;i < tamaño; i++)
    	{
    		nuevoElemento[i]=this.arregloCadenas[i];
    	}
    	nuevoElemento[tamaño]=cadena;
    	this.arregloCadenas = nuevoElemento;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int apariciones=contarApariciones(valor);
    	int tamaño=getCantidadEnteros();
    	int posiciones = tamaño-apariciones;
    	int[] nuevoElemento= new int[posiciones];
		int traslacion = 0;
    	for(int i = 0;i < tamaño; i++)
    	{
    		if (this.arregloEnteros[i]==valor)
    		{
    			traslacion++;
    		}
    		else 
    		{
    		nuevoElemento[i-traslacion]=this.arregloEnteros[i];
    		}
    	}	
    	this.arregloEnteros = nuevoElemento;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int apariciones=contarApariciones(cadena);
    	int tamaño=getCantidadCadenas();
    	int posiciones = tamaño-apariciones;
    	String[] nuevoElemento= new String[posiciones];
		int traslacion = 0;
    	for(int i = 0;i < tamaño; i++)
    	{
    		if (this.arregloCadenas[i]==cadena)
    		{
    			traslacion++;
    		}
    		else 
    		{
    		nuevoElemento[i-traslacion]=this.arregloCadenas[i];
    		}
    	}	
    	this.arregloCadenas = nuevoElemento;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int tamaño=getCantidadEnteros();
    	if (posicion<0)
    	{
        	int posiciones = tamaño+1;
        	int[] nuevoElemento= new int[posiciones];
        	for(int i = 0;i < tamaño; i++)
        	{
        		nuevoElemento[i+1]=this.arregloEnteros[i];
        	}
        	nuevoElemento[0]=entero;
        	this.arregloEnteros = nuevoElemento;;
    	}
    	else if (posicion>=tamaño)
    	{
    		agregarEntero(entero);
    	}
    	else
    	{
        	int posiciones = tamaño+1;
        	int[] nuevoElemento= new int[posiciones];
        	int traslacion = 0;
        	for(int i = 0;i < tamaño; i++)
        	{
        		if (i== posicion)
        		{
        			nuevoElemento[i]=entero;
        			traslacion++;
        		}
        		nuevoElemento[i+traslacion]=this.arregloEnteros[i];
        	}
        	this.arregloEnteros = nuevoElemento;
    	}
    	
    }
    

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int tamaño=getCantidadEnteros();
    	if (posicion>=tamaño || posicion < 0)
    	{
    	}
    	else {
    		int posiciones = tamaño-1;
    		int[] nuevoElemento= new int[posiciones];
    		int traslacion=0;
    		for(int i = 0;i < tamaño; i++)
    		{
    			if (i == posicion)
    			{
    				traslacion++;
    			}
    			else 
    			{
    				nuevoElemento[i-traslacion]=this.arregloEnteros[i];
    			}
    					
    		}	
    		this.arregloEnteros = nuevoElemento;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int tamaño=valores.length;
    	int[] arregloReiniciado = new int[tamaño];
    	for (int i=0;i<tamaño;i++)
    	{
    		arregloReiniciado[i]=(int) valores[i];
    	}
    	this.arregloEnteros= arregloReiniciado;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	int tamaño=objetos.length;
    	String[] arregloReiniciado = new String[tamaño];
    	for (int i=0;i<tamaño;i++)
    	{
    		arregloReiniciado[i]= objetos[i].toString();
    	}
    	this.arregloCadenas= arregloReiniciado;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int tamaño=getCantidadEnteros();
    	int[] arregloPositivo = new int[tamaño];
    	for (int i=0;i<tamaño;i++)
    	{
    		if (this.arregloEnteros[i]<0)
    		{
    			arregloPositivo[i]=this.arregloEnteros[i]* -1;
    		}
    		else
    		{
    			arregloPositivo[i]=this.arregloEnteros[i];
    		}
    	}
    	this.arregloEnteros=arregloPositivo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	int tamaño = getCantidadEnteros();
        int soporte;
        for (int i = 0; i < tamaño - 1; i++) 
        {
            int minimo = i;
            for (int j = i + 1; j < tamaño; j++) 
            {
                if (this.arregloEnteros[j] < this.arregloEnteros[minimo]) 
                {
                    minimo = j;
                }
            }
            soporte = this.arregloEnteros[i];
            this.arregloEnteros[i] = this.arregloEnteros[minimo];
            this.arregloEnteros[minimo] = soporte;
   			}
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	int tamaño = getCantidadCadenas();
        String soporte;
        for (int i = 0; i < tamaño - 1; i++) 
        {
            int minimo = i;
            for (int j = i + 1; j < tamaño; j++) 
            {
                if (this.arregloCadenas[j].compareTo(this.arregloCadenas[minimo])<0) 
                {
                    minimo = j;
                }
            }
            soporte = this.arregloCadenas[i];
            this.arregloCadenas[i] = this.arregloCadenas[minimo];
            this.arregloCadenas[minimo] = soporte;
   			}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int apariciones=0;
    	for (int i=0;i<getCantidadEnteros();i++)
    	{
    		if (arregloEnteros[i]== valor)
    			apariciones++;
    	}
        return apariciones;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int apariciones=0;
    	for (int i=0;i<getCantidadCadenas();i++)
    	{
    		if (this.arregloCadenas[i].toLowerCase().equals(cadena.toLowerCase()))
    		{
    			apariciones++;	
    		}
    	}
        return apariciones;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int tamaño= getCantidadEnteros();
        int apariciones=contarApariciones(valor);
        int contador=0;
        int[]indices = new int[apariciones];
        for (int i=0;i<tamaño;i++)
        {
        	if (this.arregloEnteros[i]==valor)
        	{
        		indices[contador]=i;
        		contador++;
        	}
        }
        return indices;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (getCantidadEnteros()==0)
    	{
    		return new int[0];
    	}
    	else
    	{
        int[] minMax = new int[2];
        	int min= 0;
        	int max= 0;
        	for (int i=0;i<getCantidadEnteros();i++)
    		{
        		if (this.arregloEnteros[min]>this.arregloEnteros[i])
        		{
        			min=i;
        		}
        		if (this.arregloEnteros[max]<this.arregloEnteros[i])
        		{
        			max=i;
        		}
    		}
        	minMax[0]=this.arregloEnteros[min];
        	minMax[1]=this.arregloEnteros[max];
        	return minMax;
    	}
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer,Integer> histograma = new HashMap<Integer,Integer>();
    	for (int i=0;i<getCantidadEnteros();i++)
    	{
    		if ( ! histograma.containsKey(this.arregloEnteros[i])) 
    				{
    			histograma.put(this.arregloEnteros[i],1);
    				}
    		else 
    		{
    			histograma.put(this.arregloEnteros[i],histograma.get(this.arregloEnteros[i])+1);
    		}
    	}
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int repetidos=0;
    	HashMap<Integer,Integer> histograma = calcularHistograma();
    	for (Integer llave : histograma.keySet())
    	{
    		if (histograma.get(llave)>1)
    		{
    			repetidos++;
    		}
    	}
        return repetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean centinela=true;
    	if (this.arregloEnteros.length!=otroArreglo.length)
    	{
    		return false;
    	}
    	else 
    	{
    		int i=0;
    		while (centinela && i<this.arregloEnteros.length)
    		{
    			if(this.arregloEnteros[i]!= otroArreglo[i])
    			{
    				centinela=false;
    			}
    			i++;
    		}
    	}
       return centinela;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (this.arregloEnteros.length!=otroArreglo.length)
    	{
    		return false;
    	}
    	else
    	{
    		HashMap<Integer,Integer> histogramaUno = calcularHistograma();
        	HashMap<Integer,Integer> histogramaDos = new HashMap<Integer,Integer>();
        	boolean iguales =true;
        	for (int i=0;i<otroArreglo.length;i++)
        	{
        		if ( ! histogramaDos.containsKey(otroArreglo[i])) 
        				{
        			histogramaDos.put(otroArreglo[i],1);
        				}
        		else 
        		{
        			histogramaDos.put(otroArreglo[i],histogramaDos.get(otroArreglo[i])+1);
        		}
        	}
        	if (! histogramaUno.keySet().equals(histogramaDos.keySet()))
        	{
        		return false;
        	}
        	else
        	{
        		for (Integer llave : histogramaUno.keySet())
        		{
        			if(histogramaUno.get(llave)!= histogramaDos.get(llave))
        			{
        				iguales=false;
        			}
        		}
            	return iguales;
        	}
    	}
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] enterosGenerados = new int[cantidad];
    	for (int i =0; i<cantidad;i++)
    	{
    		enterosGenerados[i]= (int) (Math.random()*(maximo-minimo+1))+minimo;
    	}
    	this.arregloEnteros=enterosGenerados;
    }

}
