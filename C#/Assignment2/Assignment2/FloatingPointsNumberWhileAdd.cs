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
    class FloatingPointsNumberWhileAdd
    {
        private double total,input;


        public void Start() {
            InitialzeAdd();
            while (RequestInput()) {

            }
            Console.WriteLine("The sum is: {0:f2}",total);
        }

        private bool RequestInput()
        {
            Console.Write("Write an amount to sum or 0 to finish: ");
            input = Input.ReadDoubleInput();
            if (input == 0) return false;
            total += input;
            return true;
        }


        private void InitialzeAdd()
        {
            total = 0;
            Console.WriteLine();
            Console.WriteLine("+++++++++++++++ Summation of real numbers +++++++++++++++");
            Console.WriteLine("                   Using a While-Loop                    ");
            Console.WriteLine();
            Console.WriteLine("Write 0 to finish!");
            Console.WriteLine("Make sure to use the correct decimal character!");
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine();
        }
    }
}
