import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("./Archivos/juegos.dat");
        File ftext = new File("./Archivos/juegos.txt");
        RandomAccessFile raf = new RandomAccessFile("./Archivos/juegos2.txt", "rw");
        ArrayList<Juego> arrayJuegos = new ArrayList<Juego>();
        Juego juego1 = new Juego("Pokemon Rojo", 1980, "Aventura", 3, "Game Freak");
        Juego juego2 = new Juego("Minecraft", 2010, "Aventura", 3, "Mojang");
        Juego juego3 = new Juego("GTA V", 2010, "RPG", 18, "Rockstar");
        Juego juego4 = new Juego("Valorant", 2020, "Shooter", 18, "Riot");
        Juego juego5 = new Juego("Rust", 2010, "RPG", 18, "Valve");
        arrayJuegos.add(juego1);
        arrayJuegos.add(juego2);
        arrayJuegos.add(juego3);
        arrayJuegos.add(juego4);
        arrayJuegos.add(juego5);
        escribirFichero(f, arrayJuegos);
        leerFichero(f);
        escribirFicheroTexto(ftext, arrayJuegos);
        leerFicheroTexto(ftext);
        escribirAleatorio(raf, arrayJuegos, 1000);
        leerAleatorio(raf, 2, 1000);
    }
    public static void  escribirFichero(File file, ArrayList<Juego> juegos) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Juego j: juegos) {
            objectOutputStream.writeObject(j);
        }
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static void leerFichero(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try{
            while (true){
                Juego j = (Juego) objectInputStream.readObject();
                System.out.println(j);
            }
        }catch (EOFException e){
            System.out.println("Fin de fichero");
        }finally   {
            objectInputStream.close();
            fileInputStream.close();
        }
    }

    public static void escribirFicheroTexto(File file, ArrayList<Juego> juegos) throws IOException, FileNotFoundException {
        FileWriter fWriter = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        for (Juego j:juegos){
            bWriter.write(String.valueOf(j));
            bWriter.newLine();
        }
        bWriter.close();
        fWriter.close();
    }

    public static void leerFicheroTexto(File file) throws IOException{
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        try{
            String linea;
            while((linea=bReader.readLine())!=null){
                System.out.println(linea);
            }
        }catch (Exception e){
            System.out.println("Fin de leer el fichero de texto");
        }finally {
            bReader.close();
            fReader.close();
        }
    }

    public static void escribirAleatorio(RandomAccessFile raf, ArrayList<Juego> juegos, long longitud) throws IOException {
        for (Juego j:juegos) {
            StringBuffer stringBuffer = new StringBuffer(j.toString());
            stringBuffer.setLength((int) (longitud/2));
            raf.seek(raf.length());
            raf.writeChars(stringBuffer.toString());
        }
    }

    public static void leerAleatorio(RandomAccessFile raf, long order, long size) throws IOException {
        long position = order*size-size;
        raf.seek(position);
        StringBuffer dato;
        dato = new StringBuffer();
        for (int i=0; i<size/2; i++) {
            dato.append(raf.readChar());
        }
        System.out.println(dato.toString());
    }
}