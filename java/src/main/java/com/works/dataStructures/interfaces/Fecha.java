package com.works.dataStructures.interfaces;

public class Fecha implements Comparable<Fecha> {

	private int dia, mes, anho;
	private static int[] dia_mes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Fecha(int d, int m, int a) throws Exception {
		if (m < 1 || m > 12)
			throw new Exception("Mes inválido.");
		if (a < 1)
			throw new Exception("Año inválido.");
		if (d < 1 || d > dia_mes[m])
			if (m != 2 || d != 29 || !bisiesto(a))
				throw new Exception("Día inválido.");
		dia = d;
		mes = m;
		anho = a;
	}

	private static boolean bisiesto(int a) {
		return !(a % 4 != 0 || (a % 100 == 0 && a % 400 != 0));
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Fecha))
			return false;
		Fecha f = (Fecha) obj;
		return (dia == f.dia && mes == f.mes && anho == f.anho);
	}

	public int hashCode() {
		return (anho - 1900) * 366 + mes * 31 + dia;
	}

	public String toString() {
		return dia + "-" + mes + "-" + anho;
	}

	@Override
	public int compareTo(Fecha arg0) {
		int comparacionDia = this.dia - arg0.dia;
		int comparacionMes = this.mes - arg0.mes;
		int comparacionAnho = this.anho - arg0.anho;

		if (comparacionDia > 0 || comparacionMes > 0 || comparacionAnho > 0) {
			return 1;
		} else if (comparacionDia < 0 || comparacionMes < 0 || comparacionAnho < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}