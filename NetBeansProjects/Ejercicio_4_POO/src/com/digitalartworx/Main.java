package com.digitalartworx;

public class Main {

    public static void main(String[] args) {
	    Empresa e = new Empresa("Intel", "CH77218F");
	    e.addEmpleado("Cedric", "X8741949V", 1769.89);
	    e.addEmpleado("Kerstin", "B7263912N", 1489.46);

	    e.show(true);
		System.out.println("");
	    e.showAllEmpleados();
		System.out.println("");
	    e.showRelevantData();
		System.out.println("");
	    e.calcAllBruto();
		System.out.println("");
	    e.calcAllNeto();
		e.removeEmpleado("X8741949V");
		e.showAllEmpleados();

    }
}
