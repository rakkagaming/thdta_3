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
    class TemperatureConverter
    {
        private int choice;
        public void Start() {
            do
            {
                switch (choice)
                {
                    case 1:
                        ShowTabel('C');
                        break;
                    case 2:
                        ShowTabel('F');
                        break;
                    default:
                        InitializeTemperature();
                        break;
                }

                Console.WriteLine();

            } while (RequestInput());
        }

        private void ShowTabel(char a) {
            switch (a) {
                case 'C':
                    for (double i = 0; i<=100;i++) {
                        if (i % 4 == 0) { Console.WriteLine(); }
                            Console.Write(TextSetter('C',i));
                        
                    }
                    break;
                case 'F':
                    for (double i = 0; i <= 100; i++)
                    {
                        if (i % 4 == 0) { Console.WriteLine(); }
                        Console.Write(TextSetter('F', i));

                    }
                    break;
            }
        }

        private String TextSetter(char type, double value) {
            String text0 = "", text1 = "";
            double converted;
            switch (type)
            {
                case 'C':
                    converted = 9.0 / 5.0 * value + 32.0;
                    text0 = value.ToString("n2") + "C";
                    text1 = converted.ToString("n2") + "F";
                    break;
                case 'F':
                    converted = 5.0 / 9.0 * (value - 32);
                    text0 = value.ToString("n2") + "F";
                    text1 = converted.ToString("n2") + "C";
                    break;
            }

            return (String.Format("{0,7}",text0) + " = " + String.Format("{0,7}", text1) + "    ");
        }

        private bool RequestInput()
        {
            Console.Write("Your choice: ");
            choice = Input.ReadIntInput();
            Console.WriteLine();
            if (choice == 0) return false;
            return true;
        }

        private void InitializeTemperature()
        {
            Console.WriteLine();
            Console.WriteLine("++++++++++++++ The Temperature Converter ++++++++++++++++");
            Console.WriteLine();
            Console.WriteLine("Write 0 to finish, 1 to display C too F, and 2 to display F too C!");
            Console.WriteLine("Make sure to use the correct decimal character!");
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine();
        }
    }
}
