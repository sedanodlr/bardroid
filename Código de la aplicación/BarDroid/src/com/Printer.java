package com;

import android.os.AsyncTask;
import android.util.Log;
import bardroid.core.Ticket;

public class Printer extends AsyncTask<Ticket, Void, Void> {
	
	private static void sendToPrinter(Ticket t){

		formatTicket(t);
		//Vincula con la impresora y manda el ticket
		Log.e("Estado: ", "imprimiendo");
	}

	private static void formatTicket(Ticket t) {
		// TODO Auto-generated method stub
		Log.e("Estado: ", "creando ticket");
		
	}

	@Override
	protected Void doInBackground(Ticket... params) {
		// TODO Auto-generated method stub
		sendToPrinter((Ticket)params[0]);
		
		return null;
	}

}
