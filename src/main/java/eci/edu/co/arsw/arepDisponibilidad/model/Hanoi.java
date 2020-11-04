package eci.edu.co.arsw.arepDisponibilidad.model;

/**
 * Crea la logica de una torre de hanoi y retorna el numero minimo de movimientos para realizar una torre hanoi de N discos
 * @author rojas
 *
 */
public class Hanoi {
	private int numDisk = 0;
	private String result = "";
	private int numMove = 0; 
	
	public Hanoi(int numDisk){
		this.numDisk = numDisk;
	}
	/**
	 * Retorna el resultado calculado 
	 * @return String con pasos 
	 */
	public String getResult() {
		calculateSteps(numDisk,"A","B","C");
		return result;
	}
	/**
	 * Calcula el numero de movimientos para completar la torre de hanoi
	 * @param num Numero de discos 
	 * @param origen Torre A
	 * @param medio Torre B
	 * @param destino Torre B
	 */
	private void calculateSteps(int num, String origen, String medio, String destino) {
		numMove ++;
		if (num == 1) {
			result += "Move disk "+num+" from tower "+origen+" to tower "+destino+"\n";
		}else{
			calculateSteps(num - 1, origen, destino, medio);
			result += "Move disk "+ num +" de torre " + origen + " a torre " + destino+"\n";
			calculateSteps(num - 1, medio, origen, destino);
			
		}
		
	}
	/**
	 * Retorna el numero minimo de movimientos para realizar la torre de Hanoi
	 * @return int con numero de movimientos 
	 */
	public int getNumMove() {
		return numMove;
	}
	
}
