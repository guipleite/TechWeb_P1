package br.insper.noteblock;


import java.util.Calendar;
import java.util.Comparator;

public class Comparador implements Comparator{

	  public int compare(Object x, Object y) {
		    Calendar xcal = (Calendar) x;
		    Calendar ycal = (Calendar) y;
		    if ( xcal.before(ycal) ) return -1;
		    if ( xcal.after(ycal) ) return 1;
		    return 0;
		  }
	
}
