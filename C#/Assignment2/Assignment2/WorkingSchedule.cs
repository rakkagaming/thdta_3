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
    /*
     * I chose to use a combination of different loops to complete this task. The Do-While in "Start()" makes it so that the menu is shown atleast once, 
     * and the Switch-Case inside of it handles what type of schedule I should show.
     * The two Schedules share a method, and the difference is just in from what Case that calls the method. 
     * Since we know what the interval of the weeks of work are, and the start of each one, we can send these along.
     */
    class WorkingSchedule
    {
        private int input, week, index, rate;
        private string weekNumberNice;
        public void Start() {
            InitializeSchedule();
            do
            {
                switch (input) {
                    case 1:
                        ShowWeeks(1,3);
                        break;
                    case 2:
                        ShowWeeks(6,5);
                        break;
                }
                ShowOptions();

            } while (RequestInput());
        }
        

        private void ShowWeeks(int weekStart, int cycle)
        {
            index = 0;
            week = weekStart;
            rate = cycle;


            while (week <=52)
            {
                if (week < 10)
                {
                    weekNumberNice =" " + week;
                }
                else {
                    weekNumberNice = "" + week;
                }
                
                Console.Write("         Week " + weekNumberNice);
                index++;
                if (index % 3 == 0) Console.WriteLine();

                week += rate;
            }
            Console.WriteLine();
            Console.WriteLine("---------------------------------------------------------");
            Console.WriteLine();
        }

        private bool RequestInput()
        {
            Console.Write("Your choice: ");
            input = Input.ReadIntInput();
            Console.WriteLine();
            if (input == 0) return false;
            return true;
        }

       

        private void ShowOptions()
        {
            Console.WriteLine("1 Show a list of the weekends to work");
            Console.WriteLine("2 show a list of the nights to work");
        }

        private void InitializeSchedule()
        {
            Console.WriteLine();
            Console.WriteLine("++++++++++++++++ Your Schedule Program ++++++++++++++++++");
            Console.WriteLine("Select which type of schedule you would like to see      ");
            Console.WriteLine();
            Console.WriteLine("---------------------------------------------------------");
        }
    }
}
