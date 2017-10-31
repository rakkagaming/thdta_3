using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 * Robin Johnsson
 * 2017-10-10
 * */

namespace Assignment3
{
    class FuelCalculator
    {
        private double currentOdo, previousOdo, currentFuel, fuelPrice, distance,lPkm, kmPl;

        public double GetCurrentOdo() {
            return currentOdo;
        }

        public double GetPreviousOdo()
        {
            return previousOdo;
        }

        public double GetCurrentFuel()
        {
            return currentFuel;
        }

        public double GetFuelPrice()
        {
            return fuelPrice;
        }


        public void SetCurrentOdo(double odo) {
            if (odo >= 0) {
                currentOdo = odo;
            }
        }

        public void SetPreviousOdo(double odo) {
            if (odo >= 0) {
                previousOdo = odo;
            }
        }

        public void SetCurrentFuel(double fuel) {
            if (fuel >= 0)
            {
                currentFuel = fuel;
            }
        }

        internal double CalculateKMCost()
        {
            return (lPkm*fuelPrice);
        }

        public void SetFuelPrice(double price) {
            if (price >= 0)
            {
                fuelPrice = price;
            }
        }

        public bool CheckOdo() {
            return (currentOdo >= previousOdo);
        }

        public double CalculateLiterKM() {
            lPkm = currentFuel / distance;
            return lPkm;
        }

        public double CalculateKmLiter() {
            //Move first line outside
            distance = currentOdo - previousOdo;
            kmPl = distance / currentFuel;
            return kmPl;
        }

        public double CalculateLiterMile() {
            const double kmToMileFactor = 0.621371192;

            return (lPkm/kmToMileFactor);
        }

        public double CalculateLiterMil() {
            return (lPkm * 10);
        }


    }
}
