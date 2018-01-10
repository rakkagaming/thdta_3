using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*
 
     * By: Robin Johnsson, 2017-11-09
     * If I could have chosen I would have written this whole assignment differently.
     * I would have had more in the constructor ( I added the cost as a parameter) even tho its not in the description.
 */

namespace Assignment4
{
    class Party
    {
        private double price;
        private String[] guestList;

        public Party(int size, double cost) {
            guestList = new String[size];
            price = cost;
        }

        public int AddGuest(String firstName, String surname, int position) {
            if (position>=guestList.Length) { return -1; }
            String name = "";
            if (string.IsNullOrEmpty(surname))
            {
                name = "-, ";
            }
            else
            {
                name = surname.ToUpper() + ", ";
            }
            if (string.IsNullOrEmpty(firstName))
            {
                name += "-";
            }
            else
            {
                name += firstName;
            }
            guestList[position] = name;
            return (position + 1);
        }

        public int Delete(int position, int nrOfGuests) {
            for (int i = position; i < guestList.Length - 1; i++ ) {
                guestList[i] = guestList[i + 1];
            }
            guestList[guestList.Length-1] = "";
            return (nrOfGuests-1);
        }

        public String[] GetGuests()
        {
            int size = NumOfGuests();

            if (size <= 0)  return null;

            string[] tempList = new string[size];

            for (int i = 0, j = 0; i < guestList.Length; i++) {
                if (!string.IsNullOrEmpty(guestList[i])) {
                    tempList[j++] = guestList[i];
                }
            }

            return tempList;
        }

        public double Cost {
            get { return price; }
            set {
                if (value>=0) {
                    price = value;
                }
            }
        }

        public int NumOfGuests() {
            int x = 0;
            for (int i = 0; i < guestList.Length; i++) {
                if (!string.IsNullOrEmpty(guestList[i])) {
                    x++;
                }
            }
            return x;
        }
    }
}
