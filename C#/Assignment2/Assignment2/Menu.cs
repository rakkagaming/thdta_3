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
    class Menu
    {
        private WholeNumbersForAdd wnfa;
        private FloatingPointsNumberWhileAdd fpnwa;
        private CurrencyConverter cc;
        private WorkingSchedule ws;
        private TemperatureConverter tc;
        public void Start()
        {
            int choice = -1;
            InitializeVariables();
            
            while (choice != 0)
            {
                InitializeWindow();
                choice = Input.ReadIntInput();

                switch (choice)
                {
                    case 0:
                        Console.WriteLine();
                        Console.WriteLine("Goodbye");
                        break;
                    case 1:
                        Console.WriteLine();
                        wnfa.Start();
                        break;
                    case 2:
                        Console.WriteLine();
                        fpnwa.Start();
                        break;
                    case 3:
                        Console.WriteLine();
                        cc.Start();
                        break;
                    case 4:
                        Console.WriteLine();
                        ws.Start();
                        break;
                    case 5:
                        tc.Start();
                        break;
                }

            }
        }

        private void InitializeVariables()
        {
            wnfa = new WholeNumbersForAdd();
            fpnwa = new FloatingPointsNumberWhileAdd();
            cc = new CurrencyConverter();
            ws = new WorkingSchedule();
            tc = new TemperatureConverter();
        }

        private void InitializeWindow()
        {
            Console.Title = "Selection and Iteration Algorithms";
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine("                 MAIN MENU                               ");
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine();
            Console.WriteLine("     Whole Numbers with For                  :1          ");
            Console.WriteLine("     Floating Point Numbers with While       :2          ");
            Console.WriteLine("     Currency Converter with Do-While        :3          ");
            Console.WriteLine("     Work Schedule                           :4          ");
            Console.WriteLine("     Temperature Converter, C/F or F/C       :5          ");
            Console.WriteLine("     Exit the Program                        :0          ");
            Console.WriteLine("---------------------------------------------------------");
        }
    }
}
