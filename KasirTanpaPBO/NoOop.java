import java.util.Scanner;

public class NoOop{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan username : ");
        String user =sc.nextLine();
        System.out.println("Masukkan password : ");
        String pass =sc.nextLine();

        if (user.equals("Admin")&&pass.equals("admin")) {
            System.out.println("Selamat datang "+user+" Silahkan memilih pesanan anda");
            System.out.println("==== MAKANAN ================ MINUMAN =====");
            System.out.println("| 1. Lalapan        |     1. Jus Apel     |");
            System.out.println("| 2. Nasi Goreng    |     2. Jus Mangga   |");
            System.out.println("| 3. Ramen          |     3. Jus Alpukat  |");
            System.out.println("| 4. Pecel          |     4. Es Teh       |");
            System.out.println("| 5. Gado-gado      |     5. Es Jeruk     |");
            System.out.println("| 6. Rawon          |     6. Es Cokelat   |");
            System.out.println("| 7. Ayam bakar     |     7. Es Susu      |");
            System.out.println("| 8. Sate Ayam      |     8. Es Capuccino |");
            System.out.println("| 9. Soto           |                     |");
            System.out.println("===========================================");
            System.out.println("Pilih Makanan = ");
            String makanan = sc.nextLine();
            System.out.println("Pilih Minuman = ");
            String minuman = sc.nextLine();
            System.out.println("Jumlah makanan = ");
            int jumlahmkn = sc.nextInt();
            System.out.println("Jumlah minuman = ");
            int jumlahmnm = sc.nextInt();
            System.out.println("Total Pembelian Anda : ");
            if (makanan.equals("1")&&minuman.equals("1")) {
                int hargamkn= 15000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("2")) {
                int hargamkn= 15000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("3")) {
                int hargamkn= 15000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("4")) {
                int hargamkn= 15000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("5")) {
                int hargamkn= 15000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("6")) {
                int hargamkn= 15000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("7")) {
                int hargamkn= 15000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("1")&&minuman.equals("8")) {
                int hargamkn= 15000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("1")) {
                int hargamkn= 12000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("2")) {
                int hargamkn= 12000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("3")) {
                int hargamkn= 12000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("4")) {
                int hargamkn= 12000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("5")) {
                int hargamkn= 12000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("6")) {
                int hargamkn= 12000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("7")) {
                int hargamkn= 12000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("2")&&minuman.equals("8")) {
                int hargamkn= 12000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("1")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("2")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("3")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("4")) {
                int hargamkn= 18000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("5")) {
                int hargamkn= 18000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("6")) {
                int hargamkn= 18000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("7")) {
                int hargamkn= 18000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("3")&&minuman.equals("8")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("1")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("2")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("3")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("4")) {
                int hargamkn= 10000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("5")) {
                int hargamkn= 10000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("6")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("7")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("4")&&minuman.equals("8")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("1")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("2")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("3")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("4")) {
                int hargamkn= 10000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("5")) {
                int hargamkn= 10000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("6")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("7")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("5")&&minuman.equals("8")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("1")) {
                int hargamkn= 13000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("2")) {
                int hargamkn= 13000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("3")) {
                int hargamkn= 13000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("4")) {
                int hargamkn= 13000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("5")) {
                int hargamkn= 13000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("6")) {
                int hargamkn= 13000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("7")) {
                int hargamkn= 13000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("6")&&minuman.equals("8")) {
                int hargamkn= 13000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("1")) {
                int hargamkn= 25000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("2")) {
                int hargamkn= 25000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("3")) {
                int hargamkn= 25000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("4")) {
                int hargamkn= 25000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("5")) {
                int hargamkn= 25000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("6")) {
                int hargamkn= 25000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("7")) {
                int hargamkn= 25000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("7")&&minuman.equals("8")) {
                int hargamkn= 25000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("1")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("2")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("3")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("4")) {
                int hargamkn= 18000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("5")) {
                int hargamkn= 18000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("6")) {
                int hargamkn= 18000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("7")) {
                int hargamkn= 18000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("8")&&minuman.equals("8")) {
                int hargamkn= 18000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("1")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("2")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("3")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("4")) {
                int hargamkn= 10000;
                int hargamnm=4000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("5")) {
                int hargamkn= 10000;
                int hargamnm=5000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("6")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("7")) {
                int hargamkn= 10000;
                int hargamnm=7500;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else if (makanan.equals("9")&&minuman.equals("8")) {
                int hargamkn= 10000;
                int hargamnm=8000;
                int totalmnm=hargamnm*jumlahmnm;
                int totalmkn=hargamkn*jumlahmkn;
                System.out.println(""+totalmkn+totalmnm);
            }
            else{
                System.out.println("Masukkan nomor yang valid ^v^");
            }
        }

        else{
            System.out.println("Login gagal X_X ");
        }
    }
    
}