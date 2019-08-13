/*
* Program that calculates a parking fee, keeps track of how many customers
* used coupons, calculates the total amount of revenue from all served customers
* adds all tips received.
* @ Author
* Elena Voinu
* 02/16/2019
* */
package Lab4;

import java.util.Scanner;

public class PrattParkingGarage {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        // the local variables declared and initialized
        char answer = 'Y', specEvent = 'N', rateCode = '\0';
        int ticketNum = 0, count = 0;  int countCustomers = 0;
        int timeIn = 0, timeOut = 0, timeDiff = 0;
        double amountTendered = 0.0, changeDue = 0.0;
        double flatFee = 0.0, monthFee = 0.0;
        double EXTRA_CHARGE = 0.0;
        double coupon = 0.0, tip = 0.0, grandTotalFromCust = 0,
                grandTotalTip=0, grandTotalCoupon = 0, grandTotalTax=0.0 ;
        double flatTax = 3.00, totalDueFromCust = 0.0;

        System.out.println("");
        System.out.println("");
        System.out.println("***************************");
        System.out.println("----Pratt Parking Garage---");
        System.out.println("***************************");
        System.out.println("");
        System.out.println("");
        while(answer == 'Y' || answer == 'y') {
            System.out.println("--------- M E N U ---------");
            System.out.println("Data entry process: Enter Each Of These");
            System.out.println("Customer Ticket Number ->");
            ticketNum = sc.nextInt();
            System.out.println("Ticket number " + (ticketNum));
            System.out.println("Time in (military)");
            timeIn = sc.nextInt();
            System.out.println("Time out (military)");
            timeOut = sc.nextInt();
            timeDiff = timeOut - timeIn;
            System.out.println("Time difference " + (timeDiff));

            System.out.println("Rate code: (F or M)");
            rateCode = sc.next().charAt(0);
            System.out.println("Rate code: " + rateCode);
            if (rateCode == 'F') {
                flatFee = 10.00;
                totalDueFromCust = flatFee;
            }
            if (rateCode == 'M') {
                monthFee = 90.00;
                totalDueFromCust = monthFee;
                // monthly fee is deferred
                totalDueFromCust = 0;
            }
            System.out.println("Tip amount:");
            tip = sc.nextDouble();
            System.out.printf("Tip: $%.2f\n", tip);
            totalDueFromCust += tip;

            System.out.printf("Flat tax: $%.2f\n", flatTax);
            totalDueFromCust += flatTax;

            System.out.println("Special event(Y or N)?");
            specEvent = sc.next().charAt(0);
            if (specEvent == 'Y') EXTRA_CHARGE = 10;
            totalDueFromCust += EXTRA_CHARGE;
            System.out.println("Coupon amount");
            coupon = sc.nextDouble();
            totalDueFromCust -= coupon;

            System.out.printf("Total charge: $%.2f\n", totalDueFromCust);
            System.out.println("Amount tendered from customer");
            amountTendered = sc.nextDouble();
            changeDue = amountTendered - totalDueFromCust;
            System.out.printf("Change: $%.2f\n", changeDue);
            System.out.println("****************************************");
            System.out.println("Run again(Y or N)?");
            answer = sc.next().charAt(0);
            System.out.println();
            System.out.println("****************************************");

            // Calculating the number of customers served
            if (coupon >= 0) {
                countCustomers++;
                System.out.println("Total number of customers served is: " + countCustomers);
            }


            //Counting how many customers used coupons
            if(coupon >0){
                count = count+1;

            }

            grandTotalFromCust += totalDueFromCust;
            grandTotalTip +=tip;
            grandTotalCoupon +=coupon;
            grandTotalTax +=flatTax;



        }
        System.out.println("Total amount of people who have used coupons: " + count);


        //Calculation total coupons applied
        for(coupon = 0; coupon<=totalDueFromCust; coupon++) {
            grandTotalCoupon += coupon;
            System.out.printf("Total coupon saving amount is: $%.2f\n", grandTotalCoupon);
            break;
        }

        //Loop for calculating the total amount made
        for (totalDueFromCust = 0; totalDueFromCust <= grandTotalFromCust; totalDueFromCust++) {
            grandTotalFromCust += totalDueFromCust;
            System.out.printf("Grand total is: $%.2f\n ", grandTotalFromCust);
            break; //exit
        }

        //Loop calculating total tips received from all costumers served
        for (tip = 0; tip <=totalDueFromCust; tip++){
            grandTotalTip +=tip;
            System.out.printf("\nTotal amount of tips received: $%.2f ", grandTotalTip);
           // break;//break loop
        }
        //Loop for calculating total tax amount from all customers
        for(flatTax = 0; flatTax <= totalDueFromCust; flatTax++){
            grandTotalTax +=flatTax;
            System.out.printf("\nTotal amount of taxes paid by customers is: $%.2f ", grandTotalTax);
        }


        System.out.println("\n****************************************");
    }// end main()
}// end class



