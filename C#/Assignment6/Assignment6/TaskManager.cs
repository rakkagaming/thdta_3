using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment6
{
    class TaskManager
    {
        private List<Task> taskList;

        public int Count
        {
            get { return taskList.Count(); }
        }

        public void Add(Task task) {
            taskList.Add(task);
            taskList.Sort((x, y) => x.Date.CompareTo(y.Date));
        }

        public string[] ListToStringArray() {
            string[] array = new string[Count];
            for (int i = 0; i < Count; i++) array[i] = taskList[i].ToString();
            return array;
        }

        public TaskManager() {
            taskList = new List<Task>();
        }
    }
}
