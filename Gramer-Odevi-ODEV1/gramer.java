import java.util.Scanner;

public class gramer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cümleyi Giriniz: ");
        String cumle = scanner.nextLine();

        if (cumleUygunlugu(cumle)) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }

    public static boolean cumleUygunlugu(String cumle) {
        String[] kelimeler = cumle.trim().split("\\s+");

        if (kelimeler.length != 3) {
            return false;
        }

        String ozne = kelimeler[0];
        String nesne = kelimeler[1];
        String yuklem = kelimeler[2];

        String[] ozneler = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneler = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemler = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        boolean ozneUygunlugu = false;
        boolean nesneUygunlugu = false;
        boolean yuklemUygunlugu = false;

        for (String ozneKelime : ozneler) {
            if (ozne.equals(ozneKelime)) {
                ozneUygunlugu = true;
            }
        }

        for (String nesneKelime : nesneler) {
            if (nesne.equals(nesneKelime)) {
                nesneUygunlugu = true;
            }
        }

        for (String yuklemKelime : yuklemler) {
            if (yuklem.equals(yuklemKelime)) {
                yuklemUygunlugu = true;
            }
        }

        return ozneUygunlugu && nesneUygunlugu && yuklemUygunlugu;

    }
}
