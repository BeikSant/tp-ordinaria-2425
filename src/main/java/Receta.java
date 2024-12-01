/**
 * Clase que representa una receta con un nombre, ingredientes e instrucciones.
 */
public class Receta {
    /**
     * Nombre de la receta
     */
    private String nombre;
    /**
     * Ingredientes de la receta
     */
    private String[] ingredientes;
    /**
     * Instrucciones de la receta
     */
    private String[] instrucciones;
    /**
     * Máximo de ingredientes que puede tener la receta
     */
    private int maxIngredientes;
    /**
     * Máximo de instrucciones que puede tener la receta
     */
    private int maxInstrucciones;
    /**
     * Número actual de ingredientes que posee la receta
     */
    private int numIngredientes;
    /**
     * Número actual de instrucciones que posee la receta
     */
    private int numInstrucciones;

    /**
     *
     * Constructor para crear una nueva instancia de una Receta
     *
     * @param nombre            el nombre de la receta
     * @param maxIngredientes   el número máximo de ingredientes de la receta
     * @param maxInstrucciones  el número máximo de instrucciones de la receta
     */
    public Receta(String nombre, int maxIngredientes, int maxInstrucciones) {
        this.nombre = nombre;
        this.maxIngredientes = maxIngredientes;
        this.maxInstrucciones = maxInstrucciones;
        this.ingredientes = new String[maxIngredientes];
        this.instrucciones = new String[maxInstrucciones];
        this.numIngredientes = 0;
        this.numInstrucciones = 0;
    }

    /**
     * Obtiene el nombre de la receta.
     *
     * @return una cadena que representa el nombre de la receta
     */
    public String getNombre() {
        // Devuelve el nombre de la receta
        return nombre;
    }

    /**
     * Obtiene la lista de ingredientes de la receta.
     *
     * @return  un arreglo de cadenas que contiene los ingredientes de la receta.
     *          Si no hay ingredientes, el arreglo puede estar vacío
     */
    public String[] getIngredientes() {
        // Devuelve los ingredientes de la receta
        return ingredientes;
    }

    /**
     * Obtiene la lista de instrucciones de la receta.
     *
     * @return  un arreglo de cadenas que contiene las instrucciones paso a paso de la receta.
     *          Si no hay instrucciones, el arreglo puede estar vacío
     */
    public String[] getInstrucciones() {
        // Devuelve las instrucciones de la receta
        return instrucciones;
    }

    /**
     * Agrega un ingrediente a la receta si aún hay espacio disponible.
     *
     * @param ingrediente  el ingrediente que se desea agregar a la receta
     * @return true si el ingrediente fue agregado exitosamente, false si no hay espacio disponible
     */
    public boolean agregarIngrediente(String ingrediente) {
        // Añade un ingrediente a la receta
        boolean esAgregado = false;
        if (!ingredientesCompletos()) {
            ingredientes[numIngredientes] = ingrediente;
            numIngredientes++;
            esAgregado = true;
        }
        return esAgregado;
    }

    /**
     * Agrega una instrucción a la receta si aún hay espacio disponible.
     *
     * @param instruccion   la instrucción que se desea agregar a la receta
     * @return  true si la instrucción fue agregado exitosamente, false si no hay espacio disponible
     */
    public boolean agregarInstruccion(String instruccion) {
        // Añade una instrucción a la receta
        boolean esAgregado = false;
        if (!instruccionesCompletas()) {
            instrucciones[numInstrucciones] = instruccion;
            numInstrucciones++;
            esAgregado = true;
        }
        return esAgregado;
    }


    /**
     * Verifica si la receta ha alcanzado el número máximo de ingredientes permitidos.
     *
     * @return true si el número actual de ingredientes es igual al límite máximo permitido, false en caso contrario
     */
    public boolean ingredientesCompletos() {
        // Comprueba si la receta tiene el máximo de ingredientes
        return numIngredientes == maxIngredientes;
    }

    /**
     * Verifica si la receta ha alcanzado el número máximo de instrucciones permitidas.
     *
     * @return true si el número actual de instrucciones es igual al límite máximo permitido, false en caso contrario
     */
    public boolean instruccionesCompletas() {
        // Comprueba si la receta tiene el máximo de instrucciones
        return numInstrucciones == maxInstrucciones;
    }

    /**
     * Obtiene el número actual de ingredientes en la receta.
     *
     * @return el número de ingredientes añadidos a la receta
     */
    public int numIngredientes() {
        // Devuelve el número de ingredientes de la receta
        return numIngredientes;
    }

    /**
     * Obtiene el número actual de instrucciones en la receta.
     *
     * @return el número de instrucciones añadidas a la receta
     */
    public int numInstrucciones() {
        // Devuelve el número de instrucciones de la receta
        return numInstrucciones;
    }

    /**
     * Devuelve una representación en forma de cadena de la receta.
     *
     * @return una cadena que incluye el nombre de la receta, los ingredientes y las instrucciones,
     *         formateados de manera legible
     */
    @Override
    public String toString() {
        // Devuelve una representación en forma de cadena de la receta
        StringBuilder cadena = new StringBuilder("Receta: " + nombre + "\n");
        cadena.append("Ingredientes:\n");
        for (int i = 0; i < numIngredientes; i++) cadena.append("- ").append(ingredientes[i]).append("\n");
        cadena.append("Instrucciones:\n");
        for (int i = 0; i < numInstrucciones; i++) cadena.append((i + 1)).append(". ").append(instrucciones[i]).append("\n");
        return cadena.toString();
    }

    /**
     * Devuelve una representación en forma de cadena sin formato de la receta.
     *
     * @return una cadena que contiene el nombre, los ingredientes y las instrucciones
     *         de la receta en un formato simple, separado por saltos de línea.
     */
    public String toRawString() {
        // Devuelve una representación en forma de cadena de la receta sin formato
        StringBuilder cadena = new StringBuilder(nombre + "\n");
        for (int i = 0; i < numIngredientes; i++) cadena.append(ingredientes[i]).append("\n");
        cadena.append("INSTRUCCIONES\n");
        for (int i = 0; i < numInstrucciones; i++) cadena.append(instrucciones[i]).append("\n");
        cadena.append("-----\n");
        return cadena.toString();
    }

    /**
     * Obtiene el número máximo de ingredientes permitidos en la receta.
     *
     * @return el número máximo de ingredientes que se pueden agregar a la receta.
     */
    public int getMaxIngredientes() {
        // Devuelve el máximo de ingredientes permitidos en la receta
        return maxIngredientes;
    }

    /**
     * Obtiene el número máximo de instrucciones permitidas en la receta.
     *
     * @return el número máximo de instrucciones que se pueden agregar a la receta.
     */
    public int getMaxInstrucciones() {
        // Devuelve el máximo de instrucciones permitidas en la receta
        return maxInstrucciones;
    }
}

