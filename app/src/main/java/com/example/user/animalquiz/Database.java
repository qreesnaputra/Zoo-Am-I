package com.example.user.animalquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 05/06/2017.
 */

public class Database extends SQLiteOpenHelper {
    final static String DB_NAME = "db_hewan";

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_hewan(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "clue1 TEXT, " +
                "clue2 TEXT, " +
                "clue3 TEXT, " +
                "pilihan1 TEXT, " +
                "pilihan2 TEXT, " +
                "pilihan3 TEXT, " +
                "pilihan4 TEXT, " +
                "jawaban TEXT, " +
                "keterangan TEXT, " +
                "image BLOB)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        values.put("clue1", "Memiliki 1 atau 2 punuk");
        values.put("clue2", "Hidup di tempat yang panas");
        values.put("clue3", "Memiliki 4 kaki");
        values.put("pilihan1", "Gajah");
        values.put("pilihan2", "Unta");
        values.put("pilihan3", "Tikus");
        values.put("pilihan4", "Kucing");
        values.put("jawaban", "Unta");
        values.put("keterangan", "Unta atau Onta adalah dua spesies hewan berkuku belah dari genus Camelus (satu berpunuk tunggal - Camelus dromedarius, \n" +
                "satu lagi berpunuk ganda - Camelus bactrianus) yang hidup ditemukan di wilayah kering dan gurun di Asia dan Afrika Utara. \n" +
                "Rata-rata umur harapan hidup unta adalah antara 30 sampai 50 tahun.");
        values.put("image", R.drawable.camel);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Air susu nya sering dikonsumsi manusia");
        values.put("clue2", "Memiliki tubuh yang besar dan 2 tanduk");
        values.put("clue3", "Hewan ternak, juga sering dijadikan hewan kurban");
        values.put("pilihan1", "Zebra");
        values.put("pilihan2", "Singa");
        values.put("pilihan3", "Kambing");
        values.put("pilihan4", "Sapi");
        values.put("jawaban", "Sapi");
        values.put("keterangan", "Sapi dapat melahirkan 1-2 anak dan juga hewan menyusui. \n" +
                "Susu dan daging sapi dapat dimanfaatkan oleh manusia sebagai makanan dan minuman. \n" +
                "Selain itu, susu sapi juga dibuat sebagai keju.");
        values.put("image", R.drawable.cow);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Hewan pemakan daging");
        values.put("clue2", "Memiliki 4 kaki dan hidup di air dan darat");
        values.put("clue3", "Berjalan dengan cara merayap");
        values.put("pilihan1", "Buaya");
        values.put("pilihan2", "Monyet");
        values.put("pilihan3", "Kuda");
        values.put("pilihan4", "Katak");
        values.put("jawaban", "Buaya");
        values.put("keterangan", "Buaya adalah hewan berdarah dingin yang tinggal di danau, sungai maupun rawa-rawa. \n" +
                "Buaya adalah hewan karnivora yang sangat berbahaya. Dalam keadaan lapar, Ia dapat menyerang apapun, \n" +
                "bahkan manusia dimakan olehnya. Buaya berkembang biak dengan cara bertelur. ");
        values.put("image", R.drawable.crocodile);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Hidup di air");
        values.put("clue2", "Bernafas dengan insang");
        values.put("clue3", "Memiliki tubuh bersisik");
        values.put("pilihan1", "Kepiting");
        values.put("pilihan2", "Ular");
        values.put("pilihan3", "Ikan");
        values.put("pilihan4", "Angsa");
        values.put("jawaban", "Ikan");
        values.put("keterangan", "Ikan hidup di air dan bernapas dengan menyerap oksigen melalui insang mereka. \n" +
                "Ikan adalah hewan berdarah dingin, sehingga suhu tubuh internal mereka dipengaruhi oleh lingkungan.\n" +
                "Banyak ikan memiliki sisik dan menggunakan sirip mereka untuk berenang. \n" +
                "Ikan memiliki tulang belakang tetapi tidak memiliki telinga eksternal atau kelopak mata. \n" +
                "Ikan juga memiliki kandung kemih udara, yang membuat mereka bertahan.");
        values.put("image", R.drawable.fish);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Hidup di tempat dingin (bersalju)");
        values.put("clue2", "Memiliki warna hitam dan putih");
        values.put("clue3", "Sejenis burung tetapi tidak dapat terbang");
        values.put("pilihan1", "Beruang");
        values.put("pilihan2", "Ayam");
        values.put("pilihan3", "Penguin");
        values.put("pilihan4", "Singa Laut");
        values.put("jawaban", "Penguin");
        values.put("keterangan", "Penguin adalah burung yang tinggal dikutub utara dengan suhu dingin,\n" +
                "Penguin mampu bertahan di kutub karena dia mempunyai bulu yang terbang,walaupun ber-inisial Burung,\n" +
                "Penguin tidak bisa terbang.");
        values.put("image", R.drawable.penguin);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Sang jantan memiliki rambut kepala yang lebat sedangkan yang betina tidak");
        values.put("clue2", "Pemakan daging");
        values.put("clue3", "Raja hutan");
        values.put("pilihan1", "Serigala");
        values.put("pilihan2", "Singa");
        values.put("pilihan3", "Panda");
        values.put("pilihan4", "Rusa");
        values.put("jawaban", "Singa");
        values.put("keterangan", "Singa adalah spesies hewan dari keluarga atau jenis kucing. \n" +
                "Singa merupakan hewan yang hidup berkelompok. Biasanya terdiri dari seekor jantan dan banyak betina.\n" +
                " Kelompok ini menjaga daerah kekuasaannya. Umur singa antara 10 sampai 15 tahun di alam bebas, \n" +
                "tetapi dalm penangkaran memungkinkan lebih dari 20 tahun. Singa betina jauh lebih aktif dalam berburu,\n" +
                " sedangkan singa jantan lebih santai bersikap menunggu dan meminta jatah dari hasil buruan para betinanya.");
        values.put("image", R.drawable.lion);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Mampu bertahan hidup hingga ratusan tahun");
        values.put("clue2", "Memiliki cangkang atau tempurung");
        values.put("clue3", "Jalannya sangat lambat");
        values.put("pilihan1", "Laba-laba");
        values.put("pilihan2", "Cumi-cumi");
        values.put("pilihan3", "Lumba-lumba");
        values.put("pilihan4", "Kura-kura");
        values.put("jawaban", "Kura-kura");
        values.put("keterangan", "Kura-kura dan penyu adalah hewan bersisik berkaki empat yang termasuk golongan reptil.\n" +
                "Kura-kura tidak memiliki gigi. Akan tetapi perkerasan tulang di moncong kura-kura sanggup memotong apa saja\n" +
                " yang menjadi makanannya. Kura-kura berkembang biak dengan bertelur (ovipar)");
        values.put("image", R.drawable.turtle);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Memiliki kantong di perutnya");
        values.put("clue2", "Dapat melompat jauh");
        values.put("clue3", "Dapat ditemukan di Benua Australia");
        values.put("pilihan1", "Kanguru");
        values.put("pilihan2", "Kelinci");
        values.put("pilihan3", "Koala");
        values.put("pilihan4", "Tapir");
        values.put("jawaban", "Kanguru");
        values.put("keterangan", "Kanguru adalah binatang yang tersebar pada daerah Australia dan daerah Papua.\n" +
                " hewan ini memiliki 4 kaki, kaki pada bagian depan lebih pendek dari pada kaki bagian belakang. \n" +
                "Fungsi kaki depan adalah untuk menyeimbangkan sedangkan kaki bagian belakang untuk berjalan.\n" +
                "Kanguru mempunyai dua kaki belakang yang kuat, telapak kakinya yang besar didesain untuk meloncat.\n" +
                " Kanguru biasa melompat dengan kecepatan 20-25 km/jam. Kangguru adalah hewan mamalia yang\n" +
                "meiliki kantung ( marsupialia ). Hewan ini termasuk hewan khas Australia");
        values.put("image", R.drawable.kangaroo);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Makanan favoritnya bambu");
        values.put("clue2", "Berbulu hitam dan putih");
        values.put("clue3", "Berasal dari China");
        values.put("pilihan1", "Sapi");
        values.put("pilihan2", "Penguin");
        values.put("pilihan3", "Panda");
        values.put("pilihan4", "Kuda");
        values.put("jawaban", "Panda");
        values.put("keterangan", "Panda adalah hewan yang hidup di china. Panda memiliki tubuh yang besar dengan\n" +
                "bulu hitam putih yang menambah keimutan dan kelucuannya. Panda adalah hewan yang baik dan mudah bergaul\n" +
                " dengan manusia tapi jika sudah merasa terancam panda bisa berubah menjadi hewan yang mengerikan.\n" +
                "Panda adalah hewan pemakan tumbuhan, tumbuhan yang menjadi makanannya adalah bambu. \n" +
                "Panda sangat menyukai bambu terutama tunas tunas dan daun bambu yang masih muda.\n" +
                "Oleh karena itu panda tidak bisa jauh jauh dari bambu.");
        values.put("image", R.drawable.pandabear);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Suka memanjat pohon");
        values.put("clue2", "Makanan favoritnya pisang");
        values.put("clue3", "Memiliki rambut, bulu, dan ekor");
        values.put("pilihan1", "Harimau");
        values.put("pilihan2", "Monyet");
        values.put("pilihan3", "Kucing");
        values.put("pilihan4", "Anjing");
        values.put("jawaban", "Monyet");
        values.put("keterangan", "Monyet adalah hewan yang pandai. Ia memiliki ekor panjang, dua kaki, dan dua tangan. \n" +
                "Monyet memiliki bulu yang sangat padat. Ia juga memiliki lengan yang panjang untuk memanjat.\n" +
                "Hampir semua spesies monyet yang ada kebanyakan hidup di daerah beriklim tropis atau subtropis.\n" +
                "Monyet adalah binatang yang bisa duduk ataupun berdiri tegak. Tidak seperti kera, monyet biasanya berekor\n" +
                "dan berukuran lebih kecil. Monyet diketahui dapat belajar dan menggunakan alat untuk membantunya dalam\n" +
                "mendapatkan makanan.");
        values.put("image", R.drawable.monkey);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Memiliki leher yang panjang");
        values.put("clue2", "Bertubuh besar dan berkaki panjang");
        values.put("clue3", "Memiliki pola bercak yg khas");
        values.put("pilihan1", "Kanguru");
        values.put("pilihan2", "Kerbau");
        values.put("pilihan3", "Beruang");
        values.put("pilihan4", "Jerapah");
        values.put("jawaban", "Jerapah");
        values.put("keterangan", "Jerapah memiliki ciri khas yang terletak pada tubuhnya yang tinggi,\n" +
                "bahkan jerapah merupakan hewan tertinggi di dunia. Tinggi jerapah jantan bisa mencapai 6 meter. \n" +
                "Yang membuat jerapah menjadi tinggi adalah lehernya. Lehernya mempunyai panjang yang bisa mencapai 1,5 meter.\n" +
                "Badan jerapah sebenarnya pendek, dengan kaki-kakinya yang kurus. Kaki depan jerapah lebih panjang daripada\n" +
                "kaki belakangnya. Jerapah memiliki tanduk kecil yang tertutup kulit di kepala mereka.\n" +
                "Tanduk jerapah jantan lebih besar daripada tanduk jerapah betina, dan tubuh jerapah jantan biasanya\n" +
                " juga lebih jangkung dibandingkan jerapah betina");
        values.put("image", R.drawable.giraffe);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Hewan yang bertubuh besar");
        values.put("clue2", "Memiliki belalai yang panjang");
        values.put("clue3", "Bertelinga lebar");
        values.put("pilihan1", "Gajah");
        values.put("pilihan2", "Kudanil");
        values.put("pilihan3", "Badak");
        values.put("pilihan4", "Jerapah");
        values.put("jawaban", "Gajah");
        values.put("keterangan", "Gajah adalah salah satu hewan yang langka. Ciri-ciri utamanya yaitu mempunyai badan yang besar, \n" +
                "telinga yang lebar, dan belalai yang panjang. Makanan gajah yaitu rumput, dedaunan, dan tumbuh-tumbuhan lainnya\n" +
                "yang dapat dicerna oleh gajah. Sekarang gajah sudah mulai punah maka dari itu kita wajib melestarikannya . \n" +
                "Gajah dapat dijumpai di kebun binatang atau tempat pariwisata hewan lainnya. Di dalam kebun binatang kita\n" +
                "dapat menikmati gajah yang termasuk hewan mamalia.");
        values.put("image", R.drawable.elephant);
        db.insert("tbl_hewan", "soal", values);

        values.put("clue1", "Bertubuh besar dan memiliki telinga yang bundar");
        values.put("clue2", "Berbulu lebat dan berekor pendek");
        values.put("clue3", "-Memiliki cakar yang panjang");
        values.put("pilihan1", "Unta");
        values.put("pilihan2", "Banteng");
        values.put("pilihan3", "Beruang");
        values.put("pilihan4", "Rusa");
        values.put("jawaban", "Beruang");
        values.put("keterangan", "Beruang memiliki ekor kecil, indra penciuman dan pendengaran yang ulung,\n" +
                "lima kuku pada telapak tangan yg tak dpt di tarik masuk, serta bulu yang panjang, lebat, kasar.\n" +
                "Beruang memiliki cakar yang lebar , moncong yang panjang, dan telinga bundar. Penglihatan beruang hampir sama\n" +
                "dengan penglihatan manusia. Jumlah giginya berfariasi sesuai dengan spasiesnya, beruang dapat memiliki\n" +
                "gigi 32 hingga 42. Beruang memiliki 4 cakar.");
        values.put("image", R.drawable.bear);
        db.insert("tbl_hewan", "soal", values);

    }

    public List<GetSoal> getSoal() {
        List<GetSoal> listSoal = new ArrayList<GetSoal>();
        String query = "SELECT * FROM tbl_hewan ORDER BY RANDOM()";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                GetSoal s = new GetSoal();
                s.setClue1(cursor.getString(1));
                s.setClue2(cursor.getString(2));
                s.setClue3(cursor.getString(3));
                s.setPilihan1(cursor.getString(4));
                s.setPilihan2(cursor.getString(5));
                s.setPilihan3(cursor.getString(6));
                s.setPilihan4(cursor.getString(7));
                s.setJawaban(cursor.getString(8));
                s.setKeterangan(cursor.getString(9));
                s.setImg(cursor.getInt(10));
                listSoal.add(s);
            } while (cursor.moveToNext());
        }

        return listSoal;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_hewan");
        onCreate(db);

    }
}
