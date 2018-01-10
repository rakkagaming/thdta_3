using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheShoppingList
{
    class ItemManager
    {
        private List<ShoppingItem> itemList;

        public ItemManager()
        {
            itemList = new List<ShoppingItem>();
        }

        public ShoppingItem GetItem(int index)
        {
            if (!CheckIndex(index))
                return null;
            return itemList[index];
        }

        public int Count
        {
            get {
                return itemList.Count;
            }
        }

        private bool CheckIndex(int index)
        {
            return ((index < Count) && (index>=0));
        }

        public bool AddItem(ShoppingItem item)
        {
            bool ok = false;
            if (item != null)
            {
                itemList.Add(item);
                ok = true;
            }

            return ok;
        }

        public bool ChangeItem(ShoppingItem item, int index)
        {
            bool ok = false;
            if (item != null && CheckIndex(index))
            {
                itemList[index] = item;
                ok = true;
            }

            return ok;
        }

        public bool DeleteItem(int index) {
            bool ok = false;
            if (CheckIndex(index))
            {
                itemList.RemoveAt(index);
                ok = true;
            }

            return ok;
        }

        public string[] GetItemInfoStrings()
        {
            string[] infoStrings = new string[itemList.Count];

            int i = 0;
            foreach (ShoppingItem obj in itemList)
            {
                infoStrings[i++] = obj.ToString();
            }

            return infoStrings;
        }
    }
}
