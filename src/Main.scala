package pl.edu.pja

import zadanie5.{Nauczyciel, Pracownik, Student}

import scala.math.abs

object Main {

  def main(args: Array[String]): Unit = {
    println("\nZadanie 1:")
    zadanie1("Niedziela")
    zadanie1("Czwartek")
    zadanie1("Poniedziałek")
    zadanie1("Test")

    println("\nZadanie 2:")
    val konto = new KontoBankowe(20)
    konto.wpłata(200)
    konto.wyplata(20)
    println("Stan konta: " + konto.stanKonta)

    println("\nadanie 3:")
    zadanie2(Osoba("Adam", "Nowak"))
    zadanie2(Osoba("William", "Windsor"))
    zadanie2(Osoba("Hellen", "Kowalska"))

    println("\nZadanie 5:")

    val osoba_pracownik = new zadanie5.Osoba("Anna", "Nowak", 22) with Pracownik {
      override protected var _pensja: Double = _

      override def podatek: Double = pensja * (super.podatek / 100)
    }
    osoba_pracownik.pensja_(2000)
    println("Podatek dla pracownika " + osoba_pracownik.imie + " z pensji " + osoba_pracownik.pensja + " to " + osoba_pracownik.podatek)

    //////////////////////////////////

    val osoba_nauczyciel = new zadanie5.Osoba("Elżbieta", "Nowak", 11) with Nauczyciel {
      override protected var _pensja: Double = _

      override def podatek: Double = pensja * (super.podatek / 100)

    }
    osoba_nauczyciel.pensja_(2000)
    println("Podatek dla  nauczyciela " + osoba_nauczyciel.imie + " z pensji " + osoba_nauczyciel.pensja + " to " + osoba_nauczyciel.podatek)

    //////////////////////////////////

    val osoba_student = new zadanie5.Osoba("Helena", "Nowak", 55) with Student {
      override def podatek: Double = super.podatek
    }
    println("Podatek dla studenta " + osoba_student.imie + " to " + osoba_student.podatek)

    //////////////////////////////////

    val osoba_pracownik_student = new zadanie5.Osoba("Wiktor", "Nowak", 23) with Pracownik with Student {
      override protected var _pensja: Double = _

      override def podatek: Double = pensja * (super.podatek / 100)
    }
    osoba_pracownik_student.pensja_(2000)
    println("Podatek dla pracownik student " + osoba_pracownik_student.imie + " z pensji " + osoba_pracownik_student.pensja + " to " + osoba_pracownik_student.podatek)

    //////////////////////////////////

    val osoba_student_pracownik = new zadanie5.Osoba("Paweł", "Nowak", 44) with Student with Pracownik {
      override protected var _pensja: Double = _

      override def podatek: Double = pensja * (super.podatek / 100)
    }
    osoba_student_pracownik.pensja_(2000)
    println("Podatek dla student pracownik  " + osoba_student_pracownik.imie + " z pensji " + osoba_student_pracownik.pensja + " to " + osoba_student_pracownik.podatek)

    //////////////////////////////////

    println("\nZadanie 4:")

    val fun_zad4_1 = fun_zad_4(2) _
    val fun_zad4_2 = fun_zad_4(fun_zad4_1(fun_as_param_4_1)) _
    val fun_zad4_3 = fun_zad_4(fun_zad4_2(fun_as_param_4_1)) _

    println("Wartość funkcji dla funkcji fun_as_param_4_1: " + fun_zad4_3(fun_as_param_4_1))

  }

  def fun_as_param_4_1(a: Int): Int = {
    a * a
  }


  def fun_zad_4(param: Int)(fun: Int => Int): Int = {
    fun(param)
  }


  def zadanie1(searchString: String): Unit = searchString match {
    case "Sobota" | "Niedziela" => println("Weekend")
    case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => println("Praca")
    case _ => println("Nie ma takiego dnia")
  }

  def zadanie2(osoba: Osoba): Unit = osoba match {
    case Osoba("Adam", _) => println("Hello, how are you Adam")
    case Osoba(_, "Windsor") => println("Your Majesty")
    case Osoba(name, _) => println("Good morning " + name)
  }


}
