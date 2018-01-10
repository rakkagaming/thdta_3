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
 
     * By: Robin Johnsson, 2017-11-09
     * If I could have chosen I would have written this whole assignment differently.
     * I would have had more in the constructor ( I added the cost as a parameter) even tho its not in the description.
 */
namespace Assignment4
{
    public partial class Form1 : Form
    {
        Party party;
        public Form1()
        {
            InitializeComponent();
            InitializeGUI();
        }

        private void InitializeGUI()
        {
            txtCost.Text = "0.0";
            txtNrGuests.Text = string.Empty;
            txtInputFirstName.Text = string.Empty;
            txtInputSurname.Text = string.Empty;
            listGuests.Items.Clear();
            this.AcceptButton = btnCreateList;

            boxAddGuest.Enabled = false;
            btnDelete.Enabled = false;
        }

        private bool CheckIfPositive(String test) {
            double.TryParse(test, out double x);
            return (x>=0 );
        }

        private void btnCreateList_Click(object sender, EventArgs e)
        {
            int size;
            double cost;
            if ((int.TryParse(txtInputNrGuests.Text, out size) && CheckIfPositive(txtInputNrGuests.Text) )&& (double.TryParse(txtInputPrice.Text, out cost) && CheckIfPositive(txtInputPrice.Text)))
            {
                party = new Party(size, cost);
                boxNewParty.Enabled = false;
                boxAddGuest.Enabled = true;
                btnDelete.Enabled = true;
                this.AcceptButton = btnAddGuest;
                txtNrGuests.Text = "0";
            }
        }

        private void btnAddGuest_Click(object sender, EventArgs e)
        {
            int pos = int.Parse(txtNrGuests.Text);
            int a = party.AddGuest(txtInputFirstName.Text, txtInputSurname.Text, pos);
            if (a == -1) return;
            double amount = party.NumOfGuests() * party.Cost;
            string[] guests = party.GetGuests();

            txtNrGuests.Text = "" + a;
            listGuests.Items.Add(guests[pos]);
            txtCost.Text = "" + amount;
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (listGuests.SelectedIndex != -1) {
                int a = party.Delete(listGuests.SelectedIndex, int.Parse(txtNrGuests.Text));
                txtNrGuests.Text = "" + a;
                listGuests.Items.Clear();
                string[] guests = party.GetGuests();
                for (int i = 0; i < guests.Length; i++) {
                    if (!string.IsNullOrEmpty(guests[i])) {
                        listGuests.Items.Add(guests[i]);
                        }
                }
                //txtCost.Text = "" + party.CalcCost(a);
            }
        }
    }
}
