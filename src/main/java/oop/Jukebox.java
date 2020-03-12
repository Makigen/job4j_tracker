package oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже,\nПешеходы по лужам,\nА вода по асфальту рекой.\nИ неясно прохожим,\nВ этот день непогожий,\nПочему я весёлый такой.");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят.\nОдеяла и подушки ждут ребят.\nДаже сказка спать ложится,\nЧтобы ночью нам присниться.\nТы ей пожелай:\nБаю-бай.");
        } else System.out.println("Песня не найдена");
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(3);
    }
}
