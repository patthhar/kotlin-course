package classes.week_01.basics;

public class JavaCode {
  public static void main(String[] args) {
    System.out.println("Hello, World!");

    String petName = "Piku";
    petName = "Togo";

    int petAge = 1;
    byte petAgeInByte = 1;
    petAge = petAgeInByte;

    petAge = DataTypesKt.getPetAgeInt();
  }
}
