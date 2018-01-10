using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment6
{
    public partial class MainForm : Form
    {
        private TaskManager taskManager;
        public MainForm()
        {
            InitializeComponent();
            InitializeGUI();
        }

        private void Button_Add_Click(object sender, EventArgs e)
        {
            Task newTask = GetTaskFromUserInputs();
            if (newTask != null)
            {
                taskManager.Add(newTask);
                UpdateGUI();
            }
        }

        private void UpdateGUI()
        {
            listTODO.Items.Clear();
            listTODO.Items.AddRange(taskManager.ListToStringArray());
        }

        private Task GetTaskFromUserInputs()
        {
            if (dateTimePicker1.Value < new DateTime(2000, 01, 01) || dateTimePicker1.Value >= new DateTime(2222, 01, 01))
            {
                MessageBox.Show("Wrong date, must be between 2000 - 2222");
                return null;
            }

            Task temp = new Task(dateTimePicker1.Value, (PriorityType)comboBox1.SelectedIndex, textBox1.Text);
            return temp;
        }

        private void Timer_Seconds_Tick(object sender, EventArgs e)
        {
            lblCurrentTime.Text = DateTime.Now.ToLongTimeString();
        }

        private void Menu_Exit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private bool ResultFromQuitDialog()
        {
            string message = "Sure to exit the program?";
            string caption = "Think Twice";
            MessageBoxButtons buttons = MessageBoxButtons.OKCancel;
            DialogResult result;

            // Displays the MessageBox.

            result = MessageBox.Show(message, caption, buttons);

            if (result == System.Windows.Forms.DialogResult.OK)
            {
                return true;
            }

            return false;
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            e.Cancel = !ResultFromQuitDialog();
        }

        private void InitializeGUI() {
            this.Text = "To Do Reminder" + "Your Name";

            comboBox1.Items.Clear();

            textBox1.Clear();

            string[] priority = Enum.GetNames(typeof(PriorityType));
            foreach (var item in priority) comboBox1.Items.Add(item.Replace("_"," "));
            comboBox1.SelectedIndex = 1;

            toolTip1.SetToolTip(dateTimePicker1, "Click to open calendar for date, write in time here");
            dateTimePicker1.Format = DateTimePickerFormat.Custom;
            dateTimePicker1.CustomFormat = "dd/MM/yyyy hh:mm";

            menuOpenFile.Enabled = false;
            menuSaveFile.Enabled = false;

            listTODO.Items.Clear();

            taskManager = new TaskManager();
        }

        private void Menu_New_Click(object sender, EventArgs e)
        {
            InitializeGUI();
        }

        private void Menu_About_Click(object sender, EventArgs e)
        {
            AboutBox1 box = new AboutBox1();
            box.ShowDialog();
        }
    }
}
