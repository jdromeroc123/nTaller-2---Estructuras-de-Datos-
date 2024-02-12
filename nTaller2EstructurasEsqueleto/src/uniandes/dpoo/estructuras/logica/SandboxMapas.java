package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> lista = new ArrayList<>(this.mapaCadenas.values());
    	int tamaño = lista.size();
        String soporte;
        for (int i = 0; i < tamaño - 1; i++) 
        {
            int minimo = i;
            for (int j = i + 1; j < tamaño; j++) 
            {
                if (lista.get(j).compareTo(lista.get(minimo))<0) 
                {
                    minimo = j;
                }
            }
            soporte = lista.get(i);
            lista.set(i, lista.get(minimo));
            lista.set(minimo, soporte);
   			}
    	return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> lista = new ArrayList<>(this.mapaCadenas.keySet());
    	int tamaño = lista.size();
        String soporte;
        for (int i = 0; i < tamaño - 1; i++) 
        {
            int maximo = i;
            for (int j = i + 1; j < tamaño; j++) 
            {
                if (lista.get(j).compareTo(lista.get(maximo))>0) 
                {
                    maximo = j;
                }
            }
            soporte = lista.get(i);
            lista.set(i, lista.get(maximo));
            lista.set(maximo, soporte);
   			}
    	return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        List<String> lista = getLlavesComoListaInvertida();
        if (lista.size()>0)
        {
        return lista.get(lista.size()-1);
        }
        else 
        {
        	return null;
        }
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	List<String> lista = getValoresComoLista();
        if (lista.size()>0)
        {
        return lista.get(lista.size()-1);
        }
        else 
        {
        	return null;
        }
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> coleccion= new ArrayList<>();
    	for (String llave: this.mapaCadenas.keySet())
    	{
    		coleccion.add(llave.toUpperCase());
    	}
        return coleccion;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	List<String> valores = getValoresComoLista();
    	List<String> auxiliar = new ArrayList<>();
    	for (String valor: valores)
    	{
    		if (! auxiliar.contains(valor))
    		{
    			auxiliar.add(valor);
    		}
    	}
        return auxiliar.size(); 
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	char[] caracter =cadena.toCharArray();
    	int tamaño = caracter.length;
    	char auxiliar;
    	for (int i=0; i<tamaño /2; i++)
    	{
    		auxiliar=caracter[i];
    		caracter[i] = caracter[tamaño-1-i];
    		caracter[tamaño-1-i]=auxiliar;
    	}
    	String cadenaInvertida =new String(caracter);
    	this.mapaCadenas.put(cadenaInvertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	List<String> llaves = getLlavesComoListaInvertida();
    	for (String llave: llaves)
    	{
    		if (this.mapaCadenas.get(llave).equals(valor))
    		{
    			mapaCadenas.remove(llave);
    		}
    	}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	List<String> nuevosValores = new ArrayList<>();
    	for (Object objeto : objetos)
    	{
    		nuevosValores.add(objeto.toString());
    	}
    	this.mapaCadenas.clear();
    	for (String llave: nuevosValores)
    	{
    		agregarCadena(llave);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	List<String> llaves = getLlavesComoListaInvertida();
    	for (String llave: llaves)
    	{
    		String valor = this.mapaCadenas.get(llave);
    		String llaveMayuscula = llave.toUpperCase();
    		eliminarCadenaConLLave(llave);
    		this.mapaCadenas.put(llaveMayuscula, valor);
    	}
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean iguales =true;
    	List<String> valores= getValoresComoLista();
    	for (int i=0; i<otroArreglo.length;i++)
    	{
    		if (! valores.contains(otroArreglo[i]))
    		{
    			iguales=false;
    		}
    	}
    	return iguales;
    }

}
