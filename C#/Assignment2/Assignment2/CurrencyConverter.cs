using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 * Created by: Robin Johnsson
 * Itslearning ID: ae3873
 * Creation Date: 2017-09-20
 * Last Edited: 2017-10-03
*/
namespace Assignment2
{
    class CurrencyConverter
    {

        private double sum,total, input, exchangeRate;
        private string currency;


        public void Start()
        {
            InitialzeAdd();
            do {
                total += input;
            }
            while (RequestInput());

            RequestCurrency();
            Console.WriteLine("{0} kr is converted to {1:f2} {2} at the rate of {3} kr/{4}.",total,sum,currency,exchangeRate,currency);
            Console.WriteLine(total + " kr is converted to " + sum + " " + currency + " at the rate of " + exchangeRate + " kr/" + currency + ".");
            Console.WriteLine();
        }

        private void RequestCurrency()
        {
            Console.Write("Name of foregin currency: ");
            currency = Console.ReadLine();
            Console.Write("Exchange rate: ");
            exchangeRate = Input.ReadDoubleInput();

            sum = total / exchangeRate;
        }

        private bool RequestInput()
        {
            Console.Write("Write an amount to sum or 0 to finish: ");
            input = Input.ReadDoubleInput();
            if (input == 0) return false;
            return true;
        }

        

        private void InitialzeAdd()
        {
            total = 0;
            Console.WriteLine();
            Console.WriteLine("++++++++++++++++ The Currency Converter +++++++++++++++++");
            Console.WriteLine();
            Console.WriteLine("Write 0 to finish!");
            Console.WriteLine("Make sure to use the correct decimal character!");
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine();
        }
    }
}
