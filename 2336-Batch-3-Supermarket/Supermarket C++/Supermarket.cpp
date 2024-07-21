#include <iostream>
using namespace std;

class SuperMarket {
public:
    virtual void display() = 0;
};

class Cloth : public SuperMarket {
    string men = "shirt";
    string women = "top";
    string kids = "xyz";

public:
    void display() override {
        cout << "Men: " << men << endl;
        cout << "Women: " << women << endl;
        cout << "Kids: " << kids << endl;
    }
};

class Customer {
    string cname = "abc";
    string cnumber = "123";

public:
    void display() {
        cout << "Customer name: " << cname << endl;
        cout << "Customer number: " << cnumber << endl;
    }
};

class Electronic {
    string TV = "soni";
    string Microwave = "philips";

public:
    void display() {
        cout << "T.V: " << TV << endl;
        cout << "Microwave: " << Microwave << endl;
    }
};

class Food {
    string pericable = "fish";
    string nonpericable = "nuts";

public:
    void display() {
        cout << "Pericable: " << pericable << endl;
        cout << "Nonpericable: " << nonpericable << endl;
    }
};

class Stafff {
    string casher = "xyz";
    string bagger = "xyz";
    string custodian = "xyz";

public:
    void display() {
        cout << "Casher: " << casher << endl;
        cout << "Bagger: " << bagger << endl;
        cout << "Custodian: " << custodian << endl;
    }
};

class Stationary11 {
    string pen = "cello";
    string books = "camlin";

public:
    void display() {
        cout << "Pen: " << pen << endl;
        cout << "Books: " << books << endl;
    }
};

int main() {
    Cloth c;
    Customer a;
    Electronic b;
    Food f;
    Stafff d;
    Stationary11 e;
    int x = 0;

    do {
        cout << "\nList:\nPress 1: Cloth\nPress 2: Customer\nPress 3: Electronic\nPress 4: Food\nPress 5: Staff\nPress 6: Stationary\n";
        cin >> x;
        switch (x) {
            case 1:
                c.display();
                break;
            case 2:
                a.display();
                break;
            case 3:
                b.display();
                break;
            case 4:
                f.display();
                break;
            case 5:
                d.display();
                break;
            case 6:
                e.display();
                break;
        }
    } while (x != 0);

    return 0;
}