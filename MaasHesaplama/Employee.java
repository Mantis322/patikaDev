public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;


    Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;


    }

    double tax() {

        if (this.salary > 1000) {
            double salaryTax = (this.salary * 0.03);
            return salaryTax;
        } else {
            System.out.println("Vergi borcunuz yoktur.");
            return 0;
        }
    }

    int bonus() {

        if (workHours - 40 > 0) {
            int bonusHours = (workHours - 40) * 30;
            return bonusHours;
        } else {
            return 0;
        }
    }

    double raiseSalary() {
        int raiseCalc =  2021 - this.hireYear;
        double maasArtisi;
        if (raiseCalc < 10) {
            maasArtisi = (this.salary) * 0.05;
            return maasArtisi;
        } else if (raiseCalc > 9 && raiseCalc < 20) {
            maasArtisi = (this.salary) * 0.1;
            return maasArtisi;
        } else if (raiseCalc > 19) {
            maasArtisi = (this.salary) * 0.15;
            return maasArtisi;
        } else {
            System.out.println("Maaþ Artýþý Yoktur.");
            return 0;
        }

    }

    public String toString() {
        double toplam = salary - tax() + bonus() + raiseSalary();
        double vergili = salary + bonus() - tax();

        System.out.println("Adý: " + this.name);
        System.out.println("Maaþý: " + this.salary);
        System.out.println("Çalýþma Saati: " + this.workHours);
        System.out.println("Baþlangýç Yýlý: " + this.hireYear);
        System.out.println("Vergi: " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Maaþ artýþý : " + raiseSalary());
        System.out.println("Vergi ve Bonuslar ile birlikte maaþ : " + vergili);
        System.out.println("Toplam Maaþ: " + toplam);

        return null;
    }
}

