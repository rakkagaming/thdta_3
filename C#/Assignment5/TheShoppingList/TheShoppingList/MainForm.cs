using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TheShoppingList
{
    public partial class MainForm : Form
    {
        ItemManager itemManager = new ItemManager();
        public MainForm()
        {
            InitializeComponent();

            InitializeGUI();
        }

        private void InitializeGUI()
        {
            unitInput.Items.AddRange(Enum.GetNames(typeof(UnitTypes)));

            unitInput.SelectedIndex = (int)UnitTypes.piece;
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            bool success = false;

            ShoppingItem item = ReadInput(out success);
            if (success)
            {
                itemManager.AddItem(item);
                UpdateGUI();
            }
        }

        private void UpdateGUI()
        {
            listBox1.Items.Clear();
            listBox1.Items.AddRange(itemManager.GetItemInfoStrings());

        }

        private ShoppingItem ReadInput(out bool success)
        {
            success = false;

            ShoppingItem item = new ShoppingItem();

            item.Description = ReadDescription(out success);
            if (!success)
                return null;

            item.Amount = ReadAmount(out success);
            if (!success)
                return null;

            item.Unit = ReadUnit(out success);

            return item;
        }

        private UnitTypes ReadUnit(out bool success)
        {
            UnitTypes unit = UnitTypes.piece;
            success = false;

            if (!Enum.IsDefined(typeof(UnitTypes), unitInput.Text))
            {
                GiveMessage("Wrong unit!");
                //unitInput.Focus();
                //unitInput.SelectionStart = 0;
                //unit.SelectionLength = amountInput.TextLength;
            }
            else
            {
                unit = (UnitTypes)unitInput.SelectedIndex;
                success = true;
            }

            return unit;
        }

        private string ReadDescription(out bool success)
        {
            string description = string.Empty;
            success = false;

            if (string.IsNullOrEmpty(descriptionInput.Text))
            {
                GiveMessage("Wrong description!");
                descriptionInput.Focus();
                descriptionInput.SelectionStart = 0;
                descriptionInput.SelectionLength = descriptionInput.TextLength;
            }
            else
            {
                description = descriptionInput.Text;
                success = true;
            }

            return description;
        }

        private double ReadAmount(out bool success)
        {
            double amount = 0.0;
            success = false;

            if (!double.TryParse(amountInput.Text, out amount))
            {
                GiveMessage("Wrong amount!");
                amountInput.Focus();
                amountInput.SelectionStart = 0;
                amountInput.SelectionLength = amountInput.TextLength;
            }
            else
            {
                success = true;
            }

            return amount;
        }

        private void GiveMessage(string v)
        {
            MessageBox.Show(v, "Error", MessageBoxButtons.OK,MessageBoxIcon.Error);
        }

        private void BtnChange_Click(object sender, EventArgs e)
        {
            bool success = false;

            ShoppingItem item = ReadInput(out success);
            if (success)
            {
                itemManager.ChangeItem(item, listBox1.SelectedIndex);
                UpdateGUI();
            }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            itemManager.DeleteItem(listBox1.SelectedIndex);
            UpdateGUI();
        }
    }
}
