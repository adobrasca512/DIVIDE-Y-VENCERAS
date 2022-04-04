import java.util.Arrays;

public class Inverso {
	public static boolean inverso(int[] arrayA, int[] arrayB, int inicio, int fin) {

		if (inicio == fin) {
			//aqui volteamos el valor del inicio
			return arrayA[inicio] == arrayB[(arrayB.length - 1) - inicio];
		} else {
			int mitad = ((inicio + fin) / 2);
			//si x es false no me interesa seguir con la otra parte.
			boolean x = inverso(arrayA, arrayB, inicio, mitad);
			if (x == true) {
				//en la continuacion de la segunda parte devuelvo su valor
				return inverso(arrayA, arrayB, (mitad + 1), fin);

			}
			return x;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayA = { 4,0,4,6,2 };
		int[] arrayB = {2,6,4,0,4 };
		if (arrayA.length == arrayB.length) {

			// System.out.println(arrayB[6]);
			System.out.println(inverso(arrayA, arrayB, 0, (arrayA.length - 1)));
		} else {
			System.out.println("No son iguales.");
		}
	}

}
