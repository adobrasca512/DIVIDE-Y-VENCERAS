package MetodosdeOrdenacion;

public class DivideYVenceras {
	public static int sonPares(int array[], int inicio, int fin) {
		int cantidadpares = 0;

		// Esto sera si es un array corto {0}
		if (inicio == fin) {
			// verifico si el valor dentro es un numero par

			if ((array[inicio] % 2) == 0) {
				cantidadpares++;

			}
			// Devolvemos la cantidad de pares que me he encontrado
			return cantidadpares;
		} else {
			// Parto mi primera mitad

			int mitad = (inicio + fin) / 2;

			int x = sonPares(array, inicio, mitad);

			int y = sonPares(array, mitad + 1, fin);
			// Sumo la cantidad de pares encontrados de la primera mitad y de la segunda
			// mitad
			return x + y;
		}

	}

	public static int sonIgualesDivision(int array1[], int array2[], int inicio, int fin) {

		if (inicio == fin) {

			if (array1[inicio] == array2[inicio]) {
				//Verifico si los valores de la particion son identicos
				return -1;
			} else {

				return inicio;
			}

		} else {

			int mitad = (inicio + fin) / 2;
			// Este es el metodo de division de divide y venceras.
			// Parto la primera mitad
			
			int a = sonIgualesDivision(array1, array2, inicio, mitad);
			//si no son iguales y encontro una posicion distinta, devolvemos la posicion
			if (a != -1) {

				return a;
			}
			//sino partimos la segunda mitad para comprobar que no sea distinto
			else {
				// Parto la segunda mitad
				int y = sonIgualesDivision(array1, array2, mitad + 1, fin);
				// Aqui respondo a lo que me da el return de el valor que sea distinto
				
				if (y == -1) {
					return y;
				}	
			}
			

			return -1;

		}

	}

	public static int sonIgualesSustraccion(int arr1[], int arr2[], int inicio, int fin) {

		if (inicio <= fin) {

			if (arr1[fin] == arr2[fin]) {
				// Voy disminuyendo el valor del final, haciendo la sustraccion de atras hacia
				// delante recursivamente.
				return sonIgualesSustraccion(arr1, arr2, inicio, fin - 1);
			} else {
				// Si no son iguales retorno la posicion en la que se encontro la diferencia.
				return fin;
			}

		}

		return -1;
	}

	public static boolean buster(int arr[], int inicio, int fin, int x) {

		if (inicio < fin) {
			int primeraParte = (inicio + fin) / 3;
			int segundaParte = (2 * (inicio + fin) / 3);
			if (arr[primeraParte] == x) {
				return true;
			} else {
				// Verifico la primera seccion desde la primera particion en la busqueda
				// ternaria.
				if (x < arr[primeraParte]) {
					return buster(arr, inicio, primeraParte, x);
				} else {
					// Verifico la segunda seccion desde la primera particion en la busqueda
					// ternaria.
					if (arr[segundaParte] == x) {
						return true;
					} else {

						if (x < arr[segundaParte]) {
							return buster(arr, primeraParte + 1, segundaParte, x);
						}
						// Como ultimo caso en donde no se encuentre, recurrimos a la ultima particion
						else {
							if (arr[fin] == x) {
								return true;
							} else {
								return buster(arr, segundaParte + 1, fin, x);
							}

						}
					}
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {

		int lista[] = { 1, 2, 3, 4, 6, 7, 5, 9 };
		int lista1[] = { 2, 2, 4, 5, 6, 7, 8, 9 };
		System.out.println(
				"* * * * * * * * * * * * * * * * * * METODO DIVIDE Y VENCERAS * * * * * * * * * * * * * * * *");
		System.out.println("\nEl total de pares son " + sonPares(lista, 0, 7) + "\n");
		System.out.println(
				"* * * * * * * * * * * * * * * * * * METODO POR DIVISION * * * * * * * * * * * * * * * * * * *");
		System.out.println("\nSi es distinto devuelve la posicion distinta, sino -1: "
				+ sonIgualesDivision(lista, lista1, 0, 7) + "\n");
		System.out.println(
				"* * * * * * * * * * * * * * * * * * METODO POR SUSTRACCION * * * * * * * * * * * * * * * * * *");
		System.out.println("\nSi es distinto devuelve la posicion distinta, sino -1: "
				+ sonIgualesSustraccion(lista, lista1, 0, 7) + "\n");
		System.out.println(
				"* * * * * * * * * * * * * * * * * * METODO BUSTER * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("El valor en busqueda da un resultado de: " + buster(lista, 0, 7, 0));
//FINALIZADO
	}

}
