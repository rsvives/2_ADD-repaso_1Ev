import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("./Archivos/juegos.dat");
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
}