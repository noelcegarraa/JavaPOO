package org.ch25.util.mibanco;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.ch25.util.Imprimible;

/**
 * LA clase hace...
 * @author Noel
 * @version 1.2
 */
public abstract class CuentaCliente implements Imprimible{
	//Los números de cuenta del banco iniciarán después de 1000
	private static int consecutivo=1000; 
	protected double saldo;
	private int numeroCuenta; 
	private String numeroCliente;
	private Date fechaApertura;
	private String nomCliente;

	public CuentaCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	/**
     * 
     * @param saldo double - Saldo inicial de la cuenta
     * @param numeroCliente String  - Número del cliente, si se establece en 0 se genera uno aleatorio 
     * @param fechaApertura  java.util.Date - Fecha de apertura de la cuenta
     * @param nombreBanco String - Nombre del banco 
    */


	/**
	 * Este contructor........
	 * @param saldo {double} hace....
	 * @param numeroCliente {String} ....
	 * @param fechaApertura {Date} hace....
	 * @param nombreCliente {String} hace.....
	 */
	public CuentaCliente(double saldo, String numeroCliente, Date fechaApertura,

													String nombreCliente) {
	    this.saldo = saldo;
	    CuentaCliente.consecutivo++;
	    this.numeroCuenta = CuentaCliente.consecutivo;
	    this.setNombreCliente(nombreCliente);
		this.numeroCliente = numeroCliente;
		if (numeroCliente.equals("0")){ //Se genera un número de cliente aleatorio
			this.numeroCliente =Integer.toString(getAbs());
	    }//if numCliente.equals
		this.fechaApertura = fechaApertura;
	}//constructor

	/**
	 * EL metodo hace....
	 * @return {int} devuelve......
	 */
	private static int getAbs() {
		return Math.abs(new Random().nextInt());
	}

	/**
	 * Descripción del método
	 * @param saldo {double} hace lo siguiente....
	 */
	public CuentaCliente(double saldo) {
		this.saldo=saldo;
	}//constructor
	//Los métodos abstract deben ser implementados en la clase que hereda
	public abstract double retiro(double cantidad); 
	public abstract double deposito(double cantidad);
	public abstract double getSaldo();
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}//setSaldo
	
	public static int getConsecutivo() {
		return consecutivo;
	}//getConsecutivo

	public int getNumeroCuenta() {
		return numeroCuenta;
	}//getNumeroCuenta

	public String getNumeroCliente() {
		return numeroCliente;
	}//getNumeroCliente

	public String getFechaApertura() {
		DateFormat format = 
				       DateFormat.getDateInstance(DateFormat.SHORT);
		return format.format(fechaApertura);
	}//getFechaApertura


	public String toString() {
		return "Saldo=" + saldo + ", Número de Cuenta=" + getNumeroCuenta()
				+ ", Número del Cliente=" + getNumeroCliente()
				+ ", Fecha de Apertura=" + getFechaApertura()
				+ ", Nombre del Cliente=" + getNombreCliente();
	}//toString

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
}//class









