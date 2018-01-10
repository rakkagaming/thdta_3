using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheShoppingList
{
    class ShoppingItem
    {
        private double amount;
        private string description;
        private UnitTypes unit;

        public ShoppingItem() : this("unkown", 1.0, UnitTypes.piece)
        {
        }

        public ShoppingItem(String description) : this(description, 1.0, UnitTypes.piece)
        {
        }

        public ShoppingItem(String description, double amount) : this(description, amount, UnitTypes.piece)
        {
        }

        public ShoppingItem(String description, double amount, UnitTypes unit)
        {
            this.description = description;
            this.amount = amount;
            this.unit = unit;
        }

        public double Amount
        {
            get { return amount; }
            set
            {
                if (value >=0.0)
                    amount = value;
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

        public UnitTypes Unit
        {
            get { return unit; }
            set
            {
                if (Enum.IsDefined(typeof(UnitTypes), value))
                    unit = value;
            }
        }

        public override string ToString()
        {
            string text = string.Empty;
            text = $"{description,-45} {amount,6:f2} {unit,-6}";
            return text;
        }
    }
}
