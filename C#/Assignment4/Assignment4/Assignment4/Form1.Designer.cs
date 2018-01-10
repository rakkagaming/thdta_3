namespace Assignment4
{
    partial class Form1
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
            this.boxNewParty = new System.Windows.Forms.GroupBox();
            this.btnCreateList = new System.Windows.Forms.Button();
            this.txtInputPrice = new System.Windows.Forms.TextBox();
            this.txtInputNrGuests = new System.Windows.Forms.TextBox();
            this.txtPriceGuest = new System.Windows.Forms.Label();
            this.txtGuests = new System.Windows.Forms.Label();
            this.boxAddGuest = new System.Windows.Forms.GroupBox();
            this.btnAddGuest = new System.Windows.Forms.Button();
            this.txtInputSurname = new System.Windows.Forms.TextBox();
            this.txtInputFirstName = new System.Windows.Forms.TextBox();
            this.txtSurname = new System.Windows.Forms.Label();
            this.txtFirstName = new System.Windows.Forms.Label();
            this.txtTotalCost = new System.Windows.Forms.Label();
            this.txtGuestSize = new System.Windows.Forms.Label();
            this.txtCost = new System.Windows.Forms.Label();
            this.txtNrGuests = new System.Windows.Forms.Label();
            this.txtGuestList = new System.Windows.Forms.Label();
            this.btnDelete = new System.Windows.Forms.Button();
            this.listGuests = new System.Windows.Forms.ListBox();
            this.boxNewParty.SuspendLayout();
            this.boxAddGuest.SuspendLayout();
            this.SuspendLayout();
            // 
            // boxNewParty
            // 
            this.boxNewParty.Controls.Add(this.btnCreateList);
            this.boxNewParty.Controls.Add(this.txtInputPrice);
            this.boxNewParty.Controls.Add(this.txtInputNrGuests);
            this.boxNewParty.Controls.Add(this.txtPriceGuest);
            this.boxNewParty.Controls.Add(this.txtGuests);
            this.boxNewParty.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.boxNewParty.Location = new System.Drawing.Point(13, 13);
            this.boxNewParty.Name = "boxNewParty";
            this.boxNewParty.Size = new System.Drawing.Size(270, 133);
            this.boxNewParty.TabIndex = 0;
            this.boxNewParty.TabStop = false;
            this.boxNewParty.Text = "New Party";
            // 
            // btnCreateList
            // 
            this.btnCreateList.Location = new System.Drawing.Point(91, 104);
            this.btnCreateList.Name = "btnCreateList";
            this.btnCreateList.Size = new System.Drawing.Size(83, 23);
            this.btnCreateList.TabIndex = 4;
            this.btnCreateList.Text = "Create List";
            this.btnCreateList.UseVisualStyleBackColor = true;
            this.btnCreateList.Click += new System.EventHandler(this.btnCreateList_Click);
            // 
            // txtInputPrice
            // 
            this.txtInputPrice.Location = new System.Drawing.Point(136, 75);
            this.txtInputPrice.Name = "txtInputPrice";
            this.txtInputPrice.Size = new System.Drawing.Size(128, 23);
            this.txtInputPrice.TabIndex = 3;
            // 
            // txtInputNrGuests
            // 
            this.txtInputNrGuests.Location = new System.Drawing.Point(136, 34);
            this.txtInputNrGuests.Name = "txtInputNrGuests";
            this.txtInputNrGuests.Size = new System.Drawing.Size(128, 23);
            this.txtInputNrGuests.TabIndex = 2;
            // 
            // txtPriceGuest
            // 
            this.txtPriceGuest.AutoSize = true;
            this.txtPriceGuest.Location = new System.Drawing.Point(7, 75);
            this.txtPriceGuest.Name = "txtPriceGuest";
            this.txtPriceGuest.Size = new System.Drawing.Size(104, 17);
            this.txtPriceGuest.TabIndex = 1;
            this.txtPriceGuest.Text = "Price per guest";
            // 
            // txtGuests
            // 
            this.txtGuests.AutoSize = true;
            this.txtGuests.Location = new System.Drawing.Point(7, 34);
            this.txtGuests.Name = "txtGuests";
            this.txtGuests.Size = new System.Drawing.Size(123, 17);
            this.txtGuests.TabIndex = 0;
            this.txtGuests.Text = "Number of Guests";
            // 
            // boxAddGuest
            // 
            this.boxAddGuest.Controls.Add(this.btnAddGuest);
            this.boxAddGuest.Controls.Add(this.txtInputSurname);
            this.boxAddGuest.Controls.Add(this.txtInputFirstName);
            this.boxAddGuest.Controls.Add(this.txtSurname);
            this.boxAddGuest.Controls.Add(this.txtFirstName);
            this.boxAddGuest.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.boxAddGuest.Location = new System.Drawing.Point(13, 153);
            this.boxAddGuest.Name = "boxAddGuest";
            this.boxAddGuest.Size = new System.Drawing.Size(270, 166);
            this.boxAddGuest.TabIndex = 1;
            this.boxAddGuest.TabStop = false;
            this.boxAddGuest.Text = "Invite Guest";
            // 
            // btnAddGuest
            // 
            this.btnAddGuest.Location = new System.Drawing.Point(99, 137);
            this.btnAddGuest.Name = "btnAddGuest";
            this.btnAddGuest.Size = new System.Drawing.Size(75, 23);
            this.btnAddGuest.TabIndex = 4;
            this.btnAddGuest.Text = "Add";
            this.btnAddGuest.UseVisualStyleBackColor = true;
            this.btnAddGuest.Click += new System.EventHandler(this.btnAddGuest_Click);
            // 
            // txtInputSurname
            // 
            this.txtInputSurname.Location = new System.Drawing.Point(99, 83);
            this.txtInputSurname.Name = "txtInputSurname";
            this.txtInputSurname.Size = new System.Drawing.Size(165, 23);
            this.txtInputSurname.TabIndex = 3;
            // 
            // txtInputFirstName
            // 
            this.txtInputFirstName.Location = new System.Drawing.Point(99, 45);
            this.txtInputFirstName.Name = "txtInputFirstName";
            this.txtInputFirstName.Size = new System.Drawing.Size(165, 23);
            this.txtInputFirstName.TabIndex = 2;
            // 
            // txtSurname
            // 
            this.txtSurname.AutoSize = true;
            this.txtSurname.Location = new System.Drawing.Point(16, 83);
            this.txtSurname.Name = "txtSurname";
            this.txtSurname.Size = new System.Drawing.Size(65, 17);
            this.txtSurname.TabIndex = 1;
            this.txtSurname.Text = "Surname";
            // 
            // txtFirstName
            // 
            this.txtFirstName.AutoSize = true;
            this.txtFirstName.Location = new System.Drawing.Point(13, 45);
            this.txtFirstName.Name = "txtFirstName";
            this.txtFirstName.Size = new System.Drawing.Size(76, 17);
            this.txtFirstName.TabIndex = 0;
            this.txtFirstName.Text = "First Name";
            // 
            // txtTotalCost
            // 
            this.txtTotalCost.AutoSize = true;
            this.txtTotalCost.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.txtTotalCost.Location = new System.Drawing.Point(13, 349);
            this.txtTotalCost.Name = "txtTotalCost";
            this.txtTotalCost.Size = new System.Drawing.Size(72, 17);
            this.txtTotalCost.TabIndex = 2;
            this.txtTotalCost.Text = "Total Cost";
            // 
            // txtGuestSize
            // 
            this.txtGuestSize.AutoSize = true;
            this.txtGuestSize.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.txtGuestSize.Location = new System.Drawing.Point(13, 385);
            this.txtGuestSize.Name = "txtGuestSize";
            this.txtGuestSize.Size = new System.Drawing.Size(123, 17);
            this.txtGuestSize.TabIndex = 3;
            this.txtGuestSize.Text = "Number of Guests";
            // 
            // txtCost
            // 
            this.txtCost.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.txtCost.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.txtCost.Location = new System.Drawing.Point(183, 343);
            this.txtCost.Name = "txtCost";
            this.txtCost.Size = new System.Drawing.Size(100, 23);
            this.txtCost.TabIndex = 4;
            this.txtCost.Text = "temp";
            this.txtCost.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtNrGuests
            // 
            this.txtNrGuests.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.txtNrGuests.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.txtNrGuests.Location = new System.Drawing.Point(183, 379);
            this.txtNrGuests.Name = "txtNrGuests";
            this.txtNrGuests.Size = new System.Drawing.Size(100, 23);
            this.txtNrGuests.TabIndex = 5;
            this.txtNrGuests.Text = "label2";
            this.txtNrGuests.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtGuestList
            // 
            this.txtGuestList.AutoSize = true;
            this.txtGuestList.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.txtGuestList.Location = new System.Drawing.Point(387, 13);
            this.txtGuestList.Name = "txtGuestList";
            this.txtGuestList.Size = new System.Drawing.Size(72, 17);
            this.txtGuestList.TabIndex = 6;
            this.txtGuestList.Text = "Guest List";
            // 
            // btnDelete
            // 
            this.btnDelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.btnDelete.Location = new System.Drawing.Point(494, 381);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(75, 23);
            this.btnDelete.TabIndex = 7;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // listGuests
            // 
            this.listGuests.FormattingEnabled = true;
            this.listGuests.Location = new System.Drawing.Point(289, 33);
            this.listGuests.Name = "listGuests";
            this.listGuests.Size = new System.Drawing.Size(280, 342);
            this.listGuests.TabIndex = 8;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 420);
            this.Controls.Add(this.listGuests);
            this.Controls.Add(this.btnDelete);
            this.Controls.Add(this.txtGuestList);
            this.Controls.Add(this.txtNrGuests);
            this.Controls.Add(this.txtCost);
            this.Controls.Add(this.txtGuestSize);
            this.Controls.Add(this.txtTotalCost);
            this.Controls.Add(this.boxAddGuest);
            this.Controls.Add(this.boxNewParty);
            this.Name = "Form1";
            this.Text = "Party Organizer";
            this.boxNewParty.ResumeLayout(false);
            this.boxNewParty.PerformLayout();
            this.boxAddGuest.ResumeLayout(false);
            this.boxAddGuest.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox boxNewParty;
        private System.Windows.Forms.Button btnCreateList;
        private System.Windows.Forms.TextBox txtInputPrice;
        private System.Windows.Forms.TextBox txtInputNrGuests;
        private System.Windows.Forms.Label txtPriceGuest;
        private System.Windows.Forms.Label txtGuests;
        private System.Windows.Forms.GroupBox boxAddGuest;
        private System.Windows.Forms.Button btnAddGuest;
        private System.Windows.Forms.TextBox txtInputSurname;
        private System.Windows.Forms.TextBox txtInputFirstName;
        private System.Windows.Forms.Label txtSurname;
        private System.Windows.Forms.Label txtFirstName;
        private System.Windows.Forms.Label txtTotalCost;
        private System.Windows.Forms.Label txtGuestSize;
        private System.Windows.Forms.Label txtCost;
        private System.Windows.Forms.Label txtNrGuests;
        private System.Windows.Forms.Label txtGuestList;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.ListBox listGuests;
    }
}

