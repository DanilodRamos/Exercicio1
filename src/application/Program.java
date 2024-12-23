package application;
/*Problema exemplo
Fazer um programa para ler os dados de uma reserva de hotel(número do quarto,data
de entrada e data de saída)e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva comos dados atualizados.O programa não deve aceitar dados
inválidos para a reserva,conforme as seguintes regras:-Alterações de reserva só 
podem ocorrer para datas futuras-A data de saída deve ser maior que a data de entrada
 Examples1
 Roomnumber: 8021
 Check-in date (dd/MM/yyyy): 23/09/2019
 Check-out date (dd/MM/yyyy): 26/09/2019
 Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 Enter data to update the reservation:
 Check-in date (dd/MM/yyyy): 24/09/2019
 Check-out date (dd/MM/yyyy): 29/09/2019
 Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights
 Roomnumber: 8021
 Check-in date (dd/MM/yyyy): 23/09/2019
 Check-out date (dd/MM/yyyy): 21/09/2019
 Errorin reservation: Check-out date must beaftercheck-in date
 
  Examples2
 Roomnumber: 8021
 Check-in date (dd/MM/yyyy): 23/09/2019
 Check-out date (dd/MM/yyyy): 26/09/2019
 Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 Enter data to update the reservation:
 Check-in date (dd/MM/yyyy): 24/09/2015
 Check-out date (dd/MM/yyyy): 29/09/2015
 Errorin reservation: Reservation dates for updatemust be future dates
 Roomnumber: 8021
 Check-in date (dd/MM/yyyy): 23/09/2019
 Check-out date (dd/MM/yyyy): 26/09/2019
 Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 Enter data to update the reservation:
 Check-in date (dd/MM/yyyy): 24/09/2020
 Check-out date (dd/MM/yyyy): 22/09/2020
 Errorin reservation: Check-out date must beaftercheck-in date
*/

//importaçoes
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		//escanear
		Scanner sc = new Scanner(System.in);
		//datas
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//exceçoes 
		try { //ler numero do quarto
			System.out.print("Room number: ");
			int number = sc.nextInt();
			//data entrada
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			//data saida
			System.out.print("Check-out date (dd/MM/yyyy): ");
			//tratar metodo de excecao
			Date checkOut = sdf.parse(sc.next());
			
			//instaciando a reserva e os dados da reserva numero data entrada e data saida
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			 //atualizando datas
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}//execoes invalidado formato
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		//erro de reserva  datas anteriores da normal ou posterior
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}
}