using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment6
{
    class Task
    {
        private PriorityType priority;
        private String description;
        private DateTime date;


        

        public PriorityType Priority
        {
            get { return priority; }
            set
            {
                if (Enum.IsDefined(typeof(PriorityType), value))
                    priority = value;
            }
        }

        public string Description
        {
            get { return description; }
            set
            {
                if (!String.IsNullOrEmpty(value))
                    description = value;
            }
        }

        public DateTime Date
        {
            get { return date; }
            set
            {
                date = value;
            }
        }

        public Task(DateTime date, PriorityType priority, String description)
        {
            this.priority = priority;
            this.description = description;
            this.date = date;
        }

        //Fixa att ta bort underscore
        private String GetPriorityString() {
            return priority.ToString();
        }

        private String GetTimeString()
        {
            return date.ToShortTimeString();
        }

        public String ToString() {
            return $"{date.ToShortDateString(), -12}" +
                    $"{GetTimeString(),-7}" +
                    $"{GetPriorityString(),-16}" +
                    $"{description}";
        }
    }
}
