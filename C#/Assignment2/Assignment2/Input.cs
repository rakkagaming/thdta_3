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
    class Input
    {
        //Used by WorkingSchedule
        public static int ReadIntInput()
        {
            int choice = 0;
            bool goodInput = false;
            do
            {
                string input = Console.ReadLine();
                goodInput = int.TryParse(input, out choice);
                if (!goodInput) Console.WriteLine("Incorrect input, please try again!");
            } while (!goodInput);

            return choice;
        }

        public static double ReadDoubleInput()
        {
            double choice = 0;
            bool goodInput = false;
            do
            {
                string input = Console.ReadLine();
                goodInput = double.TryParse(input, out choice);
                if (!goodInput) Console.WriteLine("Incorrect input, please try again!");
            } while (!goodInput);

            return choice;
        }
    }
}
