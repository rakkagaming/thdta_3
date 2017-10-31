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
    class WholeNumbersForAdd
    {
        private int amountOfNumbers, total = 0;

        public void Start() {
            InitialzeAdd();
            while (!(amountOfNumbers > 0)) {
                amountOfNumbers = Input.ReadIntInput();
                if (amountOfNumbers<0) Console.WriteLine("Incorrect input, please try again!");
            }


            for (int i = 1; i < amountOfNumbers+1; i++) {
                Console.WriteLine("Value nr " + i + " (Whole number):");
                total += Input.ReadIntInput();
            }
            Console.WriteLine("Sum: " + total);
        }

       

        private void InitialzeAdd()
        {
            amountOfNumbers = 0;
            total = 0;
            Console.WriteLine();
            Console.WriteLine("++++++++++++++ Summation of whole numbers +++++++++++++++");
            Console.WriteLine("                     Using a For-Loop                    ");
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine("Number of values to sum: ");
        }
    }
}
