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
    class BMICalculator
    {

        private double height, weight, bmi;
        private bool metricSystem;
        private String name, description;

        public String GetName() {
            return name;
        }
        public double GetHeight() {
            return height;
        }
        public double GetWeight() {
            return weight;
        }
        public bool GetSystem() {
            return metricSystem;
        }

        public String GetDescription() {
            return description;
        }

        public void SetName(String name) {
            this.name = name;
        }
        public void SetHeight(double h) {
            height = h;
        }
        public void SetWeight(double w) {
            weight = w;
        }
        public void SetSystem(bool b) {
            metricSystem = b;
        }

        private void SetDesciption(double bmi)
        {
            description = "Underweight";
            if (bmi >= 18.5) {
                description = "Normal weight";
            }
            if (bmi >= 25) {
                description = "Overweight";
            }
            if (bmi >= 30) {
                description = "Obesity class I";
            }
            if (bmi >= 35)
            {
                description = "Obesity class II";
            }
            if (bmi >= 40) {
                description = "Obesity class III ";
            }
        }

        public double CalculateBMI()
        {
            if (metricSystem)
            {
                bmi = (weight / Math.Pow(height / 100, 2));
            }
            else
            {
                bmi = (703 * weight) / Math.Pow(height, 2);
            }
            SetDesciption(bmi);
            return bmi;
        }
    }
}
