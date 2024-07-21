using System;

public abstract class SuperMarket
{
    public abstract void Display();
}

public class Cloth : SuperMarket
{
    private string men = "shirt";
    private string women = "top";
    private string kids = "xyz";

    public override void Display()
    {
        Console.WriteLine("Men: " + men);
        Console.WriteLine("Women: " + women);
        Console.WriteLine("Kids: " + kids);
    }
}

public class Customer
{
    private string cname = "abc";
    private string cnumber = "123";

    public void Display()
    {
        Console.WriteLine("Customer name: " + cname);
        Console.WriteLine("Customer number: " + cnumber);
    }
}

public class Electronic
{
    private string TV = "soni";
    private string Microwave = "philips";

    public void Display()
    {
        Console.WriteLine("T.V: " + TV);
        Console.WriteLine("Microwave: " + Microwave);
    }
}

public class Food
{
    private string pericable = "fish";
    private string nonpericable = "nuts";

    public void Display()
    {
        Console.WriteLine("Pericable: " + pericable);
        Console.WriteLine("Nonpericable: " + nonpericable);
    }
}

public class Stafff
{
    private string casher = "xyz";
    private string bagger = "xyz";
    private string custodian = "xyz";

    public void Display()
    {
        Console.WriteLine("Casher: " + casher);
        Console.WriteLine("Bagger: " + bagger);
        Console.WriteLine("Custodian: " + custodian);
    }
}

public class Stationary11
{
    private string pen = "cello";
    private string books = "camlin";

    public void Display()
    {
        Console.WriteLine("Pen: " + pen);
        Console.WriteLine("Books: " + books);
    }
}

class Program
{
    static void Main()
    {
        Cloth c = new Cloth();
        Customer a = new Customer();
        Electronic b = new Electronic();
        Food f = new Food();
        Stafff d = new Stafff();
        Stationary11 e = new Stationary11();
        int x = 0;

        do
        {
            Console.WriteLine("\nList:\nPress 1: Cloth\nPress 2: Customer\nPress 3: Electronic\nPress 4: Food\nPress 5: Staff\nPress 6: Stationary\n");
            x = int.Parse(Console.ReadLine());
            switch (x)
            {
                case 1:
                    c.Display();
                    break;
                case 2:
                    a.Display();
                    break;
                case 3:
                    b.Display();
                    break;
                case 4:
                    f.Display();
                    break;
                case 5:
                    d.Display();
                    break;
                case 6:
                    e.Display();
                    break;
            }
        } while (x != 0);
    }
}