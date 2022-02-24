

public class DivideVenceras {
	public static int[] descomponer(int[] array, int inicio, int fin) {
		int[] arraypartido = new int[(array.length / 2)];
		int j = 0;
		for (int i = inicio; i <= fin; i++) {

			// claro, debe iniciar en la posicion 0 del arraynuevo no en la 4 porque no
			// existe.
			arraypartido[j] = array[i];
			j++;

		}
		return arraypartido;
	}

	public static int maximo(int[] array) {
		if (array.length == 1) {
			return array[0];
		} else {
			int n = (array.length / 2);
			int[] l1 = descomponer(array, 0, n - 1);
			int[] l2 = descomponer(array, n, (array.length - 1));
			int maxi = maximo(l1);
			int maxd = maximo(l2);
			int sol = Math.max(maxd, maxi);

			return sol;
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, 4, 5, 5, 3, 67, 3, 5 };
		System.out.println("El valor maximo es: " + maximo(array));
	}

}
