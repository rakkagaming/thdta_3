namespace Assignment3
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.fuelCalculatorContainer = new System.Windows.Forms.GroupBox();
            this.fuelCalculate = new System.Windows.Forms.Button();
            this.fuelPriceInput = new System.Windows.Forms.TextBox();
            this.fuelCurrentFuelInput = new System.Windows.Forms.TextBox();
            this.fuelPreviousOdoInput = new System.Windows.Forms.TextBox();
            this.fuelCurrentOdoInput = new System.Windows.Forms.TextBox();
            this.fuelCost = new System.Windows.Forms.Label();
            this.fuelCurrentFuel = new System.Windows.Forms.Label();
            this.fuelOdometerPrevious = new System.Windows.Forms.Label();
            this.fuelOdometerCurrent = new System.Windows.Forms.Label();
            this.fuelResultContainer = new System.Windows.Forms.GroupBox();
            this.fuelResults4 = new System.Windows.Forms.Label();
            this.fuelResultsCostKM = new System.Windows.Forms.Label();
            this.fuelResults3 = new System.Windows.Forms.Label();
            this.fuelResults2 = new System.Windows.Forms.Label();
            this.fuelResults1 = new System.Windows.Forms.Label();
            this.fuelResults0 = new System.Windows.Forms.Label();
            this.fuelResultsLiterMil = new System.Windows.Forms.Label();
            this.fuelResultsLiterMile = new System.Windows.Forms.Label();
            this.fuelResultsLiterKM = new System.Windows.Forms.Label();
            this.fuelResultsKMLiter = new System.Windows.Forms.Label();
            this.bmiCalculatorContainer = new System.Windows.Forms.GroupBox();
            this.bmiCalculate = new System.Windows.Forms.Button();
            this.bmiSystemPicker = new System.Windows.Forms.ComboBox();
            this.bmiWeightInput = new System.Windows.Forms.TextBox();
            this.bmiHeightInput = new System.Windows.Forms.TextBox();
            this.bmiNameInput = new System.Windows.Forms.TextBox();
            this.bmiWeight = new System.Windows.Forms.Label();
            this.bmiHeight = new System.Windows.Forms.Label();
            this.bmiName = new System.Windows.Forms.Label();
            this.bmiResultContainer = new System.Windows.Forms.GroupBox();
            this.bmiExplain = new System.Windows.Forms.Label();
            this.bmiResultsCategory = new System.Windows.Forms.Label();
            this.bmiResultsBMI = new System.Windows.Forms.Label();
            this.bmiGroup = new System.Windows.Forms.Label();
            this.bmiResultsBMItxt = new System.Windows.Forms.Label();
            this.fuelCalculatorContainer.SuspendLayout();
            this.fuelResultContainer.SuspendLayout();
            this.bmiCalculatorContainer.SuspendLayout();
            this.bmiResultContainer.SuspendLayout();
            this.SuspendLayout();
            // 
            // fuelCalculatorContainer
            // 
            this.fuelCalculatorContainer.Controls.Add(this.fuelCalculate);
            this.fuelCalculatorContainer.Controls.Add(this.fuelPriceInput);
            this.fuelCalculatorContainer.Controls.Add(this.fuelCurrentFuelInput);
            this.fuelCalculatorContainer.Controls.Add(this.fuelPreviousOdoInput);
            this.fuelCalculatorContainer.Controls.Add(this.fuelCurrentOdoInput);
            this.fuelCalculatorContainer.Controls.Add(this.fuelCost);
            this.fuelCalculatorContainer.Controls.Add(this.fuelCurrentFuel);
            this.fuelCalculatorContainer.Controls.Add(this.fuelOdometerPrevious);
            this.fuelCalculatorContainer.Controls.Add(this.fuelOdometerCurrent);
            this.fuelCalculatorContainer.Controls.Add(this.fuelResultContainer);
            this.fuelCalculatorContainer.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fuelCalculatorContainer.Location = new System.Drawing.Point(12, 12);
            this.fuelCalculatorContainer.Name = "fuelCalculatorContainer";
            this.fuelCalculatorContainer.Size = new System.Drawing.Size(275, 412);
            this.fuelCalculatorContainer.TabIndex = 0;
            this.fuelCalculatorContainer.TabStop = false;
            this.fuelCalculatorContainer.Text = "Fuel";
            // 
            // fuelCalculate
            // 
            this.fuelCalculate.Location = new System.Drawing.Point(99, 172);
            this.fuelCalculate.Name = "fuelCalculate";
            this.fuelCalculate.Size = new System.Drawing.Size(75, 23);
            this.fuelCalculate.TabIndex = 9;
            this.fuelCalculate.Text = "Calculate";
            this.fuelCalculate.UseVisualStyleBackColor = true;
            this.fuelCalculate.Click += new System.EventHandler(this.FuelCalculate_Click);
            // 
            // fuelPriceInput
            // 
            this.fuelPriceInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F);
            this.fuelPriceInput.Location = new System.Drawing.Point(203, 122);
            this.fuelPriceInput.Name = "fuelPriceInput";
            this.fuelPriceInput.Size = new System.Drawing.Size(66, 20);
            this.fuelPriceInput.TabIndex = 8;
            // 
            // fuelCurrentFuelInput
            // 
            this.fuelCurrentFuelInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F);
            this.fuelCurrentFuelInput.Location = new System.Drawing.Point(203, 90);
            this.fuelCurrentFuelInput.Name = "fuelCurrentFuelInput";
            this.fuelCurrentFuelInput.Size = new System.Drawing.Size(66, 20);
            this.fuelCurrentFuelInput.TabIndex = 7;
            // 
            // fuelPreviousOdoInput
            // 
            this.fuelPreviousOdoInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F);
            this.fuelPreviousOdoInput.Location = new System.Drawing.Point(203, 57);
            this.fuelPreviousOdoInput.Name = "fuelPreviousOdoInput";
            this.fuelPreviousOdoInput.Size = new System.Drawing.Size(66, 20);
            this.fuelPreviousOdoInput.TabIndex = 6;
            // 
            // fuelCurrentOdoInput
            // 
            this.fuelCurrentOdoInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F);
            this.fuelCurrentOdoInput.Location = new System.Drawing.Point(203, 24);
            this.fuelCurrentOdoInput.Name = "fuelCurrentOdoInput";
            this.fuelCurrentOdoInput.Size = new System.Drawing.Size(66, 20);
            this.fuelCurrentOdoInput.TabIndex = 5;
            // 
            // fuelCost
            // 
            this.fuelCost.AutoSize = true;
            this.fuelCost.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fuelCost.Location = new System.Drawing.Point(8, 120);
            this.fuelCost.Margin = new System.Windows.Forms.Padding(5);
            this.fuelCost.Name = "fuelCost";
            this.fuelCost.Padding = new System.Windows.Forms.Padding(5);
            this.fuelCost.Size = new System.Drawing.Size(154, 25);
            this.fuelCost.TabIndex = 4;
            this.fuelCost.Text = "Current fuel price per liter";
            // 
            // fuelCurrentFuel
            // 
            this.fuelCurrentFuel.AutoSize = true;
            this.fuelCurrentFuel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fuelCurrentFuel.Location = new System.Drawing.Point(8, 87);
            this.fuelCurrentFuel.Margin = new System.Windows.Forms.Padding(5);
            this.fuelCurrentFuel.Name = "fuelCurrentFuel";
            this.fuelCurrentFuel.Padding = new System.Windows.Forms.Padding(5);
            this.fuelCurrentFuel.Size = new System.Drawing.Size(196, 25);
            this.fuelCurrentFuel.TabIndex = 3;
            this.fuelCurrentFuel.Text = "Current amount of fuel tanked (L)";
            // 
            // fuelOdometerPrevious
            // 
            this.fuelOdometerPrevious.AutoSize = true;
            this.fuelOdometerPrevious.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fuelOdometerPrevious.Location = new System.Drawing.Point(8, 54);
            this.fuelOdometerPrevious.Margin = new System.Windows.Forms.Padding(5);
            this.fuelOdometerPrevious.Name = "fuelOdometerPrevious";
            this.fuelOdometerPrevious.Padding = new System.Windows.Forms.Padding(5);
            this.fuelOdometerPrevious.Size = new System.Drawing.Size(193, 25);
            this.fuelOdometerPrevious.TabIndex = 2;
            this.fuelOdometerPrevious.Text = "Previous odometer reading (km)";
            // 
            // fuelOdometerCurrent
            // 
            this.fuelOdometerCurrent.AutoSize = true;
            this.fuelOdometerCurrent.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fuelOdometerCurrent.Location = new System.Drawing.Point(8, 21);
            this.fuelOdometerCurrent.Margin = new System.Windows.Forms.Padding(5);
            this.fuelOdometerCurrent.Name = "fuelOdometerCurrent";
            this.fuelOdometerCurrent.Padding = new System.Windows.Forms.Padding(5);
            this.fuelOdometerCurrent.Size = new System.Drawing.Size(186, 25);
            this.fuelOdometerCurrent.TabIndex = 1;
            this.fuelOdometerCurrent.Text = "Current odometer reading (km)";
            // 
            // fuelResultContainer
            // 
            this.fuelResultContainer.Controls.Add(this.fuelResults4);
            this.fuelResultContainer.Controls.Add(this.fuelResultsCostKM);
            this.fuelResultContainer.Controls.Add(this.fuelResults3);
            this.fuelResultContainer.Controls.Add(this.fuelResults2);
            this.fuelResultContainer.Controls.Add(this.fuelResults1);
            this.fuelResultContainer.Controls.Add(this.fuelResults0);
            this.fuelResultContainer.Controls.Add(this.fuelResultsLiterMil);
            this.fuelResultContainer.Controls.Add(this.fuelResultsLiterMile);
            this.fuelResultContainer.Controls.Add(this.fuelResultsLiterKM);
            this.fuelResultContainer.Controls.Add(this.fuelResultsKMLiter);
            this.fuelResultContainer.Location = new System.Drawing.Point(6, 201);
            this.fuelResultContainer.Name = "fuelResultContainer";
            this.fuelResultContainer.Size = new System.Drawing.Size(263, 205);
            this.fuelResultContainer.TabIndex = 0;
            this.fuelResultContainer.TabStop = false;
            this.fuelResultContainer.Text = "Results";
            // 
            // fuelResults4
            // 
            this.fuelResults4.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.fuelResults4.Location = new System.Drawing.Point(197, 143);
            this.fuelResults4.Name = "fuelResults4";
            this.fuelResults4.Size = new System.Drawing.Size(60, 19);
            this.fuelResults4.TabIndex = 10;
            // 
            // fuelResultsCostKM
            // 
            this.fuelResultsCostKM.AutoSize = true;
            this.fuelResultsCostKM.Location = new System.Drawing.Point(6, 139);
            this.fuelResultsCostKM.Margin = new System.Windows.Forms.Padding(3);
            this.fuelResultsCostKM.Name = "fuelResultsCostKM";
            this.fuelResultsCostKM.Padding = new System.Windows.Forms.Padding(3);
            this.fuelResultsCostKM.Size = new System.Drawing.Size(128, 23);
            this.fuelResultsCostKM.TabIndex = 9;
            this.fuelResultsCostKM.Text = "Cost per kilometer";
            // 
            // fuelResults3
            // 
            this.fuelResults3.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.fuelResults3.Location = new System.Drawing.Point(197, 114);
            this.fuelResults3.Name = "fuelResults3";
            this.fuelResults3.Size = new System.Drawing.Size(60, 19);
            this.fuelResults3.TabIndex = 8;
            // 
            // fuelResults2
            // 
            this.fuelResults2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.fuelResults2.Location = new System.Drawing.Point(197, 85);
            this.fuelResults2.Name = "fuelResults2";
            this.fuelResults2.Size = new System.Drawing.Size(60, 19);
            this.fuelResults2.TabIndex = 7;
            // 
            // fuelResults1
            // 
            this.fuelResults1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.fuelResults1.Location = new System.Drawing.Point(197, 56);
            this.fuelResults1.Name = "fuelResults1";
            this.fuelResults1.Size = new System.Drawing.Size(60, 19);
            this.fuelResults1.TabIndex = 6;
            // 
            // fuelResults0
            // 
            this.fuelResults0.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.fuelResults0.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.fuelResults0.Location = new System.Drawing.Point(197, 27);
            this.fuelResults0.Name = "fuelResults0";
            this.fuelResults0.Size = new System.Drawing.Size(60, 19);
            this.fuelResults0.TabIndex = 5;
            // 
            // fuelResultsLiterMil
            // 
            this.fuelResultsLiterMil.AutoSize = true;
            this.fuelResultsLiterMil.Location = new System.Drawing.Point(6, 110);
            this.fuelResultsLiterMil.Margin = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterMil.Name = "fuelResultsLiterMil";
            this.fuelResultsLiterMil.Padding = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterMil.Size = new System.Drawing.Size(183, 23);
            this.fuelResultsLiterMil.TabIndex = 3;
            this.fuelResultsLiterMil.Text = "Fuel consumption (liter/mil)";
            // 
            // fuelResultsLiterMile
            // 
            this.fuelResultsLiterMile.AutoSize = true;
            this.fuelResultsLiterMile.Location = new System.Drawing.Point(6, 81);
            this.fuelResultsLiterMile.Margin = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterMile.Name = "fuelResultsLiterMile";
            this.fuelResultsLiterMile.Padding = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterMile.Size = new System.Drawing.Size(191, 23);
            this.fuelResultsLiterMile.TabIndex = 2;
            this.fuelResultsLiterMile.Text = "Fuel consumption (liter/mile)";
            // 
            // fuelResultsLiterKM
            // 
            this.fuelResultsLiterKM.AutoSize = true;
            this.fuelResultsLiterKM.Location = new System.Drawing.Point(6, 52);
            this.fuelResultsLiterKM.Margin = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterKM.Name = "fuelResultsLiterKM";
            this.fuelResultsLiterKM.Padding = new System.Windows.Forms.Padding(3);
            this.fuelResultsLiterKM.Size = new System.Drawing.Size(184, 23);
            this.fuelResultsLiterKM.TabIndex = 1;
            this.fuelResultsLiterKM.Text = "Fuel consumption (liter/km)";
            // 
            // fuelResultsKMLiter
            // 
            this.fuelResultsKMLiter.AutoSize = true;
            this.fuelResultsKMLiter.Location = new System.Drawing.Point(6, 23);
            this.fuelResultsKMLiter.Margin = new System.Windows.Forms.Padding(3);
            this.fuelResultsKMLiter.Name = "fuelResultsKMLiter";
            this.fuelResultsKMLiter.Padding = new System.Windows.Forms.Padding(3);
            this.fuelResultsKMLiter.Size = new System.Drawing.Size(184, 23);
            this.fuelResultsKMLiter.TabIndex = 0;
            this.fuelResultsKMLiter.Text = "Fuel consumption (km/liter)";
            // 
            // bmiCalculatorContainer
            // 
            this.bmiCalculatorContainer.Controls.Add(this.bmiCalculate);
            this.bmiCalculatorContainer.Controls.Add(this.bmiSystemPicker);
            this.bmiCalculatorContainer.Controls.Add(this.bmiWeightInput);
            this.bmiCalculatorContainer.Controls.Add(this.bmiHeightInput);
            this.bmiCalculatorContainer.Controls.Add(this.bmiNameInput);
            this.bmiCalculatorContainer.Controls.Add(this.bmiWeight);
            this.bmiCalculatorContainer.Controls.Add(this.bmiHeight);
            this.bmiCalculatorContainer.Controls.Add(this.bmiName);
            this.bmiCalculatorContainer.Controls.Add(this.bmiResultContainer);
            this.bmiCalculatorContainer.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.bmiCalculatorContainer.Location = new System.Drawing.Point(293, 12);
            this.bmiCalculatorContainer.Name = "bmiCalculatorContainer";
            this.bmiCalculatorContainer.Size = new System.Drawing.Size(275, 412);
            this.bmiCalculatorContainer.TabIndex = 1;
            this.bmiCalculatorContainer.TabStop = false;
            this.bmiCalculatorContainer.Text = "BMI";
            // 
            // bmiCalculate
            // 
            this.bmiCalculate.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.bmiCalculate.Location = new System.Drawing.Point(95, 172);
            this.bmiCalculate.Name = "bmiCalculate";
            this.bmiCalculate.Size = new System.Drawing.Size(75, 23);
            this.bmiCalculate.TabIndex = 8;
            this.bmiCalculate.Text = "Calculate";
            this.bmiCalculate.UseVisualStyleBackColor = true;
            this.bmiCalculate.Click += new System.EventHandler(this.BmiResults_Click);
            // 
            // bmiSystemPicker
            // 
            this.bmiSystemPicker.FormattingEnabled = true;
            this.bmiSystemPicker.Location = new System.Drawing.Point(11, 124);
            this.bmiSystemPicker.Name = "bmiSystemPicker";
            this.bmiSystemPicker.Size = new System.Drawing.Size(121, 24);
            this.bmiSystemPicker.TabIndex = 7;
            this.bmiSystemPicker.SelectedIndexChanged += new System.EventHandler(this.BmiSystemPicker_SelectedIndexChanged);
            // 
            // bmiWeightInput
            // 
            this.bmiWeightInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiWeightInput.Location = new System.Drawing.Point(169, 91);
            this.bmiWeightInput.Name = "bmiWeightInput";
            this.bmiWeightInput.Size = new System.Drawing.Size(100, 21);
            this.bmiWeightInput.TabIndex = 6;
            // 
            // bmiHeightInput
            // 
            this.bmiHeightInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiHeightInput.Location = new System.Drawing.Point(169, 56);
            this.bmiHeightInput.Name = "bmiHeightInput";
            this.bmiHeightInput.Size = new System.Drawing.Size(100, 21);
            this.bmiHeightInput.TabIndex = 5;
            // 
            // bmiNameInput
            // 
            this.bmiNameInput.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiNameInput.Location = new System.Drawing.Point(169, 24);
            this.bmiNameInput.Name = "bmiNameInput";
            this.bmiNameInput.Size = new System.Drawing.Size(100, 21);
            this.bmiNameInput.TabIndex = 4;
            // 
            // bmiWeight
            // 
            this.bmiWeight.AutoSize = true;
            this.bmiWeight.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiWeight.Location = new System.Drawing.Point(8, 91);
            this.bmiWeight.Margin = new System.Windows.Forms.Padding(5);
            this.bmiWeight.Name = "bmiWeight";
            this.bmiWeight.Padding = new System.Windows.Forms.Padding(5);
            this.bmiWeight.Size = new System.Drawing.Size(55, 25);
            this.bmiWeight.TabIndex = 3;
            this.bmiWeight.Text = "Weight";
            // 
            // bmiHeight
            // 
            this.bmiHeight.AutoSize = true;
            this.bmiHeight.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiHeight.Location = new System.Drawing.Point(8, 56);
            this.bmiHeight.Margin = new System.Windows.Forms.Padding(5);
            this.bmiHeight.Name = "bmiHeight";
            this.bmiHeight.Padding = new System.Windows.Forms.Padding(5);
            this.bmiHeight.Size = new System.Drawing.Size(53, 25);
            this.bmiHeight.TabIndex = 2;
            this.bmiHeight.Text = "Height";
            // 
            // bmiName
            // 
            this.bmiName.AutoSize = true;
            this.bmiName.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F);
            this.bmiName.Location = new System.Drawing.Point(8, 21);
            this.bmiName.Margin = new System.Windows.Forms.Padding(5);
            this.bmiName.Name = "bmiName";
            this.bmiName.Padding = new System.Windows.Forms.Padding(5);
            this.bmiName.Size = new System.Drawing.Size(77, 25);
            this.bmiName.TabIndex = 1;
            this.bmiName.Text = "Your name";
            // 
            // bmiResultContainer
            // 
            this.bmiResultContainer.Controls.Add(this.bmiExplain);
            this.bmiResultContainer.Controls.Add(this.bmiResultsCategory);
            this.bmiResultContainer.Controls.Add(this.bmiResultsBMI);
            this.bmiResultContainer.Controls.Add(this.bmiGroup);
            this.bmiResultContainer.Controls.Add(this.bmiResultsBMItxt);
            this.bmiResultContainer.Location = new System.Drawing.Point(6, 201);
            this.bmiResultContainer.Name = "bmiResultContainer";
            this.bmiResultContainer.Size = new System.Drawing.Size(263, 205);
            this.bmiResultContainer.TabIndex = 0;
            this.bmiResultContainer.TabStop = false;
            this.bmiResultContainer.Text = "Results for ";
            // 
            // bmiExplain
            // 
            this.bmiExplain.AutoSize = true;
            this.bmiExplain.Location = new System.Drawing.Point(8, 114);
            this.bmiExplain.Margin = new System.Windows.Forms.Padding(5);
            this.bmiExplain.Name = "bmiExplain";
            this.bmiExplain.Padding = new System.Windows.Forms.Padding(5);
            this.bmiExplain.Size = new System.Drawing.Size(113, 27);
            this.bmiExplain.TabIndex = 13;
            this.bmiExplain.Text = "temporary Text";
            // 
            // bmiResultsCategory
            // 
            this.bmiResultsCategory.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.bmiResultsCategory.Location = new System.Drawing.Point(132, 61);
            this.bmiResultsCategory.Margin = new System.Windows.Forms.Padding(5);
            this.bmiResultsCategory.Name = "bmiResultsCategory";
            this.bmiResultsCategory.Padding = new System.Windows.Forms.Padding(5);
            this.bmiResultsCategory.Size = new System.Drawing.Size(123, 27);
            this.bmiResultsCategory.TabIndex = 12;
            // 
            // bmiResultsBMI
            // 
            this.bmiResultsBMI.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.bmiResultsBMI.Location = new System.Drawing.Point(132, 24);
            this.bmiResultsBMI.Margin = new System.Windows.Forms.Padding(5);
            this.bmiResultsBMI.Name = "bmiResultsBMI";
            this.bmiResultsBMI.Padding = new System.Windows.Forms.Padding(5);
            this.bmiResultsBMI.Size = new System.Drawing.Size(123, 27);
            this.bmiResultsBMI.TabIndex = 11;
            // 
            // bmiGroup
            // 
            this.bmiGroup.AutoSize = true;
            this.bmiGroup.Location = new System.Drawing.Point(8, 61);
            this.bmiGroup.Margin = new System.Windows.Forms.Padding(5);
            this.bmiGroup.Name = "bmiGroup";
            this.bmiGroup.Padding = new System.Windows.Forms.Padding(5);
            this.bmiGroup.Size = new System.Drawing.Size(123, 27);
            this.bmiGroup.TabIndex = 10;
            this.bmiGroup.Text = "Weight Category";
            // 
            // bmiResultsBMItxt
            // 
            this.bmiResultsBMItxt.AutoSize = true;
            this.bmiResultsBMItxt.Location = new System.Drawing.Point(8, 24);
            this.bmiResultsBMItxt.Margin = new System.Windows.Forms.Padding(5);
            this.bmiResultsBMItxt.Name = "bmiResultsBMItxt";
            this.bmiResultsBMItxt.Padding = new System.Windows.Forms.Padding(5);
            this.bmiResultsBMItxt.Size = new System.Drawing.Size(75, 27);
            this.bmiResultsBMItxt.TabIndex = 9;
            this.bmiResultsBMItxt.Text = "Your BMI";
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(577, 436);
            this.Controls.Add(this.bmiCalculatorContainer);
            this.Controls.Add(this.fuelCalculatorContainer);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Assignment3";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.fuelCalculatorContainer.ResumeLayout(false);
            this.fuelCalculatorContainer.PerformLayout();
            this.fuelResultContainer.ResumeLayout(false);
            this.fuelResultContainer.PerformLayout();
            this.bmiCalculatorContainer.ResumeLayout(false);
            this.bmiCalculatorContainer.PerformLayout();
            this.bmiResultContainer.ResumeLayout(false);
            this.bmiResultContainer.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox fuelCalculatorContainer;
        private System.Windows.Forms.GroupBox bmiCalculatorContainer;
        private System.Windows.Forms.GroupBox fuelResultContainer;
        private System.Windows.Forms.GroupBox bmiResultContainer;
        private System.Windows.Forms.Label fuelCost;
        private System.Windows.Forms.Label fuelCurrentFuel;
        private System.Windows.Forms.Label fuelOdometerPrevious;
        private System.Windows.Forms.Label fuelOdometerCurrent;
        private System.Windows.Forms.TextBox fuelCurrentFuelInput;
        private System.Windows.Forms.TextBox fuelPreviousOdoInput;
        private System.Windows.Forms.TextBox fuelCurrentOdoInput;
        private System.Windows.Forms.TextBox fuelPriceInput;
        private System.Windows.Forms.Button fuelCalculate;
        private System.Windows.Forms.Label fuelResultsLiterMil;
        private System.Windows.Forms.Label fuelResultsLiterMile;
        private System.Windows.Forms.Label fuelResultsLiterKM;
        private System.Windows.Forms.Label fuelResultsKMLiter;
        private System.Windows.Forms.Label fuelResults3;
        private System.Windows.Forms.Label fuelResults2;
        private System.Windows.Forms.Label fuelResults1;
        private System.Windows.Forms.Label fuelResults0;
        private System.Windows.Forms.Label fuelResultsCostKM;
        private System.Windows.Forms.Label fuelResults4;
        private System.Windows.Forms.Label bmiWeight;
        private System.Windows.Forms.Label bmiHeight;
        private System.Windows.Forms.Label bmiName;
        private System.Windows.Forms.ComboBox bmiSystemPicker;
        private System.Windows.Forms.TextBox bmiWeightInput;
        private System.Windows.Forms.TextBox bmiHeightInput;
        private System.Windows.Forms.TextBox bmiNameInput;
        private System.Windows.Forms.Button bmiCalculate;
        private System.Windows.Forms.Label bmiResultsBMItxt;
        private System.Windows.Forms.Label bmiResultsCategory;
        private System.Windows.Forms.Label bmiResultsBMI;
        private System.Windows.Forms.Label bmiGroup;
        private System.Windows.Forms.Label bmiExplain;
    }
}

