using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*
 * Robin Johnsson
 * 2017-10-10
 * */

namespace Assignment3
{
    public partial class MainForm : Form
    {
        private FuelCalculator fuelCalc = new FuelCalculator();
        private BMICalculator bmiCalc = new BMICalculator();
        public MainForm()
        {
            InitializeComponent();
            //My code starts here
            InitializeGUI();
        }

        private void InitializeGUI()
        {
            bmiSystemPicker.Items.Add("Metric");
            bmiSystemPicker.Items.Add("US");
            bmiExplain.Text = "Normal BMI is between 18.5 and 24.9";
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }

        private void FuelCalculate_Click(object sender, EventArgs e)
        {
            bool ok = ReadFuelInput();
            if (ok)
            {
                fuelResults0.Text = fuelCalc.CalculateKmLiter().ToString("f2");
                fuelResults1.Text = fuelCalc.CalculateLiterKM().ToString("f2");
                fuelResults2.Text = fuelCalc.CalculateLiterMile().ToString("f2");
                fuelResults3.Text = fuelCalc.CalculateLiterMil().ToString("f2");
                fuelResults4.Text = fuelCalc.CalculateKMCost().ToString("f2"); ;
            }
            else {
                MessageBox.Show("Incorrect Input", "ERROR");
            }
        }

        private bool ReadFuelInput()
        {
            bool result = true;
            double i;
            if (!double.TryParse(fuelPreviousOdoInput.Text.ToString(), out i) || i<0)
            {
                result = false;
            }
            else
            {
                fuelCalc.SetPreviousOdo(i);
            }
            if ((!double.TryParse(fuelCurrentOdoInput.Text.ToString(), out i)) || i < fuelCalc.GetPreviousOdo() || i < 0)
            {
                result = false;
            }
            else {
                fuelCalc.SetCurrentOdo(i);
            }
            if (!double.TryParse(fuelCurrentFuelInput.Text.ToString(), out i) || i < 0)
            {
                result = false;
            }
            else
            {
                fuelCalc.SetCurrentFuel(i);
            }
            if (!double.TryParse(fuelPriceInput.Text.ToString(), out i) || i < 0)
            {
                result = false;
            }
            else
            {
                fuelCalc.SetFuelPrice(i);
            }
            return result;
        }

        private void BmiResults_Click(object sender, EventArgs e)
        {
            bool ok = ReadBMIInput();
            if (ok) {
                bmiResultsBMI.Text = "" + bmiCalc.CalculateBMI().ToString("f2");
                bmiResultsCategory.Text = bmiCalc.GetDescription();
                bmiResultContainer.Text = bmiCalc.GetName();
            }

            else
            {
                MessageBox.Show("Incorrect Input", "ERROR");
            }
        }

        private bool ReadBMIInput()
        {
            bool result = true;
            double i;
            if (bmiNameInput.Text.ToString() == "")
            {
                bmiCalc.SetName("NoName");
            }
            else {
                bmiCalc.SetName(bmiNameInput.Text.ToString());
            }
            if (!double.TryParse(bmiHeightInput.Text.ToString(), out i) || i < 0)
            {
                result = false;
            }
            else
            {
                bmiCalc.SetHeight(i);
            }
            if (!double.TryParse(bmiWeightInput.Text.ToString(), out i) || i < 0)
            {
                result = false;
            }
            else
            {
                bmiCalc.SetWeight(i);
            }
            if (bmiSystemPicker.Text == "")
            {
                result = false;
            }
            else {
                bmiCalc.SetSystem(bmiSystemPicker.Text == "Metric");
            }
            return result;
        }

        private void BmiSystemPicker_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (bmiSystemPicker.Text.ToString() == "Metric")
            {
                bmiHeight.Text = "Height (cm)";
                bmiWeight.Text = "Weight (kg)";
            }
            else {
                bmiHeight.Text = "Height (inch)";
                bmiWeight.Text = "Weight (lb)";
            }
        }
    }
}
