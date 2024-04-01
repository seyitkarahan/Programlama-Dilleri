import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Dosya adını girin: ");
		String dosyaAdi = scanner.nextLine();

		Node[] degerler = dosyayiOku(dosyaAdi);

		degerleriSirala(degerler);

		yazdir(degerler);
	}

	public static Node[] dosyayiOku(String dosyaAdi) {
		Node[] degerler = null;

		try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
			String satir;
			int sayac = 0;
			while ((satir = br.readLine()) != null) {
				sayac++;
			}

			degerler = new Node[sayac];

			br.close();
			BufferedReader br2 = new BufferedReader(new FileReader(dosyaAdi));
			int index = 0;
			while ((satir = br2.readLine()) != null) {
				int deger = Integer.parseInt(satir);
				int adres = index;
				degerler[index] = new Node(deger, adres);
				index++;
			}
			br2.close();
		} catch (IOException e) {
			System.out.println("Dosya Adı Yanlış Girildi: " + e.getMessage());
		}

		return degerler;
	}

	public static void degerleriSirala(Node[] degerler) {
		for (int i = 0; i < degerler.length - 1; i++) {
			for (int j = 0; j < degerler.length - i - 1; j++) {
				if (degerler[j].deger > degerler[j + 1].deger) {
					Node temp = degerler[j];
					degerler[j] = degerler[j + 1];
					degerler[j + 1] = temp;
				}
			}
		}
	}

	public static void yazdir(Node[] degerler) {
		for (int i = 0; i < degerler.length; i++) {
			for (Node num : degerler) {
				if (num.adres == i) {
					System.out.printf("Veri: %2d Adres: %d\t\tVeri: %2d Adres: %d\n", num.deger, num.adres,
							degerler[i].deger, degerler[i].adres);
					break;
				}
			}
		}
	}
}
